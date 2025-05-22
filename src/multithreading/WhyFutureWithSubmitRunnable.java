package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhyFutureWithSubmitRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            try {
                System.out.println("Waiting...");
                Thread.sleep(3000);
                System.out.println("completed....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Future<?> future = ex.submit(task);

        future.get(); // this will wait for the above code to complete and then execute further

        System.out.println("Tasks completed!");
    }
}
