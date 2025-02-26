
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Exc {

  public static void main(String[] args) {
    Person p1 = new Person("Sintu", 27, new String[] { "Dev", "Testing" });
    Person p2 = new Person("Shivam", 22, new String[] { "Dev", "Testing" });
    Person p3 = new Person("Shivansh", 21, new String[] { "Dev", "Testing" });
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
  }

}

class Person implements Comparable<Person> {
  private String name;
  private int age;
  private String[] projects;

  public Person(String name, int age, String[] projects) {
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

  public String[] getProjects() {
    return projects;
  }

  public void setProjects(String[] projects) {
    this.projects = projects;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.name);
    hash = 83 * hash + this.age;
    hash = 83 * hash + Arrays.deepHashCode(this.projects);
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
    return Arrays.deepEquals(this.projects, other.projects);
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
    return "Person [name=" + name + ", age=" + age + ", projects=" + Arrays.toString(projects) + "]";
  }

}
