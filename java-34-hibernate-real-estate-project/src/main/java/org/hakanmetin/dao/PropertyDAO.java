package org.hakanmetin.dao;

import org.hakanmetin.model.Property;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PropertyDAO {

    //JPA / Hibernate --> Save/Persist Get Update Delete
    // CRUD ------>    Create   Read  Update Delete
    // DB SQL ----->   Insert   Select Update Delete
    //

    /*
    *
Session öffnen
    ↓
Transaction starten
    ↓
persist
    ↓
Fehler?
 ┌─────────────┐
 nein          ja
 ↓             ↓
commit       rollback
 └──────┬──────┘
        ↓
Session schließen
    *
    * */

    //degisiklik yaptigimda Transaction a ihtiyamiz var (silme, ekleme, düzenleme)
    public void saveProperty(Property property){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                session.persist(property);

                tx.commit();

            } catch (RuntimeException exception) {

                if (tx.isActive()) {
                    tx.rollback();
                }

                throw exception;
            }
        }
    }

    public void updateProperty(Property property){

        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.merge(property); //UPDATE


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
    public Property getPropertyFindById(int propertyId){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.find(Property.class, propertyId);

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }


    public List<Property> getPropertyFindAll(){
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.createQuery("from Property").list();

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }

    //bei delete muss man zuerst den Inhalt finden, dann löschen
    public boolean deletePropertyById(int propertyId){
        Transaction tx = null;
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            tx = session.beginTransaction();
            Property property = session.find(Property.class, propertyId);
            if (property == null) {
                tx.commit();
                System.out.println("Property not found");
                return false;
            }

            session.remove(property);

            tx.commit();

            System.out.println("Property deleted successfully");
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

