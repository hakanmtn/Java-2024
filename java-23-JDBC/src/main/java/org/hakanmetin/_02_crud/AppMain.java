package org.hakanmetin._02_crud;


import java.sql.SQLException;


public class AppMain {

    static final String SQL_ALL_CUSTOMERS = "SELECT * FROM my_company_db.customers" ;
    static final String SQL_GREATER_THAN_25 = "SELECT * FROM my_company_db.customers" + " WHERE \"AGE\"  > 25";
    static  final String SQL_CUSTOMER_AGE_UPDATE = "UPDATE my_company_db.customers " +
            "SET " + " \"FIRST_NAME\" = 'Mason', "
            + " \"LAST_NAME\" = 'Greenwood', "
            + " \"AGE\" = 26 ,"
            + "  \"COUNTRY\"  = 'EN' "
            + " WHERE \"CUSTOMER_ID\"  = 10" ;

    static final String SQL_CUSTOMER_ADD_NEW = "INSERT INTO my_company_db.customers( " +
            " \"FIRST_NAME\", \"LAST_NAME\", \"AGE\", \"COUNTRY\", \"EMAIL\", \"GENDER\") " +
            " VALUES ('Nilson', 'Ake', 27, 'EN', 'n.ake@ake.com', 'M')" ;

    static final String SQL_CUSTOMER_DELETE = "DELETE FROM my_company_db.customers WHERE \"CUSTOMER_ID\" = 105";


    public static void main(String[] args) throws SQLException {

        MyCrud myCrud = new MyCrud();

        System.out.println("-------**READ**--------");
        // myCrud.getFromTableAll(SQL_ALL_CUSTOMERS);

        System.out.println("--------------");


       // myCrud.getFromTableGretaterThan25(SQL_GREATER_THAN_25);
        System.out.println("--------------");

        // myCrud.updateCustomerFromID(SQL_CUSTOMER_AGE_UPDATE);

        //myCrud.addNewCustomer(SQL_CUSTOMER_ADD_NEW);

        myCrud.deleteCustomerFromID(SQL_CUSTOMER_DELETE);




    }
}
