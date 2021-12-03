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
        return this.administradorDAO.getAdministradores();
    }
    
    public int addAdmin(Administrador administrador){
        return this.administradorDAO.addAdministrador(administrador);
    }
    
    public int updateAdministrador(Administrador administrador){
        return this.administradorDAO.updateAdministrador(administrador);
    }
    
    public int deleteAdministrador(Administrador administrador){
        return this.administradorDAO.deleteAdministrador(administrador);
    }
    
    public static void main(String[] args) {
        AdministradorController adminctrlr = new AdministradorController();
        
        System.out.println(adminctrlr.getAllAdministradores());
    }
    
}
