package org.hakanmetin;


import org.hakanmetin.entity.Customers;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain
{
    public static void main( String[] args )
    {

        Customers customers1 = new Customers();
        customers1.setCustomer_id(1);
        customers1.setFirst_name("Mathias");
        customers1.setLast_surname("Ferg");

        Customers customers2 = new Customers(2,"Alex" , "Ferguson");

        System.out.println(customers1);
        System.out.println(customers2);


        Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try {
            tx = session.beginTransaction();
            session.persist(customers1);
            session.persist(customers2);
            tx.commit();

        }catch (HibernateError error){
            System.out.println("Info: " + error.getMessage());
        }
    }
}
