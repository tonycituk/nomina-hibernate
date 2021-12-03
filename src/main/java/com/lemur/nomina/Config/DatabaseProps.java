/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonyc
 */
public class DatabaseProps {

    private Properties dbInfo;
    private Properties credentials;

    public DatabaseProps() {
        this.dbInfo = new Properties();
        this.credentials = new Properties();
    }

    public void loadDbInfo() {
        try {
            dbInfo.load(new FileInputStream("db.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseProps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseProps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadCredentials() {
        try {
            credentials.load(new FileInputStream("credentials.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseProps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseProps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUrlString() {
        String driver = dbInfo.getProperty("driver");
        String host = dbInfo.getProperty("host");
        String port = dbInfo.getProperty("port");
        String database = dbInfo.getProperty("db");

        String urlString = "jdbc:" + driver + "://" + host + ":" + port + "/" + database;
        return urlString;
    }

    public Properties getCredentials() {
        return this.credentials;
    }
    
    public static void main(String[] args) {
        DatabaseProps props = new DatabaseProps();
        props.loadCredentials();
        props.loadDbInfo();
        
        System.out.println(props.getUrlString());
        System.out.println(props.getCredentials());
    }

}
