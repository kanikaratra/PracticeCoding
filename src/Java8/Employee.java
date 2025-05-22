package Java8;

import java.util.Date;

public class Employee {

     String name;
     int salary;
     char gender;
     Date joiningDate;

     public Employee(String name, int salary, char gender, Date joiningDate) {
          this.name = name;
          this.salary = salary;
          this.gender = gender;
          this.joiningDate = joiningDate;
     }


     public Date getJoiningDate() {
          return joiningDate;
     }

     public void setJoiningDate(Date joiningDate) {
          this.joiningDate = joiningDate;
     }


     public int getSalary() {
          return salary;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setSalary(int salary) {
          this.salary = salary;
     }

     public char getGender() {
          return gender;
     }

     public void setGender(char gender) {
          this.gender = gender;
     }

     @Override
     public String toString() {
          return "Employee{" +
                  "name='" + name + '\'' +
                  ", salary=" + salary +
                  ", gender=" + gender +
                  ", joiningDate=" + joiningDate +
                  '}';
     }
}
