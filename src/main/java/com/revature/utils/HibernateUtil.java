package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 * I decided to use Hibernate in place of JDBC for this project.
 * Remember how we had to make a Connection "conn" using the Connection Class(?)
 * in order to connect our Java code/SQL command to the db to have our daos/repository layer
 * functionality. But NOW...using Hibernate:
 * SessionFactory and Sessions will take the place of Connection
 * so that we can make out connection to the database
 */
public class HibernateUtil {

	//SessionFactory interface = used to get a Session
	//Only one session in this application - a singleton!
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	
	//trying to get this merge() down
	private static StandardServiceRegistry registry;
	 
	
	//Sessions manage our actual connection to the database
	//Gets us a Session object using the SessionFactory interface
	private static Session session;
	
	
	public static Session getSession() {
		if (session == null ) {
			session = sessionFactory.openSession();
		}
		return session;
	}//if there's no session, get one and retuen teh session object
	
	
	public static void closeSession() {
		session.close();
		session = null;
	}//methods that closes the Session object "session"(and sets it to null) to prevent any memory leaks
	
	
	
	
	
	
	
	
	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
	
	
	
	
	
	
}//class
