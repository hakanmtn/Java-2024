package org.hakanmetin;

public class _02_ForEach_Loop {
    public static void main(String[] args) {

        String student1 = "Ahmet Koray";
        String student2 = "Cemre Gök";
        String student3 = "Hakan Metin";
        String student4 = "Natalie Weiss";
        String student5 = "Carlo Meier";

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);


        System.out.println("-----Arrays-------");
        //                          0.          1.          2.              3.              4.          5.
        String[] students = {"Jasmin Kes","Ahmet Koray", "Cemre Gök", "Hakan Metin","Natalie Weiss","Carlo Meier"};

        //System.out.println(students); // Die Adresse von dem Array

        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);

       // System.out.println(students[50]); //ArrayIndexOutOfBoundsException

        // length()  vs length
        System.out.println(student1.length()); //11 Wie viele Character hat der String
        System.out.println(students.length);  //6   Die Anzahl von Elementen in einem Array

        System.out.println("-----FOR-----");

        for(int i=0; i<students.length; i++){  //nicht students.size SONDERN students.length
            System.out.println(students[i]);
        }

        System.out.println("-----ForEach-----String--");

        for(String student : students){
            System.out.println(student);
        }

        System.out.println("-----ForEach-----int--");

        int [] arrYears = {2024,2017,2022,2012,2014};
        
        for(int year : arrYears){
            System.out.println(year);
        }




    }
}
