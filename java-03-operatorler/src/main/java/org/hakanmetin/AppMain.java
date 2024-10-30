package org.hakanmetin;

public class AppMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 2;
        int c = a + b;


        System.out.println("Die Summe: " + c); //Hier wird alles String '+' - konkatiniert
        System.out.println("Die Summe: " + a + b); // Die Summe: 102
        System.out.println("Die Summe: " + (a + b)); // Die Summe: 12

        int ergebnis = a/b;
        System.out.println("Ergebnis: " + ergebnis);

        float d = 2.123456f; // nach Komma 6 Zahlen kommen
        double e = 13.0123456;
        double ergebnis2 = d/e;
        System.out.println("Ergebnis2: " + ergebnis2);
        System.out.println("Ergebnis2: " + (e/d));
        System.out.println("Ergebnis2: " + d * e); // * kommt vor +

        int zahl1 = 20;
        int zahl2 = 3;

        System.out.println("Ist Zahl1 kleiner als zahl2? : " + (zahl1 < zahl2));

        System.out.println(zahl1 < zahl2); //false
        System.out.println(zahl1 > zahl2); //true

        //Ternary operator

        System.out.println((zahl1 > zahl2)  ?  "Ja"   : "Nein"); //Ja
        System.out.println((zahl1 < zahl2) ?  "Ja"   : "Nein");  // Nein


        //NOT Operator
        System.out.println( !(zahl1 < zahl2) ?  "Ja"   : "Nein"); //Ja

        int i = 0;
        /*
        int j = 0;

        j = i + 2;
        System.out.println(j);
        */
        i = i + 1; //noch günstiger
        System.out.println("i+1: " + i);

        int j = 0;
        //j = j + 1;
        j++;
        System.out.println("j++: " + j);

        int m = 0;
       // System.out.println("m++: " + m++); //0
        System.out.println(m++); // 0
        System.out.println(m);

        int y = 0;
       // System.out.println("y++: " + ++y); //1
        System.out.println(++y); //1
        System.out.println(y);

        System.out.println("----------------------");

        int x = 0;
        // System.out.println("x--: " + x--); //0
        System.out.println(x--); // 0
        System.out.println(x);  //-1

        int z = 0;
        // System.out.println("--z: " + --z); // -1
        System.out.println(--z); //  -1
        System.out.println(z);


        System.out.println("Modulo: " + (zahl2 % zahl1)); //ohne Klammer geht auch, aber mit Klammer schöner

    }
}