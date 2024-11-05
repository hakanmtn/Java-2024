package org.hakanmetin;

import org.hakanmetin.base.Hayvan;
import org.hakanmetin.veteriner.Kedi;
import org.hakanmetin.veteriner.Koyun;
import org.hakanmetin.veteriner.Kus;
import org.hakanmetin.veteriner.Köpek;

public class AppMain {
    public static void main(String[] args) {


        Kedi kedi = new Kedi();
        kedi.sesVer();

        System.out.println("---------");

        Köpek köpek = new Köpek();
        köpek.sesVer();

        System.out.println("---------");

        Kus kus = new Kus();
        kus.sesVer();

        System.out.println("---------");

        Hayvan hayvan = new Hayvan();
        hayvan.hareketeGec();
        //Burada hayvan.sesVer(); cagirilamaz cunku PROTECTED

        System.out.println("---------");
        //Kedi Hayvan sinifini miras almis mi onu ögrenmek istiyorum.Almamissa hata verir bu kisim.
        if(kedi instanceof Hayvan){
            System.out.println("Evet");
        }else {
            System.out.println("Hayir");
        }


        System.out.println("---------");
        /*Eger ki sadece Hayvan hayvan2; olsaydi bu nesne referansi demek
        *Hayvan sinifina ait bir nesne
        *Aslinda bu da Polymorphism
        *Calisma zamaninda nesnenin calismasina hükmediyorum
        *Nesne calisma zamaninda davranisini degistirebilir.
        * */

        Hayvan hayvanObj;

        hayvanObj = new Hayvan();
        System.out.println(hayvanObj);

        hayvanObj = new Kedi();
        System.out.println(hayvanObj);

        hayvanObj = new Kus();
        System.out.println(hayvanObj);

        hayvanObj = new Koyun();
        System.out.println(hayvanObj);

        //Bu Bu sekilde olmuyor, sol tarafta üst sinif olmali
        // Koyun k = (Koyun) new Hayvan();



    }

}