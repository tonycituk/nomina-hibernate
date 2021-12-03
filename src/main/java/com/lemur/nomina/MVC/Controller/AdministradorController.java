/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.MVC.Controller;

import com.lemur.nomina.Config.EntityManagerProvider;
import com.lemur.nomina.MVC.Model.Administrador;
import com.lemur.nomina.MVC.Model.DAO.AdministradorDAO;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author tonyc
 */
public class AdministradorController {

    private AdministradorDAO administradorDAO;

    public AdministradorController() {
        EntityManager defaultEntityManager = EntityManagerProvider
                .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);

        administradorDAO = new AdministradorDAO(defaultEntityManager);
    }

    public ArrayList<Administrador> getAllAdministradores() {
        return this.administradorDAO.findAll();
    }

    public void addAdministrador(Administrador administrador) {
        this.administradorDAO.create(administrador);
    }

    public void updateAdministrador(Administrador administrador) {
        this.administradorDAO.update(administrador);
    }

    public void deleteAdministrador(Administrador administrador) {
        this.administradorDAO.delete(administrador);
    }

    public static void main(String[] args) {
        AdministradorController adminctrlr = new AdministradorController();
        Administrador newAdministrador = new Administrador("Teo", 0.0, 0.0, 0.0);
        adminctrlr.addAdministrador(newAdministrador);

        System.out.println(adminctrlr.getAllAdministradores());
    }

}
