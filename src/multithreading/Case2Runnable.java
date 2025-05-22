package multithreading;

public class Case2Runnable extends Thread{
    public void run()
    {
        System.out.println("Task1");
    }

    public static void main(String [] args){

        Case2Runnable t1 = new Case2Runnable();
        Thread th = new Thread(t1);
        th.start();
        System.out.println(currentThread().getName());
        currentThread().setName("Thread1");
        System.out.println(currentThread().getName());
        System.out.println("**************************");
        System.out.println(currentThread().isAlive()); //true
        System.out.println(t1.isAlive()); // false - why?
    }
}
