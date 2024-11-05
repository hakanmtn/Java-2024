package org.hakanmetin._04;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {

        //Bunlarin HEPSI liste . Burada her sey üst üste geliyor.
        Stack<String> stack = new Stack<>();

        //add de var push da, add i Vector klasindan miras aliyor. Ondan dolayi

        stack.add("Mario");
        stack.push("Hakan");
        stack.push("Metin");
        stack.push(null);
        stack.push("Natalie");
        stack.push("Ahmet");

        System.out.println(stack);
        System.out.println(stack.peek()); //En sondaki en üstte Ahmet ismini aliyoruz

        System.out.println(stack.search("Metin")); //4 cevabini aliyoruz. sondan sayacagiz, 1 den basliyoruz

        System.out.println(stack.empty());  //Stack sinifindan
        System.out.println(stack.isEmpty()); //Vector sinifindan


    }
}
