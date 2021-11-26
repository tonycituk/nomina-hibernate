package com.lemur.nomina.MVC.Model.DAO;

import com.lemur.nomina.MVC.Model.Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministradorDAO {

    private ArrayList<Administrador> administradores;
    private NominaCRUD crud = null;

    public AdministradorDAO() {
        administradores = new ArrayList<Administrador>();
        this.crud = new NominaCRUD("administrador");
    }

    public ArrayList<Administrador> getAllAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        try {
            ResultSet rs = crud.getAll();
            while (rs.next()) {
                Administrador administrador = new Administrador(rs.getInt(1), rs.getString(2), rs.getDouble(3), 35);
                //System.out.println(administrador);
                administradores.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administradores;
    }

    public static void main(String[] args) {
        //Test Administrador DAO
        AdministradorDAO admnDAO = new AdministradorDAO();
        admnDAO.getAllAdministradores();
        System.out.println(admnDAO.getAllAdministradores());
        //It worksd

    }
}
