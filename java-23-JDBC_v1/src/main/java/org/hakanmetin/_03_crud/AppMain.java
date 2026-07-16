package org.hakanmetin._03_crud;

import java.sql.*;

public class AppMain {

    static Connection connection = null;


    final String DB_URL = "jdbc:mysql://localhost:3306/firmaveritabanai";
    final String USER = "root";
    final String PASSWORD = "HAkan.01";

    // Baglantiyi kurma
    private Connection veritabaninaBaglantiKur() throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL,USER , PASSWORD);

            if(!connection.isClosed()){
                System.out.println("BAGLANTI KURULDU.");
            }else {
                System.out.println("BAGLANTI KURULAMADI.");
            }

            return connection;

        }catch (SQLException e){
            System.out.println("HATA: Veri tabanina baglanti kurulamadi. ---> "+ e.getMessage());
            return null;
        }finally {
            System.out.println("TESEKKÜR EDERIZ. ");
        }

    }
    // READ - SELECT Veri Okuma
    public String veriOku() throws SQLException {
        veritabaninaBaglantiKur();
        String personelBilgisi = null;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("select * from personel");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("personel_id") + " " +
                        resultSet.getString("adi") + " " +
                        resultSet.getString("soyadi") + " " +
                        resultSet.getString("eposta") + " " +
                        resultSet.getString("görevi") + " " +
                        resultSet.getInt("maasi"));


                personelBilgisi = personelBilgisi + " " + resultSet.getInt("personel_id") + " " +
                        resultSet.getString("adi") + " " +
                        resultSet.getString("soyadi") + " " +
                        resultSet.getString("eposta") + " " +
                        resultSet.getString("görevi") + " " +
                        resultSet.getInt("maasi");
            }

        }catch (SQLException e){
            System.out.println("Hata: " + e.getMessage());
        }



        return personelBilgisi;
    }

    // ADD  INSERT ekleme
    private void veriEkle(String adi, String soyadi,String eposta, String görevi, int maasi) throws SQLException {

        veritabaninaBaglantiKur();

        String durumBilgisi = null;

        try{
            String sqlQuery = " INSERT INTO personel (adi, soyadi, eposta, görevi, maasi) " +
                    " VALUES (? , ? , ? , ? , ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, adi);
            preparedStatement.setString(2, soyadi);
            preparedStatement.setString(3, eposta);
            preparedStatement.setString(4, görevi);
            preparedStatement.setInt(5, maasi);
            //preparedStatement.executeUpdate(); // aktualise etmek icin
            boolean result = preparedStatement.execute();

            if(!result){
                durumBilgisi = "Ekleme basarili oldu.";
            }else{
                durumBilgisi = "Ekleme basarisiz oldu";
            }

        }catch(SQLException e){
            System.out.println("Hata: " + e.getMessage());
        }finally {
            System.out.println(durumBilgisi);
            // FIXME BAGLANTI KAPAT METODU EKLENECEK
        }

        //INSERT INTO personel (adi, soyadi, eposta, görevi, maasi VALUES (? , ? , ? , ? , ?);
    }

    // UPDATE EDIT güncelleme düzenleme
    private void veriDuzenle(String adi, String soyadi,String eposta, String görevi, int maasi, int personel_id) throws SQLException {

        veritabaninaBaglantiKur();

        String durumBilgisi = null;

        //UPDATE firmaveritabanai.personel
        //SET
        //adi = 'Burhan',
        //soyadi = 'Bey',
        //eposta = 'sdgfds@df',
        //görevi = 'CEO',
        //maasi = 50000
        //WHERE personel_id = 6;
        try{
            String sqlQuery = " UPDATE firmaveritabanai.personel " +
                    " SET " +
                    " adi = ? , " +
                    " soyadi = ? , " +
                    " eposta = ? , " +
                    " görevi = ? , " +
                    " maasi = ? " +
                    " WHERE personel_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, adi);
            preparedStatement.setString(2, soyadi);
            preparedStatement.setString(3, eposta);
            preparedStatement.setString(4, görevi);
            preparedStatement.setInt(5, maasi);
            preparedStatement.setInt(6, personel_id);
            //preparedStatement.executeUpdate(); // aktualise etmek icin
            boolean result = preparedStatement.execute();

            if(!result){
                durumBilgisi = "Güncelleme basarili oldu.";
            }else{
                durumBilgisi = "Güncelleme basarisiz oldu";
            }

        }catch(SQLException e){
            System.out.println("Hata: " + e.getMessage());
        }finally {
            System.out.println(durumBilgisi);
        }
    }

    // DELETE silme
    private void veriSil( int personel_id) throws SQLException {

        veritabaninaBaglantiKur();

        String durumBilgisi = null;


        try{
            String sqlQuery = " DELETE FROM personel WHERE personel_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, personel_id);
            //preparedStatement.executeUpdate(); // aktualise etmek icin
            boolean result = preparedStatement.execute();

            if(!result){
                durumBilgisi = "Silme islemi basarili oldu.";
            }else{
                durumBilgisi = "Silme islemi basarisiz oldu";
            }

        }catch(SQLException e){
            System.out.println("Hata: " + e.getMessage());
        }finally {
            System.out.println(durumBilgisi);
        }
    }


    public static void main(String[] args) throws SQLException {

        AppMain appObj = new AppMain();

        connection = appObj.veritabaninaBaglantiKur();

        appObj.veriOku();
        System.out.println("----------------------");

       // appObj.veriEkle("Mani" , "Fet" , "aaa@ff" , "Memur" , 12000);
       // appObj.veriEkle("Kars" , "Come" , "wea@ff" , "Yazilimci" , 10000);

        //appObj.veriEkle("Haluk", "Kayik", "dgsdg@sds", "Satici", 8800);



      //  appObj.veriDuzenle("Manuel", "Neu" , "dsfsf@dd", "Futbolcu", 11255, 5);

        appObj.veriSil(4);
        System.out.println("------------------------");

        appObj.veriOku();



    }
}
