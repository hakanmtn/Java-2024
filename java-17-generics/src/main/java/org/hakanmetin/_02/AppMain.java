package org.hakanmetin._02;

public class AppMain {


    public static void main(String[] args) {

        Personel personel = new Personel();

        personel.ekranaYaz();
        personel.cizgiCek();

        personel.ekranaYaz(1,"Hakan");
        personel.cizgiCek();

        personel.ekranaYaz(2.0, "Hakan");
        personel.cizgiCek();

        personel.ekranaYaz(3.0F, "Hakan");
        personel.cizgiCek();

        personel.ekranaYaz(4L, "Hakan");
        personel.cizgiCek();
    }
}
