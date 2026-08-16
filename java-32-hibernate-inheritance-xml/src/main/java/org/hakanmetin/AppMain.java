package org.hakanmetin;


import org.hakanmetin.entity.Employee;
import org.hakanmetin.entity.Owner;
import org.hakanmetin.entity.Person;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import java.util.Date;


public class AppMain
{
    public static void main( String[] args )
    {

        Person person1 = new Person("Natalie","Weiss");

        Employee employee1 = new Employee("Hakan","Metin", "München", "12122", "abc@gmail.com", 12222, new Date(), 12);

        Owner owner1 = new Owner("Ahmet", "Metin", "Oregon street", "Finance" );

        SessionFactory sessionFactory = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();

            try (Session session = sessionFactory.openSession()) {
                tx = session.beginTransaction();

                session.persist(person1);
                session.persist(employee1);
                session.persist(owner1);

                tx.commit();
            }

        } catch (Throwable exception) {
            exception.printStackTrace();

            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }


    }
}

/*
*
*
* Programm startet
→ SessionFactory wird einmal erstellt
→ Session wird geöffnet
→ Transaktion wird gestartet
→ Customers werden gespeichert
→ Transaktion wird committed
→ Session wird automatisch geschlossen
→ SessionFactory wird geschlossen
→ Programm endet
*
* */



