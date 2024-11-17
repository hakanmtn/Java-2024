package org.hakanmetin._03_ic_ice;

import java.util.Date;

public class AppMain {

    static int sayi1= 10, sayi2 = 2;
    static int toplam = 0;
    static int bolme = 0;



    public static void main(String[] args) {

        //Normalde ic icede try-catch kullanilabilir, ama tavsiye edilmez. Onun yerine method yapilip cagirilir.
        try {

            /*
            try {

            }catch (Exception e) {
                System.out.println("Hata: " + e);
            }finally{
                System.out.println("Tesekkür ederiz. : " + new Date());
            }

             */

            //icteki try-catch
            hesapYap();
            toplam = sayi1 + sayi2;
            System.out.println("Dis Toplam: " + toplam);

            bolme = sayi1 / sayi2;
            System.out.println("Dis Bolme: " + bolme);

        }catch (Exception e) {
            System.out.println("Dis Hata: " + e);
        }finally{
            System.out.println("Dis Tesekkür ederiz. : " + new Date());
        }

    }

    private static void hesapYap() {
        try {

            toplam = sayi1 + sayi2;
            System.out.println("Ic Toplam: " + toplam);

            bolme = sayi1 / sayi2;
            System.out.println("Ic Bolme: " + bolme);

        }catch (Exception e) {
            System.out.println("Ic Hata: " + e);
        }finally{
            System.out.println("Ic Tesekkür ederiz. : " + new Date());
        }
    }
}
