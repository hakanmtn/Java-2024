package org.hakanmetin._03;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//Model - Kalip
                    // Number,                  String      Boolean
public class Personel<GelenTip1 extends Number, GelenTip2, GelenTip3, GelenTip4> {

    // GelenTip1 extends Number  -- Busekilde de calisir.
    //Söyle bir seyde mümkün, Integer extends GelenTip1
   // private String firstName;
    //normal kendimiz attributlerde kullanabiliriz.

    private GelenTip1 sira; // buda gereksiz
    private GelenTip2 adi; //Aslinda bu gereksiz, ad her zaman Stringdir
    private GelenTip2 lastName;
    private GelenTip3 medeniDurum;


    public void cizgiCek(){
        System.out.println("==============");
    }

    public void ekranaYaz(){
        System.out.println("Ekrana Yaz");
    }
                            //Number---String
    public void ekranaYaz(GelenTip1 sira, GelenTip2 adi){
        System.out.println("Sira: " + sira + " " + sira.getClass() );
        System.out.println("Adi: " + adi+ " " + adi.getClass());
    }


    //Java ilkeli tercih ediyor.Eger int yerine Integer yazsaydim,
    //float methoduna gidecekti. Daha ucuz diye ama float, primitiv olsaydi.
    //Su an hepsi klass tipinde, o yüzden sorun yok.
/*
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

 */
}
