package exc.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Mian {

  public static void main(String[] args) {
    Person p1 = new Person("Aintu", 22);
    Person p2 = new Person("Bintu", 23);
    Person p3 = new Person("Cintu", 19);
    System.out.println(p1.equals(p2));
    List<Person> lp=Arrays.asList(p1,p2,p3);
    Collections.sort(lp,Comparator.reverseOrder());
    System.out.println(lp);

    Comparator<Person> sortByName=(a,b)->b.name.compareTo(a.name);
    lp=Arrays.asList(p1,p2,p3);
    System.out.println(lp);
    Collections.sort(lp,(a,b)->a.name.compareTo(b.name));
    System.out.println(lp);
    lp=Arrays.asList(p1,p2,p3);
    List<Person> slp =lp.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
    System.out.println(slp);

    /*
      // sort based on name
    Map<Integer, Employee> sortedEmpMap=empMap.entrySet().stream().sorted(Comparator.comparing(a -> a.getValue().name()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1));
    System.out.println(sortedEmpMap);
    // create array
    List<Employee> empList = empMap.values().stream().collect(Collectors.toList());
    List<Employee> sortedEMplList = empList.stream().sorted(Comparator.comparing(Employee::name))
        .collect(Collectors.toList());
    System.out.println(sortedEMplList);

    sortedEmpMap=empMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::name))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    System.out.println(sortedEmpMap);
     */

  }
  
}

class Person implements Comparable<Person>{
  public String name;
  public int age;
  public Person(String name,int age){
    this.name=name;
    this.age=age;
  }
  @Override
  public int compareTo(Person other) {
    // if(this.age>o.age){
    //   return 1;
    // }else if(this.age>o.age){
    //   return -1;
    // }
    // return 0;
    return Integer.compare(this.age, other.age);
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.age;
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
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name=").append(name);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
    public String getName() {
      return name;
    }
    public int getAge() {
      return age;
    }


    
  
}