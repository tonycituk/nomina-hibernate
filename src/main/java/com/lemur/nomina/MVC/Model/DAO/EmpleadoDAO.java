package com.lemur.nomina.MVC.Model.DAO;

import com.lemur.nomina.Config.Connector;
import com.lemur.nomina.Config.DatabaseProps;
import com.lemur.nomina.MVC.Model.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {

    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private Connector connector = null;

    public EmpleadoDAO() {
        //Code to load the urlString and the database credentials
        DatabaseProps dbProps = new DatabaseProps();
        dbProps.loadDbInfo();
        dbProps.loadCredentials();
        this.connector = new Connector(dbProps.getUrlString(), dbProps.getCredentials());
    }

    public void getEmpleados() {
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM administrador;");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.close();
    }
}
