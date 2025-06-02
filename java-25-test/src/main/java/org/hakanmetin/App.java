package org.hakanmetin;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App

{

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }

    }
    public static void main( String[] args )
    {

        String[] stringArray = {"a", "b", "c", "d", "e", "f"};

        printArray(stringArray);


        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("a");
        stringArrayList.add(1,"d2d");



        ArrayList<String> stringArrayList2 = new ArrayList<>();
        stringArrayList2.add("a");
        stringArrayList2.add(1,"d2d");

        stringArrayList2.add(2,"a");
        System.out.println(stringArrayList2);
    }
}
