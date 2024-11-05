package org.hakanmetin._03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class MyVector {

    //Özünde bunlarin hepsi Liste
    public static void main(String[] args) {

        /*

       // vektörü sinirlandirmazsak her bir seyi ekleyebiliyoruz.Solda Diamond u kullanmazsak olur.
        Vector vectorList = new Vector<>();


        vectorList.add("sefa");
        vectorList.add(null);
        vectorList.add(10);
        vectorList.add(false);
        vectorList.add(Boolean.TRUE);
        vectorList.add(10.4f);

        System.out.println(vectorList); //[sefa, null, 10, false, true, 10.4]

        */


        Vector<String> vectorList = new Vector<>();

        //digerleri gibi ayni (ArrayList, LinkedList)


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {

            vectorList.addElement("" + i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime); //28

        System.out.println("----");

        ArrayList<String> arrayList = new ArrayList<>(vectorList);

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arrayList.add("" + i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1); // 38 ArrayList bir miktar yavas

        System.out.println("----");

        LinkedList<String> linkedList = new LinkedList<>(vectorList);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            linkedList.add("" + i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);  //81 Aralarinda en yavasi


        System.out.println("--OKUMA--");

        long start3 = System.currentTimeMillis();
        for(String item : vectorList) {

        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);

        System.out.println("----");

        long start4 = System.currentTimeMillis();

        for(String item : arrayList) {

        }

        long end4 = System.currentTimeMillis();

        System.out.println(end4 - start4);

        System.out.println("----");
        long start5 = System.currentTimeMillis();
        for(String item : linkedList) {

        }
        long end5 = System.currentTimeMillis();

        System.out.println(end5 - start5);

        System.out.println("----");
    }
}
