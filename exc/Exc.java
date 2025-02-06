package exc;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Exc {
  public static void main(String[] args) {

    Employee[] employees = fetchData();

    List<Employee> employeeList = Arrays.asList(employees);

    // employeeList.forEach(e->{
    // System.out.println(e.name());
    // });
    // employeeList.forEach(System.out::println);

    // filter distinct collect Collectors.toList
    List<Employee> employeesGreaterThan18 = employeeList.stream().filter(e -> e.age() > 20).distinct()
        .collect(Collectors.toList());
    // System.out.println(employeesGreaterThan18);

    // map distinct collect
    List<String> genders = employeeList.stream().map(e -> e.gender()).distinct().collect(Collectors.toList());
    // System.out.println(genders);

    // flatmap distinct collect and conversion of [] to List
    List<String> projectNames = employeeList.stream().flatMap(e -> Arrays.stream(e.projects())).map(p -> p.name()).distinct()
        .collect(Collectors.toList());
    // System.out.println(projectNames);

    //sorted
    //asc
    List<Integer> ascSortedEmployees = employeeList.stream().sorted(Comparator.comparing(Employee::age)).map(Employee::age).distinct().collect(Collectors.toList());
    // System.out.println(ascSortedEmployees);

    //desc
    List<Integer> descSortedEmployees = employeeList.stream().sorted(Comparator.comparing(Employee::age).reversed()).map(Employee::age).distinct().collect(Collectors.toList());
    // System.out.println(descSortedEmployees);
    List<Integer> empoyees = employeeList.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::age))).map(Employee::age).collect(Collectors.toList());
    // System.out.println(empoyees);

    //min
    Employee yongest = employeeList.stream().min(Comparator.comparing(Employee::age)).get();
    // System.out.println(yongest);
    //max
    Employee oldest = employeeList.stream().max(Comparator.comparing(Employee::age)).get();
    // System.out.println(oldest);
    

    //groupby
    Map<String, List<Employee>> groupByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::gender));
    // System.out.println(groupByGender);
    Map<String,Set<String>> nameByGender= employeeList.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.mapping(Employee::name, Collectors.toSet())));
    // System.out.println(nameByGender);
    //count
    Map<String, Long> count = employeeList.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
    // System.out.println(count);

    // findFirst
    Employee findFirst = employeeList.stream().filter(e->e.age()>20).findFirst().orElse((new Employee("null", null, 0, null)));//orElseThrow(()->new RuntimeException("No employee found"));
    Optional<Employee> first = employeeList.stream().filter(e->e.age()>20).findFirst();
    if(first.isPresent()){
        System.out.println(first.get());
    }
    first.ifPresent(e->System.out.println(e.name()));

    // findAny
    Employee findAny = employeeList.stream().filter(e->e.age()>20).findAny().orElse((new Employee("null", null, 0, null)));//orElseThrow(()->new RuntimeException("No employee found"));
    Optional<Employee> any = employeeList.stream().filter(e->e.age()>20).findAny();
    if(any.isPresent()){
        System.out.println(any.get());
    }
    any.ifPresent(e->System.out.println(e.name()));

    //anyMatch allMatch noneMatch
    boolean anyMatch = employeeList.stream().anyMatch(e->e.age()>20);
    boolean allMatch = employeeList.stream().allMatch(e->e.age()>20);
    boolean noneMatch = employeeList.stream().noneMatch(e->e.age()>20);
    System.out.println(anyMatch);
    System.out.println(allMatch);
    System.out.println(noneMatch);

    //use for pagination mostly 
    //limit
    List<Employee> topThreeOldesList = employeeList.stream().sorted(Comparator.comparing(Employee:: age).reversed()).limit(3).collect(Collectors.toList());
    topThreeOldesList.stream().map(Employee::name).forEach(System.out::println);

    //skip
    List<Employee> skipThreeOldesList = employeeList.stream().sorted(Comparator.comparing(Employee:: age).reversed()).skip(3).collect(Collectors.toList());
    skipThreeOldesList.stream().map(Employee::name).forEach(System.out::println);
    //average
    Double average = (double) (employeeList.stream().map(a->a.age()).reduce(0, (a,b)->a+b)/employeeList.size());
    System.out.println(average);
    average = employeeList.stream().map(a->a.age()).collect(Collectors.averagingInt(Integer::intValue));
    System.out.println(average);
    //count
    Long c =employeeList.stream().count();
    System.out.println(c);
    List<Employee> sortByName=employeeList.stream().sorted(Comparator.comparing(Employee::name)).collect(Collectors.toList());

    // //groupByProects
    //  Map<String,List<Employee>> test=employeeList.stream()
    //  .flatMap(employee->Arrays.stream(employee.projects()).map(project->new AbstractMap.SimpleEntry<>(project.name(),employee)))
    //  .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    //  test.forEach((key,val)->{
    //   System.out.println("Project: "+key);
    //   System.out.println("Employees"+val);
    //  });
    Map<String,Long> projects=employeeList.stream().flatMap(e->Arrays.stream(e.projects()).map(p->p)).collect(Collectors.groupingBy(Project::name,Collectors.counting()));
    System.out.println(projects);
  }

  public static Employee[] fetchData() {
    Project p1 = new Project("Project 1", "Description 1");
    Project p2 = new Project("Project 2", "Description 2");
    Project p3 = new Project("Project 3", "Description 3");
    Project p4 = new Project("Project 4", "Description 4");
    Employee e1 = new Employee("John Doe", "Male", 22, new Project[] { p1, p2 });
    Employee e2 = new Employee("Jane Doe", "Female", 25, new Project[] { p3, p4 });
    Employee e3 = new Employee("Jack Doe", "Male", 35, new Project[] { p1, p2 });
    Employee e4 = new Employee("Jill Doe", "Female", 25, new Project[] { p3, p4 });
    Employee e5 = new Employee("John Doe", "Male", 30, new Project[] { p1, p2 });
    Employee e6 = new Employee("Jane Doe", "Female", 35, new Project[] { p3, p4 });
    Employee e7 = new Employee("Jack Doe", "Male", 30, new Project[] { p1, p2 });
    Employee e8 = new Employee("Jill Doe", "Female", 25, new Project[] { p3, p4 });
    Employee e9 = new Employee("John Doe", "Male", 30, new Project[] { p1, p2 });
    Employee e10 = new Employee("Jane Doe", "Female", 25, new Project[] { p3, p4 });
    Employee e11 = new Employee("Jack Doe", "Male", 30, new Project[] { p1, p2 });
    Employee e12 = new Employee("Jill Doe", "Female", 25, new Project[] { p3, p4 });

    return new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12 };
  }
}

record Employee(
    String name,
    String gender,
    int age,
    Project[] projects

) {

}

record Project(
    String name,
    String description) {
}