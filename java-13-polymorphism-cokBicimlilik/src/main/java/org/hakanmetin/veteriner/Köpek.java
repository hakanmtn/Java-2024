package org.hakanmetin.veteriner;

import org.hakanmetin.base.Hayvan;

public class Köpek extends Hayvan {

    public Köpek() {
        super();  // Bu her zaman gerekli
        System.out.println("Köpek");
    }


    //Aslinda bu da bir polymorphism,Override bu methodu bu sinifta yeniden yazdigimizi gösteriyor.

    @Override
    public void sesVer(){
        System.out.println("Köpek: Hav Hav");

    }

    @Override
    public void hareketeGec(){
        System.out.println("Köpek : Harekete Gec");
    }
}
