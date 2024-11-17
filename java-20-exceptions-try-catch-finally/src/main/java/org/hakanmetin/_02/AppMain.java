package org.hakanmetin._02;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {

        try {
            // int sonuc = urunlerinKilosunuAlUnchecked(250, 85);
            int sonuc = urunlerinSayisiniKilosunuAlChecked(250,85);
            System.out.println("Ürünlerin Sayisi : " + sonuc);

        }catch (Exception e) {
            System.out.println("Hata: " + e);
        }finally{
            System.out.println("Tesekkür ederiz. : " + new Date());
        }
    }

    //Unchecked
    private static int urunlerinKilosunuAlUnchecked(int siloNr , int üretilenÜrünlerinKilosu) {


        if (siloNr < 1 || siloNr > 50) {
            throw new ArithmeticException("Silo sayisini lütfen dogru giriniz.");

        }else{
            return üretilenÜrünlerinKilosu;
        }
    }

    //checked
    //Icerde bir yerde firlatmak zorundayiz!!!!
    private static int urunlerinSayisiniKilosunuAlChecked(int siloNr , int üretilenÜrünlerinKilosu) throws ArithmeticException {

        if (siloNr < 1 || siloNr > 50) {
            throw new ArithmeticException("Silo sayisini lütfen dogru giriniz.");

        }else{
            return üretilenÜrünlerinKilosu;
        }
    }
}
