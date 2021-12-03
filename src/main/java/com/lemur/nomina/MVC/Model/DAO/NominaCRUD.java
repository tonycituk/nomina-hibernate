/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.MVC.Model.DAO;

import com.lemur.nomina.Config.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tonyc
 */
public class NominaCRUD {

    private String tableName;
    private Connector cnnctr;

    public NominaCRUD(String tableName) {
        this.tableName = tableName;
       // this.cnnctr = new Connector();
    }

    public ResultSet getAll() {
        cnnctr.connect();
        ResultSet rs = null;
        try {
            Statement stmnt = cnnctr.getConnection().createStatement();
            rs = stmnt.executeQuery("SELECT * FROM " + tableName + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cnnctr.close();
        return rs;
    }

}
