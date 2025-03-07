public class Exc1 {

  public static void main(String[] args) {
    System.out.println("Hello");
    Human h = new Man("Sintu", 22, 0, null);
    h.speak();
    h = new Woman("Shivangi", 21, 0, null);
    h.speak();
    h = () -> System.out.println("Speaking..");
    h.speak();
    System.out.println(h.getClass());

    // TODO: Practice Array and String
    // TODO: Practice collections
    // TODO: employeeByDepartment
    // TODO: charCount
    // TODO: numCount
    // TODO: countByDepartment
    // TODO: sorting -> comparator, comparable, stream

    // TODO: Create simple Spring CRUD App -WIP

  }
}

@FunctionalInterface
interface Human {

  public void speak();

}

class Person extends Employee implements Human {
  private String name;
  private int age;

  @Override
  public void speak() {
    System.out.println(this.getClass() + ": Speaking....");
  }

  @Override
  public void workStat() {
    System.out.println();
  }

  public Person(String name, int age, double salary, String department) {
    this.name = name;
    this.age = age;
    this.department = department;
    this.salary = salary;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + age;
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
    return age == other.age;
  }

  

}

abstract class Employee {
  double salary;
  String department;

  public double getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public abstract void workStat();

}

class Man extends Person {

  private final char gender;

  public Man(String name, int age, double salary, String department) {
    super(name, age, salary, department);
    this.gender = 'M';
  }

  public char getGender() {
    return gender;
  }

}

class Woman extends Person {

  private final char gender;

  public Woman(String name, int age, double salary, String department) {
    super(name, age, salary, department);
    this.gender = 'F';
  }

  public char getGender() {
    return gender;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + gender;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass())
      return false;

    Woman other = (Woman) obj;
    return gender == other.gender;
  }

}