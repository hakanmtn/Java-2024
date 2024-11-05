package org.hakanmetin.hayvanlar;

import org.hakanmetin.base.Canli;

public abstract class Hayvan extends Canli {

    public void yemekYe() {
        System.out.println("Hayvan: yemek ye");
    }

    public void suIc(){
        System.out.println("Hayvan: suIc");
    }

    public void hareketTürü() {
        System.out.println("Hayvan: hareketTürü");
    }

    //Eger gövde define edilmemisse abstract olmak zorunda ve class da abstract olmak zorunda
    public abstract void sesVer();

    public abstract void bilgisiniGetir();

    //abstract funktionlar miras alinan klassda alinmak ve define edilmek zorunda!!!!!
    //ama diger fonksiyolar istege bagli
    //Abstact klassdan OBJECT olusturamayiz!!!
    //ama miras alan klassdan olusturabiliriz.
    //orn. Hayvan Klasi abstract, Kedi klasi hayvan klasindan miras kaldi. Kedi Klasindan object
    //olusturabiliriz.

    //Interface'den de OBJECT olusturulamaz.
    //Abstract Klass- Normal Klass ve Interface arasi bir sey
    //Abstract Klasslar kesinlikle miras alinabilir.
    //Bir sinifin sart koyabilmesi icin, abstract olmak zorunda.
    //Abstract klass Miras alabilir ve interface de kullanabilir.
    //Örn- hayvan Klasi abstract ve Canli klasinda miras alabilir.
    //Interface herkes kullanabilir, interface i interface bile kullanabilir.
    //Abstract sinifta abstract degiskenler tanimlanamaz. Normal,  final, static degiskenler kullanilabilir.
    //Yani sinif icinde degiskenler olabilir (ama ABSTRACT olamazlar)
    //Abstract methodlar da gövde olmaz.


    //COK COK COK ONEMLI BILGI
    /*
    * ÖRNEGIN; public abstract class Hayvan extends Canli implements SanayiTeknolojiBakanligiKurallari{}
    *
    * Böyle bir durumda, abstract klass interface icindeki metodlari almak zorunda degil. Hata almayiz
    *Bir abstract klassa interface uyguladigimizda, interface icindekileri almak zorunlulugumuz yok.
    * */


    /*
     *  Baska bir durumda: Mesela Hayvan sinifi Abstract ve Köpek sinifi Hayvan sinifini miras aldi.
     * Egerki Sivas Kangali sinifi köpek sinifini miras alirsa, Köpek sinifindaki Hayvan sinifindan
     * alinmis abstract methodlar ALINMAK ZORUNDA DEGILDIR.
     *
     */

    /*
    *
    * abstract bir sınıf, bir interface'i implements ettiğinde, interface'deki metodları implement
    *  etmek zorunda değildir çünkü sınıf zaten abstract olduğu için tam bir implementasyon
    * sağlamak zorunda değildir. Ancak, abstract sınıfı miras alan ilk concrete (somut) sınıf,
    *  interface'deki tüm metodları implement etmek zorundadır.
    *
    *Abstract klass abstract klassi miras alabilir, üstteki abstract klassin methodlarini almak zorunda degil.
    * */

    //Abstract klasi hangi normal klass kullaniyorsa icindekileri almak zorunda.


}

