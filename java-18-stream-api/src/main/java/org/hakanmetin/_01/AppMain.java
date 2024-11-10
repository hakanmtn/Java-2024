package org.hakanmetin._01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppMain {

    //Listelerimi üzerinde daha esnek is yapmak icin kullaniyorum
    //Listerimi Stream e ceviriyorum, filtreleme,siralama, esleme ..
    //Kullandiktan sonra tekrar listeye ceviririz.

    public static void main(String[] args) {

        System.out.println("---------------------");
        Stream <String> bosKayit = Stream.empty(); //Sinirlandirabiliriz.
        System.out.println(bosKayit.count());

        System.out.println("---------------------");
        Stream <String> tekBirKayit = Stream.of("Hakan"); //of ile Streame bir seyler ekleyebiliyoruz.
        System.out.println(tekBirKayit.count());

        System.out.println("---------------------");
        Stream <String> cokluKayit = Stream.of("Hakan", "Metin", "Natalie", "Hakan", "Max", "Dalia");
        System.out.println(cokluKayit.count());

        System.out.println("---------------------");

        List     <String> myStudentsList1 = new ArrayList<>(); //daha esnek
      //  ArrayList<String> myStudentsList2 = new ArrayList<>();


        myStudentsList1.add("Hakan");
        myStudentsList1.add("Metin");
        myStudentsList1.add("Natalie");

        System.out.println(myStudentsList1);

        System.out.println("----------List -----------");
        //add yerine List.of ile ekleme yapabiliriz,
        //Interface ile oluyor, List ve Stream sind Interface
        //OLMAZ !!! ArrayList <String> myStudentsList3 = ArrayList.of("Hakan", "Metin", "Natalie", "Max", "Dalia");

        List <String> myStudentsList3 = new ArrayList<>(List.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco"));
        //myStudentsList3.add("Cemre"); Ekleyemeyiz, cunku List (Interface) e eklenmez. Immutable. Ama Wrap yaparsak olur
        //WRAP --- new ArrayList<>(List.of("Hakan", "Metin", "Natalie", "Max", "Dalia", "Dalia", "Hakan", "Marco"));
        //WRAP olmazsa, calismaz .. Ekleme yapamayiz.

        myStudentsList3.add("Dalia");
        myStudentsList3.add("Cemre");
        myStudentsList3.remove("Dalia");
        myStudentsList3.removeFirst();
        myStudentsList3.add(2,"Karla");

        //ArrayList tarzi bir sey olsa olurdu.

        System.out.println(myStudentsList3);

        System.out.println("----------Stream-----------");

        Stream<String>  myStudentsStream = myStudentsList3.stream(); //Listeyi Stream e cevirdik.
        myStudentsStream.forEach(System.out::println); //Bütün elemanlari bu sekilde yazdirabiliirz.
        //myStudentStream.forEach(student -> System.out.println(student))  Böyle de kullanilabilir,

        //kesinlikle Stream ler de for schleife felan kullanma bütün elementleri yazdirmak icin.
        //Streamin icin de zaten forEach ile direkt bastirabiliriz,

        //STREAM LER TEK KULLANIMLIKTIR. !!!!
        //Listeleri istedigim kadar kullanabilirim

        //System.out.println(myStudentsStream.count());   Bunu kullanamam, cünkü yukarida kullandim !! Akti gecti ..


        System.out.println("-----var and Array ----------------");

        var myStudentsArray = new String [] {"Hakan", "Metin", "Natalie", "Hakan", "Max", "Dalia"};
        //var hangi tipin gelecegini bilmiyorum demek, sol taraf neyse ona göre sekilleniyor.
        //String [] myStudentsArray de diyebilirdik.
        //var Cok kullanilmiyor.

        for (String s : myStudentsArray) {
            System.out.println(s);
        }




    }
}