package org.hakanmetin._01_inheritance;


// Bu durumda sadece bir tanesi Public olur!!!!! Doyanin fiziksel sahibinin önünde public olur.
class MyBaseThread extends Thread {

    @Override
    public void run() {
        System.out.println("extends MyBaseThread is running: " + Thread.currentThread().getName());
    }
}

public class AppMain {
    public static void main(String[] args) {
        MyBaseThread myBaseThread = new MyBaseThread();
        System.out.println("extends MyBaseThread started.");
        myBaseThread.start();
    }

}