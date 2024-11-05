package org.hakanmetin._01;

import java.util.LinkedList;

public class MyLinkedList {

    //Burada elemanlar sirali tutar. Sira benim icin cok degerliyse bunu kullanirim.
    //Burada da DUPLICATLAR serbest
    //ArrayList le neredeyse ayni, ama bir kac farkli methodu daha var

    public static void main(String[] args) {

        LinkedList<Integer> myList1 = new LinkedList<>();

        myList1.add(54);
        myList1.add(23);
        myList1.add(45);
        myList1.add(3);
        myList1.add(null);

        System.out.println(myList1); // [54,23,45,3,null]

        System.out.println("-------------");

        LinkedList<String> myList2 = new LinkedList<>();

        myList2.add("Hakan");
        myList2.add("Natalie");
        myList2.add("Ahmet");
        myList2.add(null);
        myList2.add("Maxi");
        myList2.add("Maxi");
        myList2.add("Junior");
        myList2.add("Maxi");
        System.out.println(myList2); //[Hakan, Natalie, Ahmet, null, Maxi, Maxi, Junior, Maxi]

        myList2.add(4, "Carlo"); //ekledikten sonra diger sagdaki elemenlar bir index sag tarafa kayiyor.
        myList2.set(3, "Mathias"); //3. Index deki ismi Mathias ile degistiriyorum.

        System.out.println(myList2);

        myList2.addFirst("Jura");
        myList2.addLast("Natalie");
        System.out.println(myList2);

        System.out.println("---FOR -----");

        for(int i = 0; i < myList2.size(); i++){
            System.out.print(myList2.get(i) + " ");
        }

        System.out.println("\n---FOR EACH----");

        for(String item : myList2){
            System.out.print(item + " ");
        }

        System.out.println("----");

        System.out.println("Last Element: " + myList2.get(myList2.size() - 1));
        System.out.println("Last Element: " + myList2.getLast());
    }

}
