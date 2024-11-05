package org.hakanmetin._05;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet {
    public static void main(String[] args) {

        /*
        * TreeSet - Siralama söz konusu olursa bunu kullanirim, alfabetik direkt siraliyor.
        * HashSet - Eger benim ekledigim sirayi bir bozma diyorsam Hashset
        * LinkedHashSet - Eger benim ekledigim sira önemli degilse
        * */

        System.out.println("----HashSet------");

        Set<String> studentenList1= new HashSet<>(20); //Set de Interface, KAPASITE KOYABILIRIZ
        HashSet<String>  studentenList2= new HashSet<>();

        studentenList1.add("John");
        studentenList1.add("Betül");
        studentenList1.add("Hakan");
        studentenList1.add("Messi");
        studentenList1.add("John");
        studentenList1.add(null); //olur
        studentenList1.add("Jane");


        System.out.println(studentenList1); //[Betül, null, John, Hakan, Messi, Jane]

        //Burada HashSet RASTGELE yaziyor. Icerisine null da alabilir

        /*
        * Eger derseki Siralamanin bir önemi yok, Sadece teke düsür ve icinde null lar da var.
        * O zaman HashSet
        *        * */

        System.out.println("-----TreeSet---Sirali ve null olmaz! ----");


        Set<String> studentenList3= new TreeSet<>();
        TreeSet<String> studentenList4= new TreeSet<>();


        studentenList3.add("John");
        studentenList3.add("Betül");
        studentenList3.add("Hakan");
        studentenList3.add("Messi");
        studentenList3.add("John");
      //  studentenList3.add(null); //olmaz   NullPointerException
        studentenList3.add("Jane");

        System.out.println(studentenList3); //[Betül, Hakan, Jane, John, Messi]

        /*
        * Örnegin 1 milyon kisi olan bir listemiz var. Bunlari sirala ve icinde ayni olanlardan
        * fazlaliklari at. Onlarin hepsini teke düsür. Orada TreeSet kullanabiliriz.
        * Bunun Algorithma kullanmamiza gerek yok.
        * */


        System.out.println("-----LinkedHashSet----");


        Set<String> studentenList5= new LinkedHashSet<>();
        LinkedHashSet<String> studentenList6= new LinkedHashSet<>();

        studentenList5.add("John");
        studentenList5.add("Betül");
        studentenList5.add("Hakan");
        studentenList5.add("Messi");
        studentenList5.add("John");
        studentenList5.add(null); //olur
        studentenList5.add("Jane");

        System.out.println(studentenList5); //[John, Betül, Hakan, Messi, null, Jane]

        /*
        * Null ara itiraz etmiyor.
        * Girdigimiz sira ne sekilde ise o na göre veriyor.
        * Duplikatlari teke indiriyor
        *
        * Setler DUPLICATE Izin vermez.
        * Siralamanin oldugu yerde null hata veriyor. Cunku nereye konulacagi bilinmiyor.
        * Sadece Treeset siralama yaptigindan null lar eklenemiyor.
        * */

    }
}
