package org.hakanmetin;



import org.hakanmetin.entity.Customers;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain
{
    public static void main( String[] args )
    {

        Customers customers1 = new Customers();
        //customers1.setCustomer_id(1);
        customers1.setFirst_name("Mathias");
        customers1.setLast_surname("Ferg");

        Customers customers2 = new Customers("Alex" , "Ferguson");

        System.out.println(customers1);
        System.out.println(customers2);


        //Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
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



