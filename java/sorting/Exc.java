
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exc {

  public static void main(String[] args) {
    Person p1 = new Person("Sintu", 27, new String[] { "Dev", "Testing","" });
    Person p2 = new Person("Shivam", 22, new String[] { "Dev", "Testing" });
    Person p3 = new Person("Shivansh", 21, new String[] { "Dev", "Testing","QA" });
    Person p4 = new Person("Shivang", 27, new String[] { "Dev", "Testing" });

    List<Person> persons = Arrays.asList(p1, p2, p3, p4);

    // Collections.sort(persons);

    System.out.println(persons);

    // sort using comparator
    Comparator<Person> comp = (a, b) -> {
      return a.getName().compareTo(b.getName());

    };

    Collections.sort(persons, comp.reversed());
    System.out.println(persons);
    //USING STREAM
    //sort by age
    List<Person> sortedPerson= persons.stream().sorted(Comparator.comparing(p->p.getAge())).collect(Collectors.toList());
    System.out.println(sortedPerson);
    sortedPerson=persons.stream().sorted(Comparator.comparing(p->p.getName())).collect(Collectors.toList());
    System.out.println(sortedPerson);
    //count by age
    Map<Integer,Long> countByAge=persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
    System.out.println(countByAge);
    
    //groupby department
    //flat map internally can map and retrun with orignal object and from nested streamed object array 

    Map<String,List<String>> personByDepartment = persons.stream()
        .flatMap(person -> Arrays.stream(person.getDepartments())
            .filter(department->!department.isEmpty())
            .map(department -> new AbstractMap.SimpleEntry<>(department, person)))
        .collect(
            Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(map->map.getValue().getName(), Collectors.toList())));
    System.out.println("personByDepartment: "+personByDepartment);
    String str="abcccddddeaabbbdd";
    Map<String,Long> charCount=Arrays.stream(str.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting()));
    System.out.println(charCount);
    Map<Integer,Long> numCount=Arrays.asList(1,2,3,3,4,4,22,11,22,33,33,22,11,1,2,3,4).stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
    System.out.println(numCount);
    Map<String,Long> countByDepartment =persons.stream()
    .flatMap(person->Arrays.stream(person.getDepartments()).map(department->new AbstractMap.SimpleEntry<>(department,person)))
    .collect(Collectors.groupingBy(e->e.getKey(),Collectors.counting()));
    System.out.println(countByDepartment);
    // persons.stream().flatMap(person->Arrays.stream(person.getDepartments()));

    // TODO: personByDepartment
    // TODO: charCount
    // TODO: numCount
    // TODO: countByDepartment


  }

}

class Person implements Comparable<Person> {
  private String name;
  private int age;
  private String[] departments;

  public Person(String name, int age, String[] departments) {
    this.name = name;
    this.age = age;
    this.departments = departments;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String[] getDepartments() {
    return departments;
  }

  public void setDepartments(String[] departments) {
    this.departments = departments;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.name);
    hash = 83 * hash + this.age;
    hash = 83 * hash + Arrays.deepHashCode(this.departments);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Person other = (Person) obj;
    if (this.age != other.age) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return Arrays.deepEquals(this.departments, other.departments);
  }

  @Override
  public int compareTo(Person o) {
    if (this.age > o.age)
      return 1;
    else if (this.age < o.age)
      return -1;
    else
      return 0;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", departments=" + Arrays.toString(departments) + "]";
  }

}
