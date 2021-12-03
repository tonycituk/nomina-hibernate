package com.lemur.nomina.Config;

import java.sql.Connection;
// jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword"
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private Connection conn = null;
    private String urlString;
    private Properties credentials;
    
   
    public Connector(String urlString, Properties credentials) {
        this.urlString = urlString;
        this.credentials = credentials;
    }

    public Connector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(this.urlString, this.credentials);
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
    
    public static void main(String[] args){
        DatabaseProps props = new DatabaseProps();
        props.loadDbInfo();
        props.loadCredentials();
        
        Connector connector = new Connector(props.getUrlString(), props.getCredentials());
        connector.connect();
        connector.close();
    }

}
