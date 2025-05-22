package multithreading;

public class Case1ThreadClass extends Thread{

    public void run() {
        System.out.println("Task1");
    }

    public static void main(String[] args){

        Case1ThreadClass t1 = new Case1ThreadClass();
        t1.start();
    }
}


