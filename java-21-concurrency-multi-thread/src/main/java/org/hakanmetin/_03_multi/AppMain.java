package org.hakanmetin._03_multi;


// Bu durumda sadece bir tanesi Public olur!!!!! Doyanin fiziksel sahibinin önünde public olur.
class MyBaseThread extends Thread {

    @Override
    public void run() {
        System.out.println("extends MyBaseThread is running: " + Thread.currentThread().getName());
    }
}

public class AppMain {
    public static void main(String[] args) {
        MyBaseThread myBaseThread1 = new MyBaseThread();
        MyBaseThread myBaseThread2 = new MyBaseThread();
        MyBaseThread myBaseThread3 = new MyBaseThread();
        MyBaseThread myBaseThread4 = new MyBaseThread();


        System.out.println("extends MyBaseThread started.");

        myBaseThread1.setName("FB");
        myBaseThread2.setName("GS");
        myBaseThread3.setName("TS");
        myBaseThread4.setName("BJK");

        //Threadlere öncelik verilebilir
        // Daha önemsiz oluyor, prioriti düsük olunca, ama yinede önde cikma ihtimalleri var.
        myBaseThread1.setPriority(Thread.MAX_PRIORITY); //10
        myBaseThread2.setPriority(Thread.MIN_PRIORITY); //10
        myBaseThread3.setPriority(Thread.NORM_PRIORITY); // 5
        myBaseThread4.setPriority(Thread.MIN_PRIORITY);  //1


        myBaseThread1.start();
        myBaseThread2.start();
        myBaseThread3.start();
        myBaseThread4.start();
    }

}