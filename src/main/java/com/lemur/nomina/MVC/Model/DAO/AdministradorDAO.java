package com.lemur.nomina.MVC.Model.DAO;

import com.lemur.nomina.Config.Connector;
import com.lemur.nomina.Config.DatabaseProps;
import com.lemur.nomina.MVC.Model.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdministradorDAO {

    private ArrayList<Administrador> administradores;
    private Connector connector = null;

    public AdministradorDAO() {
        administradores = new ArrayList<Administrador>();
        //Code to load the urlString and the database credentials
        DatabaseProps dbProps = new DatabaseProps();
        dbProps.loadDbInfo();
        dbProps.loadCredentials();
        this.connector = new Connector(dbProps.getUrlString(), dbProps.getCredentials());
    }

    public ArrayList<Administrador> getAdministradores() {
        administradores.clear();
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM administrador;");
            while (rs.next()) {
                Administrador newAdministrador = new Administrador(rs.getInt(1), rs.getString(2), rs.getInt(3), 50);
                administradores.add(newAdministrador);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        connector.close();
        return this.administradores;
    }

    public int addAdministrador(Administrador administrador) {
        connector.connect();
        int result = 0;
        try {
            String query = "INSERT INTO `administrador` (`id`, `nombre`, `numHorasTrabajadas`) VALUES (NULL, ?, ?);";
            PreparedStatement pstmnt = connector.getConnection().prepareStatement(query);
            pstmnt.setString(1, administrador.getNombre());
            pstmnt.setInt(2, (int) administrador.getNumHorasTrabajadas());

            result = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        connector.close();
        return result;
    }

    public int updateAdministrador(Administrador administrador) {
        connector.connect();
        int result = 0;
        try {
            String query = "UPDATE administrador SET nombre = ?, numHorasTrabajadas = ? WHERE administrador.id = ?;";
            PreparedStatement pstmnt = connector.getConnection().prepareStatement(query);
            pstmnt.setString(1, administrador.getNombre());
            pstmnt.setDouble(2, administrador.getNumHorasTrabajadas());
            pstmnt.setInt(3, administrador.getId());

            result = pstmnt.executeUpdate();
            //System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        connector.close();
        return result;
    }

    public int deleteAdministrador(Administrador administrador) {
        connector.connect();
        int result = 0;
        try {
            String query = "DELETE FROM administrador WHERE administrador.id = ?;";
            PreparedStatement pstmnt = connector.getConnection().prepareStatement(query);
            pstmnt.setInt(1, administrador.getId());

            result = pstmnt.executeUpdate();
            //System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        connector.close();
        return result;
    }

    public static void main(String[] args) {
        //Test Administrador DAO
        AdministradorDAO admntdrDAO = new AdministradorDAO();
        Administrador admin = new Administrador(8, "Marie", 20, 14);
        admntdrDAO.deleteAdministrador(admin);

        System.out.println(admntdrDAO.getAdministradores());
    }
}
