
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// package problems;

public class Main {

  public static void main(String[] args) {

    /*
     Filter and Sort: Given a list of integers, write a Java program using streams to filter out numbers greater than 10 and sort the remaining numbers in ascending order.
     Count Occurrences: Write a Java program that takes a string and counts the occurrence of each character using streams.

     */
    int [] arr={1,2,3,4,2,42,22,33,44,11,22,33};
    List<Integer> sortedgt10=Arrays.stream(arr).boxed().filter(e->e>10).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    System.out.println(sortedgt10);

    String str="jhknbjkasikjab";
    Map<String,Long> frequency =Arrays.stream(str.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting()));
    System.out.println(frequency);

    Employee e1=new Employee("Sintu", 121323,"ECE");
    Employee e2=new Employee("Sam", 11313,"CSE");
    Employee e3=new Employee("Sid", 12113,"IT");
    Employee e4=new Employee("Anjali", 121323,"ECE");
    Employee e5=new Employee("Ankur", 11313,"CSE");
    Employee e6=new Employee("Ankit", 12113,"IT");
    Employee e7=new Employee("Rohit", 121323,"ECE");
    Employee e8=new Employee("Priyanka", 11313,"CSE");
    Employee e9=new Employee("Soumya", 12113,"IT");

    List<Employee> empList=Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9);

    Map<String,List<Employee>> groupedEmployes=empList.stream().collect(Collectors.groupingBy(e->e.department()));
    System.out.println(groupedEmployes);
    List<AbstractMap.SimpleEntry<String,Employee>> maxSalariedEmployee=groupedEmployes.entrySet().stream()
    .map(e->{
      return new AbstractMap.SimpleEntry<>(e.getKey(),e.getValue().stream().max((a,b)->{
        if(a.salary()>b.salary()) return 1;
        else if(a.salary()<b.salary()) return -1;
        else return 0;
      }).get());
    }).collect(Collectors.toList());
    System.out.println(maxSalariedEmployee);
    
    // empList.stream().collect(Collectors.groupingBy(e->e.department(),Collectors.mapping(Employee::name, Collectors.toList())));


     

  }

}

record Employee(
  String name,
  Integer salary,
  String department
){

}
