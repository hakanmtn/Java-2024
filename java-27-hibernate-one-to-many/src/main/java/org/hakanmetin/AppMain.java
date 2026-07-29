package org.hakanmetin;


import org.hakanmetin.entity.CustomerDetail;
import org.hakanmetin.entity.Customers;
import org.hakanmetin.entity.Orders;
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

        CustomerDetail detail1 = new CustomerDetail();
        detail1.setAddress("Ankara");
        detail1.setPhone("124441222");
        detail1.setEmail("ankara@gmail.com");
        detail1.setCreateDate(new Date());

        detail1.setCustomer(customers1);
        customers1.setCustomerDetail(detail1);



        Customers customers2 = new Customers("Alex" , "Ferguson");

        CustomerDetail detail2 = new CustomerDetail();
        detail2.setAddress("München");
        detail2.setPhone("5325326234");
        detail2.setEmail("mkkra@gmail.com");
        detail2.setCreateDate(new Date());

        detail2.setCustomer(customers2);
        customers2.setCustomerDetail(detail2);

        Orders orders1 = new Orders();
        orders1.setProductName("Elma");
        orders1.setProductCode("4343J");
        orders1.setProductPrice(BigDecimal.valueOf(50.25));
        orders1.setCreateDate(new Date());

        Orders orders2 = new Orders();
        orders2.setProductName("Erik");
        orders2.setProductCode("4654J");
        orders2.setProductPrice(BigDecimal.valueOf(55.25));
        orders2.setCreateDate(new Date());

        Orders orders3 = new Orders();
        orders3.setProductName("Mehl");
        orders3.setProductCode("42R4J");
        orders3.setProductPrice(BigDecimal.valueOf(25.45));
        orders3.setCreateDate(new Date());


        customers1.getOrders().add(orders1);
        customers1.getOrders().add(orders2);

        customers2.getOrders().add(orders3);

        orders1.setCustomer(customers1);
        orders2.setCustomer(customers1);

        orders3.setCustomer(customers2);

        System.out.println(customers1);
        System.out.println(customers2);

        // Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
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



