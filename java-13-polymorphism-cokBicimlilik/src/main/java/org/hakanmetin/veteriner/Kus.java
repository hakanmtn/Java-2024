package org.hakanmetin.veteriner;

import org.hakanmetin.base.Hayvan;

public class Kus extends Hayvan {

    public Kus() {
        super();  // Bu her zaman gerekli
        System.out.println("Kus");
    }


    //Aslinda bu da bir polymorphism,Override bu methodu bu sinifta yeniden yazdigimizi gösteriyor.

    @Override
    public void sesVer(){
        System.out.println("Kus: cik cik");

    }

    public void yemYe(){
        System.out.println("Kus : Yem Ye");
    }
}
