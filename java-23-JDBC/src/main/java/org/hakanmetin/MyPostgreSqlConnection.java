package org.hakanmetin;

import java.sql.*;

public class MyPostgreSqlConnection
{
    public static void main( String[] args )
    {

        //Veri tabanina gitmek istiyoruz, connection acmamiz lazim

        Connection connection = null; // Interface, java üzerinden veri tabanlarina gitmemizi saglayan bir yardimci interface

        Statement statement = null; //SQL Cümleleri, yani SQL de yazdigimiz sorgular

        ResultSet resultSet = null;  // Buda sorgunun sonucunu almak icin kullaniyoruz


        // Hata meydana gelebilir, veri tabanina baglanirken

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                                                        "postgres", "HAkan.01");  // Hangi veri tabanina gideceksek onu burada belirtmemiz gerekiyor

            statement = connection.createStatement(); // Statement olusturmamiz lazim

            String sql1 = "SELECT * FROM musteriler";
            String sql2 = "SELECT * FROM musteriler WHERE musteri_yasi >25";

            resultSet =  statement.executeQuery(sql2);


            while(resultSet.next()){
                /*
                System.out.println(resultSet.getString(1) + " " +
                                   resultSet.getString(2) + " " +
                                   resultSet.getString(3) + " " +
                                   resultSet.getString(4));
                */
                // musteri_id, musteri_adi, musteri_soyadi, sehir, musteri_yasi
                System.out.println(resultSet.getInt("musteri_id") + " " +
                                   resultSet.getString("musteri_adi") + " " +
                                   resultSet.getString("musteri_soyadi") + " " +
                                   resultSet.getString("sehir") + " " +
                                   resultSet.getInt("musteri_yasi"));
                System.out.println("---------------------");
            }
        }catch(Exception e){
            System.out.println("Hata: " + e );

        }finally {
            //Burada da hata meydana gelebilir - try catch kullanmak mantikli
            if (resultSet != null ||statement != null || connection != null) {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }


        }
    }
}
