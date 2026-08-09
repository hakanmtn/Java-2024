package org.hakanmetin;


import org.hakanmetin.entity.Address;
import org.hakanmetin.entity.Customers;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;


public class AppMain
{
    public static void main( String[] args )
    {

        Customers customers1 = new Customers( "Mathias", "Ferg");

        Customers customers2 = new Customers("Alex" , "Ferguson");

        Address address1 = new Address();
        address1.setCountry("Deutschland");
        address1.setCity("Berlin");
        address1.setStreet("123 Main Street");
        address1.setState("Berlin");
        address1.setZip("435552");

        Address address2 = new Address();
        address2.setCountry("Deutschland");
        address2.setCity("München");
        address2.setStreet("Leopald Street");
        address2.setState("Bayern");
        address2.setZip("342343");

        Address address3 = new Address();
        address3.setCountry("Deutschland");
        address3.setCity("Berlin");
        address3.setStreet("Karlsplatz Street");
        address3.setState("Berlin");
        address3.setZip("435589");


       customers1.getAddresses().add(address1);
       customers1.getAddresses().add(address2);
       customers1.getAddresses().add(address3);

       customers2.getAddresses().add(address1);
       customers2.getAddresses().add(address2);

        // Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(customers1);
            session.persist(customers2);

            tx.commit();
            System.out.println("Nach dem Speichern:");
            System.out.println(customers1);
            System.out.println(customers2);

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            if (tx != null && tx.isActive()) {
                /*
                *
                * Warum rollback()?
                *  Falls zwischen beginTransaction() und commit() ein Fehler entsteht,
                *  ist die Transaktion noch aktiv oder fehlerhaft:
                * */

                tx.rollback();
                //Ohne Rollback bleibt die Transaktion bis zum Schließen der Session unvollständig.
            }

        }finally {
            HibernateUtil.shutdown();
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



