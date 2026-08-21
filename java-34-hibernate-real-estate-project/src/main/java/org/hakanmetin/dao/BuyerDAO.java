package org.hakanmetin.dao;

import org.hakanmetin.model.Buyer;
import org.hakanmetin.model.Property;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BuyerDAO {

    //JPA / Hibernate --> Save/Persist Get Update Delete
    // CRUD ------>    Create   Read  Update Delete
    // DB SQL ----->   Insert   Select Update Delete


    //degisiklik yaptigimda Transaction a ihtiyamiz var (silme, ekleme, düzenleme)
    public void saveBuyer(Buyer buyer){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                session.persist(buyer);

                tx.commit();

            } catch (RuntimeException exception) {

                if (tx.isActive()) {
                    tx.rollback();
                }

                throw exception;
            }
        }
    }

    public void updateBuyer(Buyer buyer){

        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.merge(buyer); //UPDATE


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
    public Buyer getBuyerFindById(int buyerId){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.find(Buyer.class, buyerId);

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }


    public List<Buyer> getBuyerFindAll(){
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.createQuery("from Buyer").list();

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }

    //bei delete muss man zuerst den Inhalt finden, dann löschen
    public boolean deleteBuyerById(int buyerId){
        Transaction tx = null;
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            tx = session.beginTransaction();
            Buyer buyer = session.find(Buyer.class, buyerId);
            if (buyer == null) {
                tx.commit();
                System.out.println("Buyer not found");
                return false;
            }

            session.remove(buyer);

            tx.commit();

            System.out.println("Buyer deleted successfully");
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

