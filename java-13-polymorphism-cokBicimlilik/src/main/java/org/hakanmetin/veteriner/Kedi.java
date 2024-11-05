package org.hakanmetin.veteriner;

import org.hakanmetin.base.Hayvan;

public class Kedi extends Hayvan {

    public Kedi() {
        super();  // Bu her zaman gerekli
        System.out.println("Kedi");
    }


    //Aslinda bu da bir polymorphism,Override bu methodu bu sinifta yeniden yazdigimizi gösteriyor.

    @Override
    public void sesVer(){
        System.out.println("Kedi: miyav miyav");

    }

    @Override
    public void hareketeGec(){
        System.out.println("Kedi : Harekete Gec");
    }
}
