package org.hakanmetin._03_crud;

import java.sql.*;

public class AppMain {

    static Connection connection = null;

    //Connection

    public static Connection connectionToDatenbank(){

        final String DB_URL = "jdbc:mysql://localhost:3306/myCompany";
        final String USER = "root";
        final String PASSWORD = "Hakan.01";


        try{
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);


            if(!connection.isClosed()){
                System.out.println("Connecting to database...");
            }

            return connection;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("thanks"); // finally muss nicht unbedingt verwendet werden
        }

    }

    //jdbc:mysql://localhost:3306/myCompany


    // READ - SELECT
    public String readTheInfosOfCustomer(){

        connection= connectionToDatenbank();
        String personalInfo = null;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("select * from personel");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("personel_id") + " " + resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + " " +  resultSet.getString("email") + " " +
                        resultSet.getInt("salary") + " " +  resultSet.getString("position"));



                personalInfo = resultSet.getString("personel_id") + ' ' + resultSet.getString("first_name")
                        + ' ' + resultSet.getString("last_name") + ' ' + resultSet.getString("email")
                        + ' ' + resultSet.getInt("salary") + ' ' + resultSet.getString("position");
            }





            // SELECT * FROM myCompany.personel;

            // SELECT * FROM myCompany.personel;

        } catch( SQLException e){
            System.out.println("Fehler beim lesen der Datenbank: " +  e.getMessage());

        }
        return personalInfo;

    }



    // ADD INSERT
    public void addNewCustomer(String firstName, String lastName, String email, int salary, String position)  {

        connection= connectionToDatenbank();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "myCompany.personel (first_name, last_name, email, salary, position) " +
                    "                             VALUES (? ,  ?,  ? , ? , ?)");

            preparedStatement.setString(1,firstName); // Soru isaretleriyle böyle bagliyoruz
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4,salary);
            preparedStatement.setString(5,position);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Fehler beim Hinzufügen der Datenbank: " +  e.getMessage());
        }
        //INSERT INTO myCompany.personel (first_name, last_name, email, salary, position)
                           //  VALUES (? ,  ?,  ? , ? , ?)
    }




    // DELETE
    //deleteCustomer(){}
    public void deleteCustomer(int personel_id)  {

        connection= connectionToDatenbank();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" DELETE FROM myCompany.personel " +
                    " WHERE personel_id = ? ");

            preparedStatement.setInt(1,personel_id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Fehler beim Hinzufügen der Datenbank: " +  e.getMessage());
        }
    }


    // UPDATE EDIT
    public void updateCustomer(String firstName, String lastName, String email, int salary, String position, int personel_id)  {

        connection= connectionToDatenbank();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" UPDATE myCompany.personel " +
                    "SET first_name = ? ,last_name = ? , email = ? ,salary = ? ,position =  ? " +
                    " WHERE personel_id = ? ");

            preparedStatement.setString(1,firstName); // Soru isaretleriyle böyle bagliyoruz
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4,salary);
            preparedStatement.setString(5,position);
            preparedStatement.setInt(6,personel_id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Fehler beim Hinzufügen der Datenbank: " +  e.getMessage());
        }

        // UPDATE `myCompany`.`personel`
        //SET
        //	`first_name` = 'Xenija',
        //	`last_name` = 'Ronaldo',
        //	`email` = 'xxcd@gdk.de',
        //	`salary` = 1230,
        //	`position` = 'Trainee'
        //WHERE `personel_id` = 7;
    }



    public static void main(String[] args) {

        AppMain app = new AppMain();
        app.readTheInfosOfCustomer();

       // app.addNewCustomer("Cengo" , "Kesda" , "csd-d@de", 2644, "HR");

        app.readTheInfosOfCustomer();

        app.updateCustomer("Maik", "Cix" , "mshk@kl.de", 1240, "Trainee", 8);

        app.deleteCustomer(7);
        app.readTheInfosOfCustomer();


    }
}
