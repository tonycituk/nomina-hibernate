package com.lemur.nomina.Config;

import java.sql.Connection;
// jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword"
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private Connection conn = null;
    String urlString;

    public Connector(String urlString) {
        this.urlString = urlString;
    }
    public Connector() {
        PropertiesDB dbprops = new PropertiesDB();
        this.urlString = dbprops.getUrlString();
    }


    public void connect() {
        try {
            this.conn = DriverManager.getConnection(this.urlString);
            //System.out.println("Success Connection \n");
        } catch (SQLException ex) {
            // handle errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void close(){
        try {
            this.conn.close();
            //System.out.println("Closed connection \n");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConnection(){
        return this.conn;
    }
    
    public static void main(String[] args) {
        Connector connctr = new Connector();
        connctr.connect();
        connctr.close();
    }

}
