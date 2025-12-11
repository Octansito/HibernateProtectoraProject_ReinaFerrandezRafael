package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Proporciona sesiones de Hibernate para todo el proyecto y cierra los recursos al finalizar.
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){}
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
    private static SessionFactory buildSessionFactory(){

        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }
}
