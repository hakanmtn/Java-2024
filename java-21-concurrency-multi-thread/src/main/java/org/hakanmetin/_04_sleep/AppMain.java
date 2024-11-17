package org.hakanmetin._04_sleep;

import java.util.Random;

public class AppMain {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Random randomNo = new Random();


        try{
            for(int i=1; i<= 12; i++){
                System.out.println("\n" + i + ". Kolon--------------------");

                for(int j = 0; j<6; j++){
                    Thread.sleep(500); //3sn Sleep eksi sayi almaz.
                    System.out.print(randomNo.nextInt(50) + " " );


                }
                System.out.println();


            }



        }catch (InterruptedException e ){
            System.out.println("Exception1: " + e);

        }catch (Exception e ){
            System.out.println("Exception2: " + e);

        }finally {
            System.out.println("Tesekkür ederiz. ");
        }
        long endTime = System.currentTimeMillis();


        long elapsedTime = endTime - startTime;

        System.out.println("StartTime: " + startTime);
        System.out.println("EndTime: " + endTime);
        System.out.println("Elapsed time: " + elapsedTime);
    }
}
