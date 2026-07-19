package org.hakanmetin._02_crud;


import java.sql.SQLException;


public class AppMain {

    public static void main(String[] args) throws SQLException {

        MyCrud myCrud = new MyCrud();

        System.out.println("-------**READ**--------");
        // myCrud.getFromTableAll();

        System.out.println("--------------");


       // myCrud.getFromTableGretaterThan25();
        System.out.println("--------------");

        // myCrud.updateCustomerFromID();

        //myCrud.addNewCustomer();

        myCrud.deleteCustomerFromID();




    }
}
