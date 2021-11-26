package com.lemur.nomina.MVC.Model.DAO;


import com.lemur.nomina.Config.Connector;
import com.lemur.nomina.MVC.Model.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private Connector connector  = null;

    public EmpleadoDAO(Connector connector){
        this.connector = connector;
    }
    
    public void getEmpleados(){
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM empleados;");

            while (rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.close();
    }
}
