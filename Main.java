
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// package example;

public class Main {

  public static void main(String[] args) {

    // Create a stream of integers and print all even numbers.
    List<Integer> evenNums = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 7, 7, 5, 4, 3, 2, 32, 3, 24, 35, 45, 6, 5, 65, 75)
        .stream().filter(num -> num % 2 == 0).toList();
    System.out.println(evenNums);

    // Use the map() function to convert a list of strings to uppercase.
    List<String> upercaseString = Arrays.asList("sintu", "seven", "threE", "one", "zero").stream()
        .map(e -> e.toUpperCase()).toList();
    System.out.println(upercaseString);

    // Filter a list of integers to find all numbers greater than 50.
    List<Integer> gtFifty = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 7, 7, 5, 4, 3, 2, 32, 3, 24, 35, 45, 6, 5, 65, 75)
        .stream().filter(num -> num > 50).toList();
    System.out.println(gtFifty);

    // Use the sorted() method to sort a list of strings in alphabetical order.
    List<String> sortedStrings = Arrays.asList("sintu", "seven", "threE", "one", "zero").stream().sorted().toList();
    System.out.println(sortedStrings);

    // Find the sum of all elements in a list of integers using reduce().
    int sum = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 7, 7, 5, 4, 3, 2, 32, 3, 24, 35, 45, 6, 5, 65, 75).stream()
        .reduce(0, Integer::sum);
    System.out.println(sum);

    // Use flatMap() to flatten a list of lists into a single list.
    // Create a nested list of integers
    List<List<Integer>> nestedList = new ArrayList<>();

    // Add sublists to the nested list
    List<Integer> subList1 = Arrays.asList(1, 2, 3, 4, 4, 21, 2);

    List<Integer> subList2 = Arrays.asList(1, 2, 31, 4, 4, 1, 2);

    List<Integer> subList3 = Arrays.asList(1, 2, 3, 43, 4, 21, 2);

    // Add sublists to the main nested list
    nestedList.add(subList1);
    nestedList.add(subList2);
    nestedList.add(subList3);
    // nestedList.add(1);
    // nestedList.add(2);
    // nestedList.add(3);

    List<Integer> fltList = nestedList.stream().flatMap(e -> e.stream()).map(e -> e).toList();
    System.out.println(fltList);

    // Group a list of strings by their length using Collectors.groupingBy().
    Map<Integer, List<String>> grpByLen = Arrays.asList("sintu", "seven", "threE", "one", "zero").stream()
        .collect(Collectors.groupingBy(String::length));
    System.out.println(grpByLen);
    // group Employee based on there age from Map
    Map<Integer, Employee> empMap = new HashMap<>();
    empMap.put(1, new Employee(26, "Sintu Tiwari"));
    empMap.put(2, new Employee(27, "Shivam Tiwari"));
    empMap.put(3, new Employee(26, "Lok Tiwari"));
    empMap.put(5, new Employee(27, "Shiva Tiwari"));
    empMap.put(6, new Employee(21, "Shaxam Tiwari"));

    Map<Integer, List<Employee>> grpByAge = empMap.entrySet().stream().map(e -> e.getValue())
        .collect(Collectors.groupingBy(e -> e.age()));
    System.out.println(grpByAge);

    // sortbyage
    Map<Integer, Employee> sortedEmp = empMap.entrySet().stream()
        .sorted(Comparator.comparing(emp -> emp.getValue().age())).toList().reversed().stream()
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (a, b) -> a, LinkedHashMap::new));
    System.out.println(sortedEmp);

    //Find the maximum and minimum value in a list of integers using max() and min().
    Optional<Integer> max=Arrays.asList(1, 2, 3, 4, 4, 21, 2).stream().max(Comparator.comparing(Integer::valueOf));
    max.ifPresent(e->System.out.println(e));
    Optional<Integer> min=Arrays.asList(1, 2, 3, 4, 4, 21, 2).stream().min(Comparator.comparing(Integer::valueOf));

    min.ifPresent(e->System.out.println(e));
    long cnt=Arrays.asList(1, 2, 3, 4, 4, 21, 2).stream().count();
    System.out.println(cnt);

    //serialization
    try(ObjectOutputStream ops=new ObjectOutputStream(new FileOutputStream("help.txt"))){
        Employee e1=new Employee(26, "Sintu Tiwari");
        ops.writeObject(e1);

    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    //deserialization
    try (ObjectInputStream ips=new ObjectInputStream(new FileInputStream("help.txt"))){
        Employee e1=(Employee)ips.readObject();
        System.out.println(e1);
        
    } catch (Exception e) {
    }
    //
    int[] arr={1, 2, 3, 4, 2};
    var mp=Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()));
    System.out.println(mp);
  }

}

record Employee (
    int age,
    String name) implements Serializable{

}
