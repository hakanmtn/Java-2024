package org.hakanmetin._01;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {


    /*
    * Java Collections Framework, Java'da veri kümelerini yönetmek için güçlü,
    * esnek ve kapsamlı bir çözümdür. Bu yapıyı kullanarak karmaşık veri kümeleri
    * ve veri yönetim işlemlerini kolayca gerçekleştirebilirsiniz.
    *
    * */

    //Collectionslar sadece ve sadece sinif tipiyle calisir. ILKEL TIPLE CALISILMIYOR

    //%100 mülakattlarda Collections lardan soru gelir.

    public static void main(String[] args) {

    /*
        int myNumber1 = 10;
        int myNumber2 = 20;
        int myNumber3 = 30;

        int [] myNumbers = {12, 23, 23}; // 3 Items  ARRAY ler sinirlidir.
    */

    /*
        Integer myNumber1 = 10;
        Integer myNumber2 = 20;
        Integer myNumber3 = 30;

        Integer [] myNumbers = {10, 20, 30};

        //Klass tiplerinin ekstra methodlari felan var.
    */

        //Listeler de sinir yok, calisma esnasinda büyüyebilir. Dizilir belirli Yerlerde kullanilir.
        //Mesela günlerde, haftalarda felan
        //siniri bilmiyorsam List leri kullaniriz.Esneklik olan yerlerde.
        List<Integer> myList = new ArrayList<>();  //new kimin tarafindaysa onun tipinde bir nesne yapilir.

        //!!!List tipinde obje olusturamayiz, cunku List bir interface!!!!!
        //ArrayList gayet normal bir sinif, o yüzden onda nesne olusturabiliyoruz.


        /*
        *
        List<Integer> myList1;    //object reference
        myList1 = new ArrayList<>(); // ArrayList tipinde bir nesne oldu
        *
        * */

        //Bu kesinlikle CALISMAZ --- List<int> myList = new ArrayList<>();


        System.out.println(myList); // []
        //Sadece Integer tipinde elementler ekleyebiliriz.
        myList.add(10); //index O
        myList.add(14); //index 1
        myList.add(3);  //index 2
        myList.add(34); // index 3
        myList.add(null); //index 4  //null degeri Klass tipleri ile kullanilabilir, o yüzden eklenir.

        System.out.println(myList);  //Hangi sirada eklemissek o sekilde gösterir. [10,14,3,34, null]

        System.out.println("------------------");


        ArrayList<String> myArrayList = new ArrayList<>(); //Bu sekilde de olur.Calisir.
        //Listelerde kesinlikle <> icine alacagi elemanlarin tipini en basta belirtmek zorundayiz. Yoksa calismaz.

        myArrayList.add("Hakan");
        myArrayList.add("Natalie");
        myArrayList.add("Ahmet");
        myArrayList.add(null);
        myArrayList.add("Maxi");
        myArrayList.add("Maxi");
        myArrayList.add("Junior");
        myArrayList.add("Maxi");  //Duplicatlar ArrayList te mümkün- Ayni ismi,sayiyi felan girebiliriz.

        System.out.println(myArrayList);

        System.out.println(myArrayList.get(2));
        System.out.println(myArrayList.getFirst());
        System.out.println(myArrayList.getLast());
        System.out.println(myArrayList.get(myArrayList.size() - 2));

        System.out.println(myArrayList.contains("Omer")); //false
        System.out.println(myArrayList.contains("Hakan")); // true

        System.out.println(myList.equals(myArrayList));  //false
        // == operatörü burada calismaz. .equals kullanmak zorundayiz.
        System.out.println("myArrayList ile myArrayList: " + myArrayList.equals(myArrayList));

        System.out.println("Eleman sayilari: " + myArrayList.size()); //length() DEGIL bu bir Stringin uzunlugunu verir.

        myArrayList.remove("Maxi"); //Listede buldugu ilk "Maxi" ismini cikartir!
        //Listeden eleman cikardigimiz zaman, elemanlar kayiyorlar. !!!
        System.out.println(myArrayList);

        System.out.println("Eleman sayilari: " + myArrayList.size());
        myArrayList.remove(2);

        System.out.println(myArrayList);
        System.out.println("Eleman sayilari: " + myArrayList.size());

        System.out.println("MyArrayList dolu mu? : " + !myArrayList.isEmpty()); //bos mu ?

        //Belirli bir indexe, belirli bir elemani da ekleyebilirim.
        myArrayList.add(1,"Süleyman");
        System.out.println(myArrayList);
        System.out.println(myArrayList.hashCode()); // bir seyin parmak izi, listede degisiklik yaptikca hashCode degisir.

        myArrayList.remove(1);
        System.out.println(myArrayList);
        System.out.println(myArrayList.hashCode()); // bir seyin parmak izi


        //bütün elemanlari silmek icin
        myArrayList.clear();
        System.out.println(myArrayList.hashCode());


    }
}