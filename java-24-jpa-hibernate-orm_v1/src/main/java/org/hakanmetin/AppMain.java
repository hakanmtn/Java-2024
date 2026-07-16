package org.hakanmetin;

import org.hakanmetin.entities.Customer;
import org.hakanmetin.utils.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AppMain
{
    public static void main( String[] args )
    {

        Customer customer1 = new Customer(1,"Hakan" , "Metin");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Natalie");
        customer2.setLastName("Weiss");

        System.out.println(customer1);
        System.out.println(customer2);


        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;


        try{
            tx = session.beginTransaction();
            session.save(customer1);  // Tabloya ekliyoruz. --> insert
            session.save(customer2);  // Ayni sekilde
            tx.commit();

        }catch (HibernateError e){
            System.out.println("Error: " + e.getMessage());
        }


        }

}
