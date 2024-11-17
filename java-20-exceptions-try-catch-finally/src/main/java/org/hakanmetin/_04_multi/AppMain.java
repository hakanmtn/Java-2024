package org.hakanmetin._04_multi;


import java.util.Date;
import java.util.InputMismatchException;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        int sayi1 = 0;
        int sayi2 = 0;

        int yapilacakIslemNo = 0;
        int toplam = 0;
        Float bolme = 0.0f;

        Scanner input = new Scanner(System.in);

        boolean hataDurumuFlag = true;

        do{
            //code en az bir kere calisicaksa

            try {
                System.out.println("====HOSGELDINIZ====");

                System.out.print("Lütfen 1. Sayiyi Giriniz: ");
                sayi1 = input.nextInt();

                System.out.print("Lütfen 2. Sayiyi Giriniz: ");
                sayi2 = input.nextInt();

                System.out.println("----------------");
                System.out.println("Yapmak istediginiz islemi söylermisiniz. ");
                System.out.println("Toplama icin bire basiniz. ");
                System.out.println("Cikarma icin ikiye basiniz. ");
                System.out.println("Bölme icin üce basiniz. ");
                System.out.println("Carpma icin dörde basiniz. ");
                System.out.println("----------------");

                System.out.println("Giris icin bekleniyor.");
                yapilacakIslemNo = input.nextInt();

                if(yapilacakIslemNo == 1){
                    System.out.println("Toplama islemi yapilacak. "+ (sayi1+sayi2));
                }else if(yapilacakIslemNo == 2){
                    System.out.println("Cikarma islemi yapilacak. " + (sayi1-sayi2));
                }else if(yapilacakIslemNo == 3){
                    System.out.println("Bölme islemi yapilacak. " +  (sayi1/sayi2));
                }else if(yapilacakIslemNo == 4){
                    System.out.println("Carpma islemi yapilacak. " +  (sayi1*sayi2));
                }else{
                    System.out.println("Gecersiz islem..");
                }



            }catch (ArithmeticException e) {
                System.out.println(" Hata1: " + e);
            }catch (InputMismatchException e) {
                System.out.println(" Hata2: " + e);
            } catch (RuntimeException e) {
                System.out.println(" Hata3: " + e);
            } catch (Exception e) {
                System.out.println(" Hata4: " + e);
            }finally{
                System.out.println("Tesekkür ederiz. : " + new Date());
                System.out.println("===========GÜLE GÜLE==============\n\n");
                hataDurumuFlag = false;
            }



        }while(hataDurumuFlag);



    }

}
