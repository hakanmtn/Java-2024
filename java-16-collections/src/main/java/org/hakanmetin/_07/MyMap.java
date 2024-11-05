package org.hakanmetin._07;

import java.util.*;

public class MyMap {

    //Key-Value

    public static void main(String[] args) {

        System.out.println("------HashMap------");
        Map<String, String> maplist1 = new HashMap<>();

        //HashMap lerde rastgele yazarlar . Null leri kabul ediyor
        maplist1.put("Ankara", "06");
        maplist1.put("Adana", "01");
        maplist1.put("Istanbul", "34");
        maplist1.put("Mersin", "33");
        maplist1.put("Agri", null);
        maplist1.put(null, "02");
        maplist1.put(null, null);

        System.out.println(maplist1); // {null=null, Agri=null, Adana=01, Mersin=33, Ankara=06, Istanbul=34}


        System.out.println("------LinkedHashMap------");

        /*
        *  LinkedHashMap Kullanımında Dikkat Edilmesi Gerekenler
           Tek Null Anahtar: Map yapıları, yalnızca bir null anahtara izin verir.
        *  Aynı anahtarı tekrar eklerseniz, eski değeri güncellenir.
           Birden Fazla Null Değer: Map, birçok null değer eklemenize izin verir.
        * Yani birden fazla anahtara null değeri atanabilir.
        *
        * */

        Map<String, String> mapList2 = new LinkedHashMap<>();

        //HashMap lerde bizim yazdigimiz sekilde sirali yazarlar . Null leri kabul ediyor yalniz keyleri unique olarak kabul ediyor.
        //bir tane
        mapList2.put("Ankara", "06");
        mapList2.put("Adana", "01");
        mapList2.put("Istanbul", "34");
        mapList2.put("Mersin", "33");
        mapList2.put("Agri", null);
        mapList2.put(null, "02");
        mapList2.put(null, null);

        System.out.println(mapList2); //{Ankara=06, Adana=01, Istanbul=34, Mersin=33, Agri=null, null=null}


        System.out.println("------TreeMap------");

        Map<String, String> mapList3 = new TreeMap<>();

        mapList3.put("Ankara", "06");
        mapList3.put("Adana", "01");
        mapList3.put("Istanbul", "34");
        mapList3.put("Mersin", "33");
        mapList3.put("Agri", null);
        //mapList3.put(null, "02"); //Key tarafinda null olamaz!!!! NullPointerException
        //mapList3.put(null, null);

        System.out.println(mapList3); //{Adana=01, Agri=null, Ankara=06, Istanbul=34, Mersin=33}

        System.out.println("------Keys------");
        for(String key : mapList3.keySet()){

            System.out.println("----");
            System.out.println(key); //keys
            System.out.println(mapList3.get(key)); //values

        }


        System.out.println("------Hashtable--K ve V null olamaz----");
        //Bunda hem KEY hem de Values null OLAMAZ.
        //Mapler de key ve value de null degeri istemiyorsak, Hashtable kullanacagiz

        Map<String, String> mapList4 = new Hashtable<>();
        mapList4.put("Ankara", "06");
        // mapList4.put(null, "45");
        mapList4.put("Adana", "01");
        mapList4.put("Istanbul", "34");
        // mapList4.put(null, null);
        mapList4.put("Mersin", "33");
        // mapList4.put("Agri", null);

        System.out.println(mapList4);




    }
}
