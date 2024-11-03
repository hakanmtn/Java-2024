package org.hakanmetin;

public class AppMain {
    public static void main(String[] args) {

        /*
           Karakter sayiya tekabül ederler. String kesinlikle olmaz!!
           Diziler sinirlidir. 100 elemanin varsa 101. Elemani ekleyemezsin. DIZILER SINIRLIDIR!!
         */

        int[] arr = {'a', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //int[] arr = {'a', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, }; 10.karaktere kadar normal calisiyor, 11.karakterde hata veriyor.
        System.out.println(arr[2]);


        System.out.println("----------");
        //Dizilerde length, length() DEGIL örn. String de uzunlugunu(kac karakteri oldugunu) length() ile buluyoruz.
        for (int i = 0; i < arr.length; i++) { //Dizinin elemean sayisini length veriyor.
            System.out.print(arr[i] + "-");
        }


        System.out.println("\n----------");


        String firstName = "Natalie";
        System.out.println("Karakter Sayisi: " + firstName.length());

        System.out.println("------TEK BOYUTLU DIZILER-------");

        short [] myArray = new short [4]; //Burada eleman sayisini yazman lazim.Yoksahata verir.
        myArray[0] = 321;
        myArray[1] = 125;
        myArray[2] = 'a'; //97 sinir icinde
        myArray[3] = 32;  // Daha fazla eleman ekleyemeyiz.

        for (short i = 0; i < myArray.length; i++) {   //short 2 Byte -- int 4 Byte bellekte yer kapliyor
            System.out.println(myArray[i]);
        }

        /*
        short sayi1 = 32767;
        short sayi2 = 32767;
        //short sonuc = sayi1 +sayi2; Calismaz, siniri asiyor.
        int sonuc = sayi1 + sayi2;
        System.out.println(sonuc); //Eger iki kücük data type i topluyorsan, bir üstü kullanilmali . short+shot = int
        //byte + byte = short

        byte sayi3 = 127;
        byte sayi4 = 127;
        //byte sonuc = sayi3 + sayi4; CALISMAZ, SINIRI ASMIS OLUYORUZ.
        */


        System.out.println("---2 DIMENSION ARRAYS ---");

        int [][] myNumberArray = new int [3][5];
        for (int i = 0; i < myNumberArray.length; i++) {
            for (int j = 0; j < myNumberArray[i].length; j++) {
                System.out.println("i: " + i + " j: " + j);
            }
        }
    }
}