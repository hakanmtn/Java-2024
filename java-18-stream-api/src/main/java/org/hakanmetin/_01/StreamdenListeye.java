package org.hakanmetin._01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamdenListeye {
    public static void main(String[] args) {

        Stream<String> myStream1 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

        //icinde duplikate olmaz!!
        TreeSet<String> myTreeSet1 = myStream1.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(myTreeSet1);

        System.out.println("--------------collect------------------");

        Stream<String> myStream2 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");



        System.out.println("-----collect-Collectors.toCollection--------------------------");


        TreeSet<String> myTreeSet2 = myStream2.collect(Collectors.toCollection(TreeSet::new)); //Yukaridakinin Alternatifi
        //collector , Streamlerde kulllaniliyor, stream i listeye cevirirken isimize yariyor.
        //Streamle isim bitince onu listeye geri cevirip kullanamya devam etmem lazim, collect() methoduyla ceviriyoruz.
        System.out.println(myTreeSet2);


        System.out.println("-----STREAMLER TEK KULLANIMLIKTIR---------------");

        Stream<String> myStream3 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

       // myStream3.forEach(System.out::println);  Böyle bir kere kullanirsam bitti. Bir kerelik

        TreeSet<String> myTreeSet3 = myStream3.collect(Collectors.toCollection(TreeSet::new)); //Bitti .collect - Tek kullanimlik
        System.out.println(myTreeSet3);


        System.out.println("-----STREAMLER Akarken üzerinden birden Fazla islem yapilabilir---------------");

        Stream<String> myStream4 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

        //ayni anda bir kac is yaptirabiliriz.
        myStream4
                .sorted()  //sirala
                .distinct()  //teke indir
                .forEach(System.out::println); //yazdir


        System.out.println("-----------------------");

        Stream<String> myStream5 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

        myStream5
                .sorted()
                .distinct()
                .filter(name -> name.contains("e")) //Metin, Natalie
                .filter(name -> name.contains("a")) //Natalie
                .forEach(System.out::println);

        System.out.println("-----------------------");

        Stream<String> myStream6 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

        myStream6
                .sorted()
                .filter(name -> name.contains("a")|| name.contains("k") )
                .forEach(System.out::println);

        System.out.println("---------isi Bitirip Set e cevirme--------------");

        Stream<String> myStream7 = Stream.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco");

        /*
        myStream7
                .filter(name -> name.startsWith("H"))
                .forEach(System.out::println);


         */

        HashSet<String> myHashSet = myStream7.collect(Collectors.toCollection(HashSet::new));

        System.out.println(myHashSet); //Liste halinde yaziyor.  [Marco, Natalie, Max, Hakan, Dalia, Metin]

        //Ayni sey
        System.out.println("--------------------");
        for (String name : myHashSet) {  // alt alta yaziyor
            System.out.println(name);
        }

        System.out.println("-------MAP-------------");

        HashMap<String, Integer> myHashMap = new HashMap<>();
        myHashMap.put("Hakan", 143);
        myHashMap.put("Metin", 222);
        myHashMap.put("Natalie", 2343);
        myHashMap.put("Max", 432);
        myHashMap.put("Dalia", 235);


        Map.Entry<String,Integer> maxEntry =   //
                myHashMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

        System.out.println(maxEntry.getKey());
        System.out.println(maxEntry.getValue());
    }


}
