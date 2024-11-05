package org.hakanmetin.base;

public class Hayvan {

    public Hayvan(){
        System.out.println("Hayvan");
    }

    //Sadece Miras alanlar kullanabilirler.
    protected void sesVer(){
        System.out.println("Hayvan: sesVer");

    }

    public void hareketeGec(){
        System.out.println("Harekete Gec");
    }

}
