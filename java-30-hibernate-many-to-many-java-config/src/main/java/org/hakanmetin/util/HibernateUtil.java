package org.hakanmetin.util;

import org.hakanmetin.entity.Address;
import org.hakanmetin.entity.Customers;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY =
            createSessionFactory();

    public static SessionFactory createSessionFactory() {

        if (SESSION_FACTORY == null) {

            try {
                Configuration configuration = new Configuration();


                Properties settings = new Properties();


                // MYSQL
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/companydb?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Hakan.01");
                //settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");


 /*
                // PostgreSQL
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/companydb");
                // settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres?currentSchema=companydb");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "HAkan.01");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
*/
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Customers.class);
                configuration.addAnnotatedClass(Address.class);



                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return SESSION_FACTORY;
    }

    public static void shutdown() {
        SESSION_FACTORY.close();
    }
}