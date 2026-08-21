package org.hakanmetin.dao;

import org.hakanmetin.model.Agent;
import org.hakanmetin.model.Property;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AgentDAO {

    //JPA / Hibernate --> Save/Persist Get Update Delete
    // CRUD ------>    Create   Read  Update Delete
    // DB SQL ----->   Insert   Select Update Delete


    public void saveAgent(Agent agent){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                session.persist(agent);

                tx.commit();

            } catch (RuntimeException exception) {

                if (tx.isActive()) {
                    tx.rollback();
                }

                throw exception;
            }
        }
    }

    public void updateAgent(Agent agent){

        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.merge(agent); //UPDATE


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
    public Agent getAgentFindById(int agentId){

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.find(Agent.class, agentId);

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }


    public List<Agent> getAgentFindAll(){
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            return session.createQuery("from Agent").list();

        }catch (RuntimeException exception){
            System.out.println("Info: " + exception.getMessage());
            return null;
        }
    }

    //bei delete muss man zuerst den Inhalt finden, dann löschen
    public boolean deleteAgentById(int agentId){
        Transaction tx = null;
        try(Session session = HibernateUtil.createSessionFactory().openSession()) {

            tx = session.beginTransaction();
            Agent agent = session.find(Agent.class, agentId);

            if (agent == null) {
                tx.commit();
                System.out.println("Agent not found");
                return false;
            }

            session.remove(agent);

            tx.commit();

            System.out.println("Agent deleted successfully");
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
