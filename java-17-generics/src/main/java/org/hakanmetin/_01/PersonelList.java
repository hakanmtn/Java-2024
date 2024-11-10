package org.hakanmetin._01;

import java.util.ArrayList;

//String
public class PersonelList <T> {
    // Kendimize ait bir Liste yapabiliriz, kendine ait bir listeye kendine ait bir
                            // datentyp girebilirsin -- Örnegin, PersonelList, Person (Datentyp)

    private T myTypeInfo;  //Calisma zamani ne verirsek o olur. Esnek olsun istiyoruz.
  //  private Integer myDetail;  //Bu ama net Integer, sabittir.


    private ArrayList<T> myPersonelArrayList = new ArrayList<>();

    public void myAdd (T myData){
        System.out.println("====> My DATA: " + myData);

        myPersonelArrayList.add(myData);


    }

    public ArrayList<T> myGet (){

        return myPersonelArrayList;
    }

}
