package org.hakanmetin;

import org.hakanmetin.tasit.Taksi;
import org.hakanmetin.tasit.Ucak;

public class AppMain {

    //EGER Interface kelimesini duyarsam, benim icin kurallari ortaya koyacak
    //Herkesde o kurallari yerine getirecek

    public static void main(String[] args) {

        Ucak ucak = new Ucak();

        ucak.setMarka("Boeing");
        ucak.setKoltukSayisi((short)150);
        ucak.setTekerSayisi((byte)12);
        ucak.setMotorHacmi(50000);
        ucak.setYakitTipi("Kerosen");

        //IKanun
        ucak.hizSiniri(3000);
        ucak.bakimDurumu("Kasim 2024");
        ucak.tasitVergisi(32000.25f);
        ucak.emisyonDegeri((byte)15);

        //InternationalAirTansportAssociation
        boolean ucusDurumu = ucak.vizeIzinDurumu(true);
        ucak.aidat(1000);
        ucak.kurumUyeDurumu(true);
        ucak.yolcuKapasitesi((short) 150);

        System.out.println(ucak.getMarka());
        System.out.println(ucak);
        if(ucusDurumu){
            System.out.println("Her sey onaylanmistir. Ucabilir");
        }else{
            System.out.println("Ucus icin vize alinmamistir. Ucamaz.");
        }

        System.out.println("-------------");

        Taksi taksi = new Taksi();


        taksi.setMarka("Tesla");
        taksi.setKoltukSayisi((short)4);
        taksi.setTekerSayisi((byte)4);
        taksi.setMotorHacmi(10000);
        taksi.setYakitTipi("Hybrid");

        byte emisyonDegeri = taksi.emisyonDegeri((byte)3);
        float acilisUcreti = taksi.acilisUcreti(16.25f);

        System.out.println(taksi);
        System.out.println("Ruhsat Durumu: " + taksi.ruhsatDurumu(true));
        System.out.println("Ehliyet Durumu: " + taksi.ehliyetDurumu(false));
        System.out.println("Emisyon Degeri: " + emisyonDegeri);
        System.out.println("AcilisUcreti: " + acilisUcreti);



    }

}