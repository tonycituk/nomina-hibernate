/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.MVC.Controller;

import com.lemur.nomina.MVC.Model.Administrador;
import com.lemur.nomina.MVC.Model.DAO.AdministradorDAO;
import java.util.ArrayList;

/**
 *
 * @author tonyc
 */
public class AdministradorController {
    AdministradorDAO administradorDAO;
    
    
    public AdministradorController(){
        administradorDAO = new AdministradorDAO();
    }
    
    
    public ArrayList<Administrador> getAllAdministradores(){
        return this.administradorDAO.getAllAdministradores();
    }
    
    
    public static void main(String[] args) {
        AdministradorController adminctrlr = new AdministradorController();
        
        System.out.println(adminctrlr.getAllAdministradores());
    }
    
}
