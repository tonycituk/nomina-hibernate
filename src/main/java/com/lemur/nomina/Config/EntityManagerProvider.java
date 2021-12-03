/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.Config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tonyc
 */
public class EntityManagerProvider {
    
    public static final String DEFAULT_PERSISTENCE_UNIT = "defaultPersistenceUnit";

    private static Map<String, EntityManagerFactory> entityManagerFactories = new HashMap<>();

    private EntityManagerProvider() {
    }

    /**
     * <p>
     * Provide an open {@see EntityManager} related to a persistence unit.
     * </p>
     *
     * @param persistenceUnitName name of persistence unit in persistence.xml.
     * @return the {@see EntityManager}.
     */
    public static EntityManager open(String persistenceUnitName) {
        return obtainEntityManagerFactory(persistenceUnitName).createEntityManager();
    }

    private static EntityManagerFactory obtainEntityManagerFactory(String persistenceUnitName) {
        if (entityManagerFactories.containsKey(persistenceUnitName)) {
            return entityManagerFactories.get(persistenceUnitName);
        }

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(persistenceUnitName);
        entityManagerFactories.put(persistenceUnitName, entityManagerFactory);

        return entityManagerFactory;
    }
    
}
