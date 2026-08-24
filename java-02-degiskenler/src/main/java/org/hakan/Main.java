package org.hakan;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        greeting("Say Something");






        Integer age = 29;
        changeAge(age);
        System.out.println(age); // weiterhin 29
    }

    private static void changeAge(Integer age) {
        age = 99;
    }

    private static void greeting(String greeting) {
        System.out.println(greeting);
    }
}