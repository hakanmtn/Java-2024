package org.hakanmetin;

public class _02_If_Else {
    public static void main(String[] args) {

        /*
        int personAge = 17;

        if(personAge >= 18){
            System.out.println("Evet, ehliyet sinavina girebilirsiniz.");
        }else{
            System.out.println("Hayir, ehliyet sinavina giremezsiniz. Cunkü yasiniz henüz " + personAge);
        }

         */

        int personAge = 17;
        boolean saglikRaporu = true;

        if(saglikRaporu == true){

            if(personAge >= 18 ){
                System.out.println("Evet, ehliyet sinavina girebilirsiniz.");
            }else if (personAge < 0){
                System.out.println("Gecerli bir yas giriniz. Yasiniz dogru degil.  " + personAge);
            }else if(personAge == 17){
                System.out.println("Ehliyet sinavina girebilirsiniz ama sadece stajer ehliyeti alabilirsiniz. ");
            }else{
                System.out.println("Hayir, ehliyet sinavina giremezsiniz. Cunkü yasiniz henüz " + personAge);

            }

        }else {
            System.out.println("Saglik raporunuz olmadan sinava giremezsiniz.");
        }

    }


}
