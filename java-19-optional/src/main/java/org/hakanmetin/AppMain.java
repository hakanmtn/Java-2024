package org.hakanmetin;

import java.util.Optional;

public class AppMain {

    static String adi; //staticler pahalidir
    //ortada nesne yok, direkt cagirabiliyoruz.

    String adi1; //Bunu bu sekilde kullanmak istiyorsam, main disinda .Obje olusturmam lazim

    public static void main(String[] args) {

        System.out.println("Adi: " + adi);  //Stringin var sayilani null, direkt null aliriz.
        // static String adi; böyle mainin icinde kullanamayiz.

        AppMain appMain = new AppMain(); //Bulunsugu sinifin tipinde nesne yapip, static olmayan attributleri kullanabilirim
        //Nesne yapmakla ugrasmayacaksak direkt önüne static koyabiliriz.

        System.out.println("Adi:" + appMain.adi1); //null

        //Staticler pahali ve tehlikelidir.


        System.out.println("-----null------");
        Student student1 = new Student();
        student1.setId(1);
        System.out.println(student1);
        System.out.println("id : " + student1.getId());
        System.out.println("firstName: " + student1.getFirstName());
        System.out.println("lastName : " + student1.getLastName());
        System.out.println("email : " + student1.getEmail());
        System.out.println("phone : " + student1.getPhone());

        System.out.println("-----------------");


        Student student2 = new Student("Hakan");
        System.out.println("Ilk Durum: " + student2);

        System.out.println(student2);
        System.out.println("id : " + student2.getId());
        System.out.println("firstName: " + student2.getFirstName());
        System.out.println("lastName : " + student2.getLastName());
        System.out.println("email : " + student2.getEmail());


        student2 = null;
        System.out.println("Son Durum: " + student2);
        // System.out.println("firstName: " + student2.getFirstName()); //NullPointerException


        //Uygulama devam ediyor, hata vermiyor. Program duruyor ve exception i yaziyor.
        //Hatalarin meydana gelebilecegi yerleri try in icine
        //catch in icine de hata meydana geldiginde ne yapacagim
        try {
            System.out.println("firstName: " + student2.getFirstName());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
            //Exception: java.lang.NullPointerException: Cannot invoke "org.hakanmetin.Student.getFirstName()" because "student2" is null
        }

        System.out.println("-------------------");

        String [] myStudentArr = new String[10];
        myStudentArr[0] = "Hakan";

        String myFirstName = myStudentArr[0].toUpperCase();

        System.out.println("firstName : " + myFirstName); //HAKAN

        /*

        Olmayan bir seyi büyütemem!!!!!!
        java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "myStudentArr[1]" is null
        *Burada array in sinirini asmadik, ama null olan bir seyin üzerinde islem yapmaya calisirsak, exception

        myFirstName = myStudentArr[1].toUpperCase();
        System.out.println("lastName : " + myFirstName);


         */


        /*
        * Buradaysa siniri astik, o yüzden ilk önce ArrayIndexBoundsException aliriz
        *
        myFirstName = myStudentArr[99].toUpperCase();
        System.out.println("lastName : " + myFirstName);

        * */

        myStudentArr[9] = "Süleyman";
        myFirstName = myStudentArr[9].toUpperCase();
        System.out.println("firstName : " + myFirstName); //SÜLEYMAN

        //Dizimin tipi String, o yüzden default olarak null dir .
        for (int i = 0; i < myStudentArr.length; i++) {
            System.out.println(myStudentArr[i]);
        }

        System.out.println("dizinin ilk durumu: " + myStudentArr );
        myStudentArr = null;

        System.out.println("Dizinin null atama sonrasi durumu:" + myStudentArr ); //null

        //calismamizi bölmüyür, hatamizi bilmemizi sagliyor.Benim sorunumu ama cözmüyor: Optional
        try{
            for (int i = 0; i < myStudentArr.length; i++) {
                System.out.println(myStudentArr[i]);
            }

        }catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("----Optional----null kontrolü icindir----"); //bizim icin degerli
        //Optional ile null kontrolü yapabiliyoruz.

        Optional<String[]> nullKontrolOpt = Optional.ofNullable(myStudentArr); //dizinin null kontrolünü yapiyor
        System.out.println("Nullkontrol: " + nullKontrolOpt); //Optional.empty  --bos diyor

        if(nullKontrolOpt.isPresent()){

            System.out.println("Dizi var, dolu");
        }else {
            System.out.println("Dizi nulldir, yok ");
        }


        if(nullKontrolOpt.isEmpty()){  //dizi null mi/ bos mu

            System.out.println("Dizi bos, null");
        }else {
            System.out.println("Dizi doludur ");
        }







    }
}