package org.hakanmetin.util;

//Javayi Datenbankla bagliyor

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY =
            createSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory createSessionFactory() {
        try {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Exception exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        SESSION_FACTORY.close();
    }
}




/*

public class HibernateUtil {

    private static ServiceRegistry serviceRegistry;

    static{

        try{
            Configuration configuration=new Configuration();
            configuration.configure();

            serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.buildSessionFactory(serviceRegistry);

        }catch(Exception e){
            System.err.println("Exception : "+e);
        }

    }

    public static SessionFactory getSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }

}
*/