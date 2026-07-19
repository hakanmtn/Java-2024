package org.hakanmetin._01_select;

import java.sql.*;

public class MyMySQLConnection {

    public static void main(String[] args) {

        Connection conn = null; //DB ile Baglanti kurmak icin
        Statement statement = null; // Statementlar SQL cümleleri
        ResultSet resultSet = null; //SQL Sorgularinin Sonuclari

        try{  //Veri tabani olmayabilir, o yüzden TRY-CATCH
            //Baglanti icin
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_company_db",
                                               "root",
                                               "Hakan.01"); //Hangi veri tabanina gideceksek

            statement = conn.createStatement();  //bu baglanti üzerinden sorgu olusturabiliriz

            String sql1 = "SELECT * FROM my_company_db.customers" ;

            // MySQL behandelt Spaltennamen normalerweise unabhängig
            // von Groß- und Kleinschreibung.
            String sql2 = "SELECT * FROM my_company_db.CUSTOMERS" + " WHERE AGE  > 25";

            //gelen sonuclari buraya kaydediyorum
            resultSet = statement.executeQuery(sql2);

            while(resultSet.next()){
                System.out.println(resultSet.getString("FIRST_NAME")
                + " " + resultSet.getString("LAST_NAME") ); //Kolonlar 1. // getString(3)); Indextende alabiliriz
                System.out.println(resultSet.getInt("AGE"));
                System.out.println(resultSet.getString("COUNTRY") + " " +
                                   resultSet.getString("EMAIL") + " " +
                                   resultSet.getString("GENDER") );


                 // System.out.println(resultSet.getString("EMAIL"));
                 // System.out.println(resultSet.getString("GENDER"));

                System.out.println("-----");
            }


        }catch(SQLException e){
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

}
