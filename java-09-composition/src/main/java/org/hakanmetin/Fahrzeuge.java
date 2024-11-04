package org.hakanmetin;
//Paketler klasörlerdir.

public class Fahrzeuge {

    public Fahrzeuge(){
        System.out.println("Fahrzeuge Constructor");
    }


    public static void main(String[] args) {

        //KOMPOSITION
        Motor motor = new Motor();
        Spiegel spiegel = new Spiegel();
        Depo depo = new Depo();
        Direksiyon direksiyon = new Direksiyon();
        Tekerlek tekerlek = new Tekerlek();
        Koltuk koltuk = new Koltuk();

        motor.motorGucu = 6000;
        spiegel.art = "Katlanamaz";
        depo.depoKapasitesi = 30000;
        depo.yakitTuru = "Elektrik";
        direksiyon.radius = 30;
        tekerlek.tekerSayisi = 4;
        koltuk.koltukSayisi = 4;
        Fahrzeuge fahrzeuge = new Fahrzeuge();

    }


    /*
    * Kompositionun kötü tarafi, yarin bir gün mesela Direksiyonsuz araba yaparsak. Direksiyon sinifi sildigimizde hata
    * verir. Cunku Direksiyon sinifi Fahrzeuge sinifinin bir parcasi.
    * */
}