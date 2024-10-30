package org.hakanmetin;

import java.sql.SQLOutput;
import java.util.SortedMap;

public class _03_Switch_Case {
    public static void main(String[] args) {
        //Seceneklerim sinirliysa cogunlukla Switch-Case kullaniriz.
        char harf ='C'; // "C" This is String, not a char

        switch(harf){
            case 'A':
                System.out.println("Secilen: " + harf);
                break;
            case 'B':
                System.out.println("Secilen: " + harf);
                break;
            case 'C':
                System.out.println("Secilen: " + harf);
                break;
            case 'D':
                System.out.println("Secilen: " + harf);
                break;
            default:
                System.out.println("Secilen: " + harf + "bulunamadi.");
                break;
        }

        System.out.println("---------------");

        int haftaninGünleri = 2;

        switch(haftaninGünleri){
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Sali");
                break;
            case 3:
                System.out.println("Carsamba");
                break;
            case 4:
                System.out.println("Persembe");
                break;
            case 5:
                System.out.println("Persembe");
                break;
            case 6:
                System.out.println("Persembe");
                break;
            case 7:
                System.out.println("Persembe");
                break;
            default:
                System.out.println("Secilen gün dogru degil.");
                break;
        }
    }
}
