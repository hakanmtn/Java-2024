package org.hakanmetin._01;

import java.util.Date;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {


        try {
            //kodda hatanin meydana gelebilecegi yerler


        }catch (Exception e) {

            //hata meydana gelirse bu kapsam calisir.
        }finally {
            // her iki durumda da bu kodlar calistirilir.
        }

        try{
            //code
            int sonuc = 2/0; //Hata geldikten sonra, alt tarafini yapmaz!! direkt catch e gider!!
            System.out.println(sonuc);
            System.out.println("-------------------");

        }catch (Exception e) {
            //code2
            System.out.println("Hata: " + e );
            System.out.println("Hata: " + e.getMessage() );

        }

        System.out.println("-----try2---------------");

        try{
            //code 1 Hata meydana gelebilecek kodlar
            int sonuc = 2/0; //Hata geldikten sonra, alt tarafini yapmaz!! direkt catch e gider!!
            System.out.println(sonuc);
            System.out.println("-------------------");

        }catch (Exception e) {
            //code2   Hata meydana gelirse
            System.out.println("Hata: " + e );
            System.out.println("Hata: " + e.getMessage() );

        }finally {  //code3  Her durumda da calisir
            //isim bitince bazen kapatmak istedigimiz seyleri burada kapatabiliriz.

            System.out.println("Tesekkür ederiz. :" + new Date());
        }

        System.out.println("-----try 3 ---------------");
        //Kendimizde hata firlatmak isteyebiliriz.

        try{
            //code 1 Hata meydana gelebilecek kodlar
            throw new Exception("---Hata meydana geldi---"); // tryda buradan sonrasi calismaz
            //Ikinci bir trow da olmaz.

            //  System.out.println("Calismaz");

        }catch (Exception e) {
            //code2   Hata meydana gelirse
            System.out.println("Hata: " + e );
            System.out.println("Hata: " + e.getMessage() );

        }finally {  //code3  Her durumda da calisir
            //isim bitince bazen kapatmak istedigimiz seyleri burada kapatabiliriz.

            System.out.println("Tesekkür ederiz. :" + new Date());
        }

        System.out.println("-----try 4 ---------------");


        try{
           bolme(2,0);

        }catch (Exception e) {
            System.out.println("Hata: " + e);

        }finally {  //code3  Her durumda da calisir
            //isim bitince bazen kapatmak istedigimiz seyleri burada kapatabiliriz.

            System.out.println("Tesekkür ederiz. :" + new Date());
        }


    }


    //Klassin cöplügünde oldugu icin, static !!!
    private static void bolme(double sayi1, double sayi2) {
        //int sonuc = 2/0; //Burada hatayi aldik, alt taraf calismaz..
        double sonuc = sayi1 / sayi2;
        System.out.println(sonuc);
        throw new ArithmeticException("ArithmeticException HATASI MEYDANA GELDI.");
    }
}



/*
---SQL Dersin kismindan-----
* Verinin veriyle tarif edilmesine Metadata denir.
*
*
*  Verilerim Database de
*
*  ETL (Extract, Transform, Load)
* SQL - Sorgulama dili
*Java - Programlama Dili

* */