package org.hakanmetin;



import org.hakanmetin.entity.CustomerDetail;
import org.hakanmetin.entity.Customers;
import org.hakanmetin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class AppMain
{
    public static void main( String[] args )
    {

        Customers customers1 = new Customers( "Mathias", "Ferg");
        customers1.setAge((short) 34);

        CustomerDetail detail1 = new CustomerDetail();
        detail1.setAddress("Ankara");
        detail1.setPhone("124441222");
        detail1.setEmail("ankara@gmail.com");
        detail1.setCreateDate(LocalDate.now());

        detail1.setCustomer(customers1);
        customers1.setCustomerDetail(detail1);



        Customers customers2 = new Customers("Alex" , "Ferguson");
        customers2.setAge((short) 22);

        CustomerDetail detail2 = new CustomerDetail();
        detail2.setAddress("München");
        detail2.setPhone("5325326234");
        detail2.setEmail("mkkra@gmail.com");
        detail2.setCreateDate(LocalDate.now());

        detail2.setCustomer(customers2);
        customers2.setCustomerDetail(detail2);


        Customers customers3 = new Customers("Natalie" , "Weiss");
        customers3.setAge((short) 21);

        CustomerDetail detail3 = new CustomerDetail();
        detail3.setAddress("München");
        detail3.setPhone("25323231");
        detail3.setEmail("nateate@gmail.com");
        detail3.setCreateDate(LocalDate.now());

        detail3.setCustomer(customers3);
        customers3.setCustomerDetail(detail3);


        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);

        // Session session = HibernateUtil.getSessionFactory().openSession();// Veri tabanina baglanti kuruyor
        Transaction tx = null; // bir islem baslar, bitene kadar devam eder

        try(Session session = HibernateUtil.createSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(customers1);
            session.persist(customers2);
            session.persist(customers3);


            //HQL amaci Javaci Database e gitmesin isini burada yapsin
            System.out.println("=========SELECT==========");

            Query query = session.createQuery("from Customers ");

            List<Customers> customers = query.list();

            for (Customers customer : customers) {
                System.out.println(customer.getFirst_name() + " " + customer.getLast_surname() );
            }

            System.out.println("======WHERE=========");

            query = session.createQuery("from Customers WHERE customer_id = 3 ");
            customers = query.list();
            for (Customers customer : customers) {
                System.out.println(customer.getFirst_name() + " " + customer.getLast_surname() );
            }

            System.out.println("======SELECT WHERE=========");

            Scanner myobj = new Scanner(System.in);
            System.out.println("Enter Customer ID: ");

            String customerId = myobj.nextLine();
            System.out.println("customerId: " + customerId);

            query = session.createQuery("from Customers WHERE customer_id = :customerId")
                           .setParameter("customerId", customerId);
            customers = query.list();

            if (customers.size() > 0) {
                for (Customers customer : customers) {
                    System.out.println(customer.getFirst_name() + " " + customer.getLast_surname() );
                }
            }else{
                System.out.println("No customers found");
            }

            System.out.println("======DELETE=========");

            myobj = new Scanner(System.in);
            System.out.println("Enter Customer ID: ");

            customerId = myobj.nextLine();
            System.out.println("customerId: " + customerId);

            query = session.createQuery("Delete from CustomerDetail WHERE customerId = :customerId")
                    .setParameter("customerId", customerId);

            int queryResult = query.executeUpdate();



            if (customers.size() > 0) {
                for (Customers customer : customers) {
                    System.out.println(customer.getFirst_name() + " " + customer.getLast_surname() );
                }
            }else{
                System.out.println("No customers found");
            }

            System.out.println("====COUNT AVG MAX MIN SUM====");

            query = session.createQuery("select count(*), max(age), min(age), SUM(age), AVG(age)  from Customers ");

            List<Object[]> objects = query.list();

            for (Object[] row : objects) {
                System.out.println(row[0] + " " + row[1] + " " + row[2]+ " " + row[3] + " " + row[4]);
            }


            System.out.println("===== JOIN ====");

            /*
            *
            * SELECT  * FROM
            * TABLE A     JOIN   TABLE B
            * ON A.id = B.id
            *
            *
            * */

            Query<Customers> queryForJoin = session.createQuery("select c from Customers c " +
                    " LEFT JOIN FETCH  c.customerDetail cd ", Customers.class);
            System.out.println(queryForJoin.getResultList());

            List<Customers> customersJoin = queryForJoin.getResultList();

            for (Customers customer : customersJoin) {
                System.out.println(customer);
                System.out.println(customer.getCustomerDetail());
            }



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



