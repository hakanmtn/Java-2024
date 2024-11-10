package org.hakanmetin._01;

import java.util.ArrayList;

public class AppMain {

    // Programin en sade yeri olmali
    public static void main(String[] args) {

        ArrayList       myArrayList1 = new ArrayList(); //Sinirlandirmadik, her bir seyi ekleyebiliriz.

        myArrayList1.add("ABCD");
        myArrayList1.add(100);
        myArrayList1.add(true);
        myArrayList1.add('f');
        myArrayList1.add('A');
        myArrayList1.add(14.33);
        myArrayList1.add(34.232F);
        myArrayList1.add(1_244_125L);


        System.out.println("--------");

        //Diamond icine Primitive Datentyp gelmez!!! Klass tipi olmak zorunda--- %100 gelir
        ArrayList<String> myArrayList2 = new ArrayList<>(); //Sinirlandirmadik, her bir seyi ekleyebiliriz.

        myArrayList2.add("ABCD");

        System.out.println("-----------------------");

        PersonelList<String> myPersonelList1 = new PersonelList<>();
        myPersonelList1.myAdd("Hakan");
        myPersonelList1.myAdd("Natalie");
        System.out.println(myPersonelList1.myGet());


        System.out.println("--------");

        PersonelList<Integer> myPersonelList2 = new PersonelList<>();
        myPersonelList2.myAdd(12);
        myPersonelList2.myAdd(44);
        System.out.println(myPersonelList1.myGet());

        System.out.println("--------");

        PersonelList<Personel> myPersonelList3 = new PersonelList<>();

        Personel myPersonel1 = new Personel();
        myPersonel1.setFirstName("Hakan");
        myPersonel1.setLastName("Metin");
        myPersonel1.setDepartment("ARGE");
        myPersonel1.setCocukSayisi(0);
        myPersonel1.setBirthYear(1995);
        myPersonel1.setMedeniDurum(true);
        myPersonel1.setTc("45345354");
        myPersonel1.setSicilNo("3r34r");



        Personel myPersonel2 = new Personel("Natalie", "Weiss", "131244","55","IT", 1991, true, 0);

        myPersonelList3.myAdd(myPersonel1);
        myPersonelList3.myAdd(myPersonel2);
        System.out.println(myPersonelList3.myGet());


        System.out.println("--------");




    }
}