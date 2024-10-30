package org.hakanmetin;

public class _03_While_DoWhile_Loop {

    public static void main(String[] args) {

        System.out.println("===WHILE-LOOP===");

        int i = 0;

        while(i < 5){ //Bedingung
            System.out.println(i);
            i++;


        }


        System.out.println("==DoWhileLoop==="); //mindestens einmal läuft, egal ob die Bedingung richtig ist.
        //Sifre/ Parola tarzi yerlerde cogunlukta kullanilir

        int j= 0;
        do{

            System.out.println(j);
            j++;
        }while(i<5);

    }


}
