package Java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        Date joinRam = dateFormat.parse("01-01-2024");
        Date joinKanu = dateFormat.parse("31-01-2024");
        Date joinAbhi = dateFormat.parse("14-01-2024");
        Date joinJaggi = dateFormat.parse("11-01-2024");
        Date joinJim = dateFormat.parse("21-01-2024");

        List<Employee> list = Arrays.asList(
                new Employee("Ram",20000,'M',joinRam),
                new Employee("Kanu",30000,'F',joinKanu),
                new Employee("Abhi",40000,'M',joinAbhi),
                new Employee("Jaggi",25000,'M',joinJaggi),
                new Employee("Jim",29000,'M',joinJim)
        );

        //max Salary
        Employee maxSal = list.stream().max((a,b) -> Integer.compare(a.getSalary(), b.getSalary())).get();
        System.out.println(maxSal);

        // 2nd highest salary
        Employee SecHigh = list.stream()
                .sorted((a,b) -> Integer.compare(b.getSalary(), b.getSalary()))
                .skip(1).findFirst().get();

        System.out.println(SecHigh);

        //Senior most employee based on joining date

        //Employee senior = list.stream().min((a,b) -> Integer.compare(a.getSalary(), b.getSalary())).get();
        Employee senior = list.stream().min(Comparator.comparing(Employee::getJoiningDate)).get();
        System.out.println(senior);

        //count based on gender
        Map<Character, Long> count = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(count);
    }
}
