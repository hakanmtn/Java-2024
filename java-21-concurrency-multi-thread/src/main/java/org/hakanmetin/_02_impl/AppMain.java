package org.hakanmetin._02_impl;


// Bu durumda sadece bir tanesi Public olur!!!!! Doyanin fiziksel sahibinin önünde public olur.
//Thread i iki sekilde kullanabiliriz, ya mirasla yada implementationla Runnable ile
class MyBaseThread implements Runnable  {

    @Override
    public void run() {
        System.out.println("extends MyBaseThread is running: " + Thread.currentThread().getName());
    }
}

public class AppMain {
    public static void main(String[] args) {
        MyBaseThread myBaseThread = new MyBaseThread();
        System.out.println("extends MyBaseThread started.");
        Thread thread = new Thread(myBaseThread);
        thread.start();
    }

}