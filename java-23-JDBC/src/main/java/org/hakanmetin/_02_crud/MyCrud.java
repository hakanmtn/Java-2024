package org.hakanmetin._02_crud;


import java.sql.*;

//CRUD -->  CREATE, READ, UPDATE, DELETE
public class MyCrud {

    private Connection connection = null; // Interface, java üzerinden veri tabanlarina gitmemizi saglayan bir yardimci interface
    private PreparedStatement preparedStatement = null; //SQL Cümleleri, yani SQL de yazdigimiz sorgular
    private Statement statement = null; // Buda burada bulunsun, PreparedStatement daha gelismis
    private ResultSet resultSet = null;  // Buda sorgunun sonucunu almak icin kullaniyoruz

    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "HAkan.01";

    private final String SQL_GET_ALL_CLIENT = "SELECT * FROM musteriler";
    private final String SQL_GET_ALL_CLIENT_OLDER_THAN_25 = "SELECT * FROM musteriler WHERE musteri_yasi >25";


    private boolean isOpenConnection() {
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  // Hangi veri tabanina gideceksek onu burada belirtmemiz gerekiyor
            return true;
            // return den sonrasi calismaz !!

        }catch(Exception e){
            System.out.println("Hata: " + e );
            return false;

        }
    }

    private boolean isCloseConnection() {
        if (resultSet != null ||preparedStatement != null || connection != null) {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return true;
            } catch (Exception e) {
                System.out.println("Hata: " + e );
                return false;
            }

        }
        // FIXME :
        return false;
    }


    // SELECT - READ
    public void getAllClients() throws SQLException {


        if(isOpenConnection()){
            System.out.println("Baglanti acildi.");
            preparedStatement = connection.prepareStatement(SQL_GET_ALL_CLIENT); // Statement olusturmamiz lazim
            resultSet =  preparedStatement.executeQuery();

            while(resultSet.next()){
                // musteri_id, musteri_adi, musteri_soyadi, sehir, musteri_yasi
                System.out.println(resultSet.getInt("musteri_id") + " " +
                        resultSet.getString("musteri_adi") + " " +
                        resultSet.getString("musteri_soyadi") + " " +
                        resultSet.getString("sehir") + " " +
                        resultSet.getInt("musteri_yasi"));
                System.out.println("---------------------");
            }

        }

        if(isCloseConnection()){
            System.out.println("Baglanti acildi.");
        }
    }

    public void getAllClientsOlderThan25() {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  // Hangi veri tabanina gideceksek onu burada belirtmemiz gerekiyor

            statement = connection.createStatement(); // Statement olusturmamiz lazim

            resultSet =  statement.executeQuery(SQL_GET_ALL_CLIENT_OLDER_THAN_25);


            while(resultSet.next()){

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
            if (resultSet != null ||preparedStatement != null || connection != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }


        }

    }
}
