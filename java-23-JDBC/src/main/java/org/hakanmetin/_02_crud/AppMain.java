package org.hakanmetin._02_crud;

import java.sql.SQLException;

public class AppMain {
    public static void main(String[] args) throws SQLException {

        MyCrud myCrud = new MyCrud();
        myCrud.getAllClients();

        System.out.println("*******************");

        myCrud.getAllClientsOlderThan25();


    }
}
