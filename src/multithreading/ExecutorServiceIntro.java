package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceIntro {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService ex = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            System.out.println("Thread name: "+Thread.currentThread().getName());
        };

        for(int i=0; i<100; i++){
            ex.execute(task);
        }
        System.out.println("Thread name: "+Thread.currentThread().getName());
        ex.shutdown();
    }
}

//class Task implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Thread name: "+Thread.currentThread().getName());
//    }
//}

//processA(){
//    lockA();
//    lockb();
//    lockA.unlock();
//    lockB.unlock();
//}
//
//processB(){
//    lockB();
//    lockA();
//    lockB.unlock();
//    lockA.unlock();
//}
