package org.hakanmetin.base;

import lombok.*;
import org.hakanmetin.department.Muhasebe;

//Annotation
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Personel {


    private String name;
    private String soyadi;
    private String telefon;
    private String department;
    private int sicilNo;
    private String mezuniyet;
    private String adress;
    private float maas;
    private boolean medeniDurumu;


    public void bilgisiniYaz(Personel personel){
        System.out.println(personel.getName() + " " + personel.getSoyadi());
        System.out.println("Medeni Durumu: " + (personel.isMedeniDurumu() ? "Evli" : "Bekar"));
        System.out.println(personel.getTelefon());
        System.out.println(personel.getDepartment());
        System.out.println(personel.getSicilNo());

    }

    //paramatrelerin sayilari farkli, buna polymorphism diyoruz. Ayni isimde defalarca funktion olusturabiliriz.
    public void hesapla(){
        System.out.println("Hesapla");
    }

    public void hesapla(int year){      //int
        System.out.println("Hesapla");
    }

    public void hesapla(int year, int month){  //int int
        System.out.println("Hesapla");
    }

    public void hesapla(int year, int month, int day){ //int int int
        System.out.println("Hesapla");
    }

    /*
    * Mesela bu su an da calismaz, PARAMAETRELERIN YERINE DEGISTIRIRSEK CALISMAZ
    * public void hesapla(int month, int year){
        System.out.println("Hesapla");
    }
    *
    * */


    //AMA BU SEKILDE CALISIR, CUNKU TIPINE BAKIYOR, tipler farkli olursa olur.

    public void hesapla(int year, short month){} //int  short

    public void hesapla(short year, int month){} //short  int

    public void hesapla(short year, int month, int day){ //short int int
        System.out.println("Hesapla");
    }

    public void hesapla(int year, short month, int day){ //int short int
        System.out.println("Hesapla");
    }

    public void hesapla(int year, int month, short day){ //int int short
        System.out.println("Hesapla");
    }

}