package org.hakanmetin._03;

public class AppMain {

//Generic ler esnek kod yazmamizi sagliyorlar.
    public static void main(String[] args) {
        //Asla primitiv tip Olmaz!!! Kendi klasimiz bile olur.
        Personel<Number,String,Boolean,Number> personel = new Personel();

        //Siralama önemli, 2 li 3 lü , 4 lü ... her sey mumkün,
        //Number, String ise örnegin,Personel klass da da o sekilde sirali olmak zorunda

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

        personel.ekranaYaz((short) 5, "Hakan");
    }
}
