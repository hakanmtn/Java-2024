package org.hakanmetin.dao;

import org.hakanmetin.model.Property;
import org.hakanmetin.model.Seller;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SellerDAO {

    //JPA / Hibernate --> Save/Persist Get Update Delete
    // CRUD ------>    Create   Read  Update Delete
    // DB SQL ----->   Insert   Select Update Delete


    public void saveSeller(Seller seller){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                session.persist(seller);

                tx.commit();

            } catch (RuntimeException exception) {

                if (tx.isActive()) {
                    tx.rollback();
                }

                throw exception;
            }
        }
    }

    public void updateSeller(Seller seller){

        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.merge(seller); //UPDATE


            tx.commit();


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

        }

    }

    //Nur lesen - deshalb hier brauchen wir keinen Transaction
    public Seller getSellerFindById(int sellerId){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.find(Seller.class, sellerId);

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }


    public List<Seller> getSellerFindAll(){
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.createQuery("from Seller").list();

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }

    //bei delete muss man zuerst den Inhalt finden, dann löschen
    public boolean deleteSellerById(int sellerId){
        Transaction tx = null;
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            tx = session.beginTransaction();
            Seller seller = session.find(Seller.class, sellerId);

            if (seller == null) {
                tx.commit();
                System.out.println("Seller not found");
                return false;
            }

            session.remove(seller);

            tx.commit();

            System.out.println("Seller deleted successfully");
            return true;
        }catch (RuntimeException exception){

            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Info: " + exception.getMessage());
            return false;
        }
    }
}

