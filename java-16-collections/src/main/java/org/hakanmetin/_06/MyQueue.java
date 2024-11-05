package org.hakanmetin._06;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyQueue {

    public static void main(String[] args) {


        System.out.println("---ArrayBlockingQueue-----");
        //Kuyruklarda aslinda bir liste
        Queue<String> queueList = new ArrayBlockingQueue<>(25); //BEllekten direkt yer ayiriyot
        //ArrayBlockingQueue de kapasite vermek zorundayiz.


        queueList.add("John");
        queueList.add("Betül");
        queueList.add("Hakan");
        queueList.add("Messi");
        queueList.add("John");
     //   queueList.add(null); //NullPonterException
        queueList.add("Jane");

        System.out.println(queueList); //[John, Betül, Hakan, Messi, John, Jane]


        /*
        * 1. Bounded Queues (Sınırlı Kuyruklar)
          Bazı Queue implementasyonları, kapasite ile sınırlıdır ve kuyruğun maksimum
        * kapasitesini belirlemek zorundasınız. ArrayBlockingQueue buna bir örnektir.
        *
        *Bazı Queue implementasyonları, varsayılan olarak sınırsızdır ve kapasite belirlemek
        *  zorunda değilsiniz. Bu kuyruklar, ihtiyaç oldukça büyür ve genişler.
        * Örnekler: LinkedList, PriorityQueue, ConcurrentLinkedQueue
        *
        * */

        System.out.println("-----PriorityQueue-------");

        //Eger ki hepsini siralayacagim ve dupplikatlari silmeyeceksem bunu kullaniyoruz


        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("John");
        priorityQueue.add("Betül");
        priorityQueue.add("Hakan");
        priorityQueue.add("Messi");
        priorityQueue.add("John");
        //   queueList.add(null); //NullPonterException
        priorityQueue.add("Jane");

        System.out.println(priorityQueue); //[Betül, John, Hakan, Messi, John, Jane]
    }
}
