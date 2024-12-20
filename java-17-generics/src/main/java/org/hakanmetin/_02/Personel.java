package org.hakanmetin._02;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//Model - Kalip
public class Personel {

    private String firstName;
    private String lastName;
    private boolean medeniDurum;


    public void ekranaYaz(){
        System.out.println("Ekrana Yaz");

    }

    //Java ilkeli tercih ediyor.Eger int yerine Integer yazsaydim,
    //float methoduna gidecekti. Daha ucuz diye ama float, primitiv olsaydi.
    //Su an hepsi klass tipinde, o yüzden sorun yok.

    public void ekranaYaz(Integer sira, String adi){
        System.out.println("Sira: " + sira + " " + sira.getClass() );
        System.out.println("Adi: " + adi+ " " + adi.getClass());
    }

    public void ekranaYaz(Double sira, String adi){
        System.out.println("Sira: " + sira+ " " + sira.getClass());
        System.out.println("Adi: " + adi+ " " + adi.getClass());

    }

    public void ekranaYaz(Float sira, String adi){
        System.out.println("Sira: " + sira+ " " + sira.getClass());
        System.out.println("Adi: " + adi+ " " + adi.getClass());

    }

    public void ekranaYaz(Long sira, String adi){
        System.out.println("Sira: " + sira+ " " + sira.getClass());
        System.out.println("Adi: " + adi+ " " + adi.getClass());

    }

    public void cizgiCek(){
        System.out.println("-----------------");
    }





}
