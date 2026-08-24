package org.hakanmetin;

public class _01_Method {
    public static void main(String[] args) {
        /*
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");
        */

        /*
        for(int i=0; i < 5; i++){
            System.out.println("---------");
        }

        */

        cizgiCek();


        System.out.println("Ergebnis: " + repeatCharacter('-', 0));

    }

    private static void cizgiCek() {
        System.out.println("---------");
    }


    private static String repeatCharacter(char character, int count){

        if(count < 0){
            return null;
        }
        String word = "";
        for(int i = 0; i < count; i++){
            word = word + character;
        }
        return word;
    }

    /*
        StringBuilder word = new StringBuilder();
        word.append(String.valueOf(character).repeat(count));
        return word.toString();
        *
        *
        * */

}