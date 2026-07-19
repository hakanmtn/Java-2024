package org.hakanmetin._02_crud;


import java.sql.*;

///CRUD Create (Olustur), Read , Update , Delete
public class MyCrud {


    private Connection conn = null; //DB ile Baglanti kurmak icin
    private PreparedStatement statement = null; // Parametreli Statementlar SQL cümleleri
    private ResultSet resultSet = null; //SQL Sorgularinin Sonuclari


    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "HAkan.01";


    private boolean isOpenConnection() {
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return true;
        }catch(SQLException e){
            System.out.println("Fehler" + e);
            return false;
        }
    }

    private boolean isCloseConnection() {
        if (conn != null) {
            try {
                conn.close();
                return true;

            }catch (SQLException e) {
                throw new RuntimeException();

            }
        }
        // FIXME Kontralliere!
        return false;
    }

    // SELECT - READ
        public void getFromTableAll(String SQL_ALL_CUSTOMERS) throws SQLException {

            if (isOpenConnection()) {
                System.out.println("Connecting to database...");
                statement = conn.prepareStatement(SQL_ALL_CUSTOMERS);
                resultSet = statement.executeQuery();

            }


            while(resultSet.next()){
                System.out.println(resultSet.getString("FIRST_NAME")
                        + " " + resultSet.getString("LAST_NAME") ); //Kolonlar 1. // getString(3)); Indextende alabiliriz
                System.out.println(resultSet.getInt("AGE"));
                System.out.println(resultSet.getString("COUNTRY") + " " +
                        resultSet.getString("EMAIL") + " " +
                        resultSet.getString("GENDER") );


                System.out.println("-----");
            }

            if (isCloseConnection()) {
                System.out.println("Disconnecting from database...");
            }

    }


    // ekstra düzenlemedik
    public void getFromTableGretaterThan25 (String SQL_GREATER_THAN_25) {

        try{

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = conn.prepareStatement(SQL_GREATER_THAN_25);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("FIRST_NAME")
                        + " " + resultSet.getString("LAST_NAME") ); //Kolonlar 1. // getString(3)); Indextende alabiliriz
                System.out.println(resultSet.getInt("AGE"));
                System.out.println(resultSet.getString("COUNTRY") + " " +
                        resultSet.getString("EMAIL") + " " +
                        resultSet.getString("GENDER") );


                System.out.println("-----");
            }


        }catch(
                SQLException e){
            System.out.println("Fehler" + e);
        } finally {
            if (conn != null || statement != null || resultSet != null) {
                try {
                    resultSet.close();
                    statement.close();
                    conn.close();

                }catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    // UPDATE

    public void updateCustomerFromID(String SQL_CUSTOMER_AGE_UPDATE) throws SQLException {

        if (isOpenConnection()) {
            System.out.println("Connecting to database...");
            statement = conn.prepareStatement(SQL_CUSTOMER_AGE_UPDATE);
            statement.executeUpdate();



        }

        if (isCloseConnection()) {
            System.out.println("Updated - Disconnecting from database...");
        }
    }

    //INSERT - CREATE
    public void addNewCustomer(String SQL_CUSTOMER_ADD_NEW) throws SQLException {
        if (isOpenConnection()) {
            System.out.println("Connecting to database...");
            statement = conn.prepareStatement(SQL_CUSTOMER_ADD_NEW);
            statement.executeUpdate();
        }
        if (isCloseConnection()) {
            System.out.println("Added - Disconnecting from database...");

        }
    }
    public void deleteCustomerFromID(String SQL_CUSTOMER_DELETE) throws SQLException {
        if (isOpenConnection()) {
            System.out.println("Connecting to database...");
            statement = conn.prepareStatement(SQL_CUSTOMER_DELETE);
            statement.executeUpdate();

        }

        if (isCloseConnection()) {
            System.out.println("Deleted -  Disconnecting from database...");

        }
    }

}
