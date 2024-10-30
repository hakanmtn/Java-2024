package org.hakanmetin;

public class Mensch {
    public static void main(String[] args) {

        String firstName = "Hakan";
        String lastName = "Metin";
        int age = 29;
        float heightInCm = 1.8f;
        double salary = 10000.00;
        boolean married = true;
        char gender = 'M';
        String eyeColor = "blue";

        infoMensch(firstName,lastName,age,heightInCm,salary,married,gender,eyeColor);


        firstName = "Natalie";
        lastName = "Weiss";
        age = 29;
        heightInCm = 1.7f;
        salary = 10000.00;
        married = true;
        gender = 'F';
        eyeColor = "green";

        infoMensch(firstName,lastName,age,heightInCm,salary,married,gender,eyeColor);

        firstName = "Markus";
        lastName = "Meier";
        age = 34;
        heightInCm = 1.75f;
        salary = 11000.00;
        married = false;
        gender = 'M';
        eyeColor = "brown";

        infoMensch(firstName,lastName,age,heightInCm,salary,married,gender,eyeColor);

        //Tek Satirla kisiyi sisteme kaydedebiliriz.
        infoMensch("Ahmet","Metin",27,1.77f, 120_000, false,'M', "Brown");
        infoMensch("Kim","York",47,1.87f, 140_000, true,'M', "Blue");
    }

    private static void infoMensch(String firstName,
                                   String lastName,
                                   int age,
                                   float heightInCm,
                                   double salary,
                                   boolean married,
                                   char gender,
                                   String eyeColor) {
        cizgiCek();

        System.out.println("Firstname Lastname: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("HeightInCm: " + heightInCm);
        System.out.println("Salary: " + salary);
        System.out.println("Married: " + married);
        System.out.println("Gender: " + gender);
        System.out.println("EyeColor: " + eyeColor);


    }
    private static void cizgiCek() {
        System.out.println("---------");
    }
}
