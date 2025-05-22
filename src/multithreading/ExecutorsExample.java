package multithreading;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String []args) throws ExecutionException, InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(10);
        Future<Integer> sum = ex.submit(new Sum(10));
        Future<Integer> factorial = ex.submit(new Factorial(5));
        System.out.println(sum.get());
        System.out.println(factorial.get());
        ex.shutdown();
    }
}

class Sum implements Callable<Integer>{

    int stop;
    Sum(int v){
        stop = v;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0;i <= stop; i++){
            sum = sum + i;
        }
        return sum;
    }
}

class Factorial implements Callable<Integer>{
    int num;
    Factorial(int v){
        num = v;
    }

    @Override
    public Integer call() throws Exception {
        int fact =1;

        for(int i = 2; i<= num; i++){
            fact = fact * i;
        }
        return fact;
    }

}
