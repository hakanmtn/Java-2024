package org.hakanmetin;

public class _01_For_Loop {

    public static void main(String[] args) {


        //For-Schleife
        //      Start  Bedingung  increase/decrease
        for(int i = 0;   i <= 5 ;      i++){

            System.out.println(i + "-----");


        }

      //  System.out.println(i + "-------" ); in diesem Case kann i hier nicht funktioeren, nicht im Scope

        System.out.println("i++ =============");

        for(int i = 3;   i <= 7 ;  i++){  //Burada i kullanabiliriz, yukarida ki i öldü
            System.out.println(i);

        }

        System.out.println("i+=2 =============");

        for(int i = 3;   i <= 7 ;  i+=2){  //Burada i kullanabiliriz, yukarida ki i öldü
            System.out.println(i);

        }

        System.out.println("i = i+2 =============");

        for(int i = 3;   i <= 7 ;  i = i+2){  //Burada i kullanabiliriz, yukarida ki i öldü
            System.out.println(i);

        }


        System.out.println("i-- =============");
        for(int i = 30;   i > 26 ;  i--){
            System.out.println(i);
        }


        System.out.println("=============");

        for(int i = 0;  i < 5 ;  i++){//15x
            System.out.println("----");
            System.out.println("i: " + i);
            System.out.println("----");
            for(int j = 0; j < 3; j++){
                System.out.println("j: " + j);
            }

        }

        /*
        System.out.println("===ENDLOSESCHLEIFEN===");

        for(int i = 0; ;  i++){ //Bedingung ist sehr wichtig

        }

         */
        System.out.println("Endloseschleifen");
        /*Sonsuz döngüden sonraki kodlarin hicbiri calismaz.*/
        /*

       for(; ; ){ //Bedingung ist sehr wichtig

        }

       for(; ; ){ //Bedingung ist sehr wichtig  //nicht erreichbar

        }

       int a = 0;  nicht erreichbar

       for(; ; ){ //Bedingung ist sehr wichtig

        }
         */
    }
}