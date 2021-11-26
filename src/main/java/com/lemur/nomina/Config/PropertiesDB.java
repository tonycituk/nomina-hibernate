package com.lemur.nomina.Config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDB {
    private Properties prop;
    
    public PropertiesDB(){
        this.prop = new Properties();
        try {
            prop.load(new FileInputStream("data.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrlString(){

        String drvr = prop.getProperty("driver");
        String user = prop.getProperty("username");
        String pass = prop.getProperty("password");
        String host = prop.getProperty("host");
        String dbnm = prop.getProperty("db");

        String urlString = "jdbc:" + drvr + "://" + host + "/" + dbnm + "?user=" + user + "&password=" + pass;
        return urlString;
    }

    public static void main(String[] args) {
        //Just to test the properties
        //PropertiesDB dbprops = new PropertiesDB();
    }



}
