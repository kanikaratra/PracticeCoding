package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModification {
    public static void main(String[] args) throws InterruptedException {

        //List<Integer> list = new ArrayList<Integer>();
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(10);

        Thread readerThread = new Thread(() -> {
            for(int i: list){
                System.out.println("Reading - " +i);
            }
        });

        Thread writerThread = new Thread(() -> {
            System.out.println("Modifying..");
            list.add(15);
        });

        readerThread.start();
        writerThread.start();

        Thread.sleep(3000);

        System.out.println(list); // may not show, but it will always add
    }
}
