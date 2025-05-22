package multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEg<S, I extends Number> {

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);

//        map.putIfAbsent("three", 4);
//        map.put("four",4);
//        map.replace("two",2, 22);
//        map.remove("one");
//
//        System.out.println(map);

        Thread readerThread = new Thread(() -> {
            for(String key :map.keySet()){
                System.out.println("Key: "+ key+ " - " + "Value: " +map.get(key));
            }
        });

        Thread writerThread = new Thread(() -> {
            map.put("Five" , 5);
        });

        readerThread.start();
        writerThread.start();

        Thread.sleep(3000);

        System.out.println(map);

    }
}
