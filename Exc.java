
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exc {

  public static void main(String[] args) {
    
    // TODO: Create simple Spring CRUD App -DONE


    // TODO: sorting -> comparator, comparable, stream -- Done
    List<String> projects=new ArrayList<>();
    projects.add("Testing");
    projects.add("Deployment");
    Person p1=new Person("Abhi",21,projects.stream().collect(Collectors.toList()));
    projects.clear();
    projects.add("Testing");
    projects.add("Deployment");
    Person p2=new Person("Shivam",23,projects.stream().collect(Collectors.toList()));
    projects.clear();
    projects.add("Dev");
    projects.add("Deployment");
    Person p3=new Person("Mahesh",22,projects.stream().collect(Collectors.toList()));

    List<Person> persons=Arrays.asList(p1,p2,p3);

    // System.out.println(persons);
    Collections.sort(persons,Comparator.reverseOrder());
    // System.out.println(persons);

    Comparator<Person> compByName=(a,b)->a.getName().compareTo(b.getName());

    Collections.sort(persons,compByName);
    // System.out.println(persons);

    // System.out.println(persons.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    // System.out.println(persons.stream().sorted().collect(Collectors.toList()));
    // System.out.println(persons.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    // System.out.println(persons.stream().sorted(Comparator.comparing(Person::getName).reversed()).collect(Collectors.toList()));

    // TODO: Practice Array and String
    // TODO: Practice collections
    // TODO: employeeByDepartment
    // TODO: charCount
    // TODO: numCount
    // TODO: countByDepartment
    // TODO: employeeByDepartment
    persons.stream()
    .flatMap(person->person.getProjects().stream()
      .map(project->new AbstractMap.SimpleEntry<>(project,person)))
    .collect(Collectors.groupingBy(el->el.getKey(),Collectors.mapping(person->person.getValue().getName(), Collectors.toList())));
    persons.stream()
    .flatMap(person->person.getProjects().stream()
      .map(project->new AbstractMap.SimpleEntry<>(project,persons)))
    .collect(Collectors.groupingBy(el->el.getKey(),Collectors.counting()));
    

  }
}

class Person implements Comparable<Person>{
  private String name;
  private int age;
  private List<String> projects;

  public Person(String name, int age, List<String> projects) {
    this.name = name;
    this.age = age;
    this.projects = projects;
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

  public List<String> getProjects() {
    return projects;
  }

  public void setProjects(List<String> projects) {
    this.projects = projects;
  }

  @Override
  public int compareTo(Person other){
    if(this.getAge()>other.getAge()) return 1;
    else if(this.getAge()<other.getAge()) return -1;
    else return 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + age;
    result = prime * result + ((projects == null) ? 0 : projects.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (age != other.age)
      return false;
    if (projects == null) {
      if (other.projects != null)
        return false;
    } else if (!projects.equals(other.projects))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", projects=" + projects + "]";
  }

  

}