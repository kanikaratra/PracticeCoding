package Java8;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(2,32,4,15,6,47,8,19);

        //Even numbers from arraylist
        List<Integer> even = number.stream().filter(i -> i%2 == 0).toList();
        System.out.println(even);

        //Multiply by 2 for each element of the list
        List<Integer> mul = number.stream().map(i -> i*2).toList();
        System.out.println(mul);

        //add 5 grace marks to failed students
        List<Integer> grace = number.stream().filter(i -> i < 35).map(i -> i +5).toList();
        System.out.println(grace);

        //count of list
        System.out.println(number.stream().count());


        //sort in natural order
        System.out.println(number.stream().sorted().toList());

        //in reverse order
        System.out.println(number.stream().sorted(Comparator.reverseOrder()).toList());

        //returning min max
        System.out.println(number.stream().min(Comparator.reverseOrder()).get()); //47 - 1st element
        System.out.println(number.stream().max(Comparator.reverseOrder()).get()); // 2- last element

        //convert obj to array
        Integer[] i = number.stream().toArray(Integer[]::new);
        Arrays.stream(i).forEach(System.out::print);

        List<Integer> list = Arrays.asList(25,56,58,23, 23, 12, 4, 5, 5);

        //numbers starting with 5
        List<Integer> five = list.stream().filter(j -> j.toString().startsWith("5")).toList();
        System.out.println(five);

        //duplicates in a list
        Set<Integer> tmp = new HashSet<>();
        list.stream().filter(n -> !tmp.add(n)).forEach(m -> System.out.println(m + "  "));

        //min and max
        System.out.println(list.stream().min(Integer::compareTo));
        System.out.println(list.stream().min(Comparator.reverseOrder()));  //technically first element is returned

        //check if it contains duplicates
        if(list.stream().distinct().count() != list.size()){
            System.out.println("Duplicates present");
        }
        else
            System.out.println("not present");



        //convert words into uppercase

        List<String> names = Arrays.asList("Kanu","abhi","dishi");
        System.out.println(names.stream().map(s -> s.toUpperCase()).toList());

        //generate 10 random numbers
        Random rd = new Random();
        Stream.generate(rd::nextInt).limit(10).forEach(System.out::println);


        //check if the list is empty using optional else print the data
        //List<String> words = Arrays.asList("xyz", "abc");
        List<String> words = null;
        Optional<List<String>> optionalList = Optional.ofNullable(words);
        optionalList.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));


        List<Integer> freq = Arrays.asList(10,100,100,200,200);
        Map<Integer, Long> count = freq.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println(count);


        //Count of each character
        String str = "kanikaratra";
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        //first non-repeated character
        String val = "ababcddefgg";
        Map<Character,Long> dist = val.chars()
                .mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(dist.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get());


    }
}
