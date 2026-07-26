package org.hakanmetin;


import org.hakanmetin.entity.Address;
import org.hakanmetin.entity.Customers;
import org.hakanmetin.entity.Workers;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain
{
    public static void main( String[] args )
    {

        Customers customers1 = new Customers();

        Address address1 = new Address();
        address1.setStreet("Leopoldstr.1 ");
        address1.setCity("Munich");
        address1.setState("Bayern");
        address1.setCountry("Germany");

        Address address2 = new Address();
        address2.setStreet("Karlsplatz 13 ");
        address2.setCity("Augsburg");
        address2.setState("Bayern");
        address2.setCountry("Germany");


        //customers1.setCustomer_id(1);
        customers1.setFirst_name("Mathias");
        customers1.setLast_surname("Ferg");
        //customers1.setAddress("Ankara Ayranci");
        customers1.setCreateDate(new Date());
        customers1.setAddress(address2);

        Customers customers2 = new Customers("Alex" , "Ferguson");
        //customers2.setAddress("Istanbul Esenler");
        customers2.setCreateDate(new Date());
        customers2.setAddress(new Address("Türkiye", "Bostanlar Caddesi 2", "Adana", "", "65433"));

        System.out.println(customers1);
        System.out.println(customers2);

        Workers workers1 = new Workers();
        workers1.setFirst_name("Hakan");
        workers1.setLast_surname("Metin");
        workers1.setCreateDate(new Date());
        workers1.setAge(30);
        workers1.setEmail("hakanmetin@hakanmetin.com");
        workers1.setAddress(address1);


        // Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(customers1);
            session.persist(customers2);
            session.persist(workers1);
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



