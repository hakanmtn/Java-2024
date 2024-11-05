package org.hakanmetin;

import org.hakanmetin.hayvanlar.kedi.Kedi;

public class AppMain {

    public static void main(String[] args) {

        //Class - Burada olur- Gayet normal %100 Klass
        Kedi kedi = new Kedi();

        //Abstract Klass - OBJECT OLUSTURULAMAZ!!!
        //Hayvan hayvan = new Hayvan();

        //Interface  - OBJECT OLUSTURULAMAZ!!!
        // SanayiTeknolojiBakanligi nesne = new SanayiTeknolojiBakanligi();

        kedi.sesVer();


    }
}