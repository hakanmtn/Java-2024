package org.hakanmetin._02;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyArrayList {

    public static void main(String[] args) {

        List<String> listStudent = new ArrayList<>();

        listStudent.add("Hakan");
        listStudent.add("Natalie");
        listStudent.add("Ahmet");
        listStudent.add(null);
        listStudent.add("Maxi");
        listStudent.add("Maxi");
        listStudent.add(null);
       // listStudent.add(null); Arka arkaya hata ceriyor, index kaydigi icin
        listStudent.add("Junior");
        listStudent.add(null);
        listStudent.add("Maxi");

        System.out.println(listStudent);
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
            if(listStudent.get(i) == null){ //.equal(null) burada hata veriyor
                listStudent.remove(i);
            }
        }

        Collections.sort(listStudent); //Eger listenin icinde null varsa, SIRALAMA OLMAZ
        System.out.println(listStudent);

        System.out.println("-----FOR-----");

        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
        }

        System.out.println("-----FOR EACH-----");

        for(String item : listStudent) {
            System.out.println(item);
        }

        System.out.println("----Lambda Syntaxi-----");

        listStudent.forEach(System.out::println);

        System.out.println("----Lambda  arrow Syntaxi-----");

        listStudent.forEach(student -> System.out.println(student));


        System.out.println("----Iterator-----");
        //Bir seyi itekliyerek yoluna devam ediyor.
        //listeyi iterator e atiyoruz.
        //Mesela liste cok kalabaliktir, iki seyi birden aramak istersek felan
        //Genelde while döngüsü ile kullanilir.
        Iterator<String> iterator = listStudent.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------");

        Iterator<String> iterator2 = listStudent.iterator();

        String arananKelime;
        while (iterator2.hasNext()) {
            arananKelime = iterator2.next();
            if (arananKelime == "Hakan" || arananKelime == "Maxi") {
                iterator2.remove();
            }
            System.out.println(listStudent);

        }

        //Sahsen sürekli ekleme yapacaksam LinkedList i kullanirim, ArrayList i degil
    }
}
