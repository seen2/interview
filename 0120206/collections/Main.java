import java.util.*;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello there!");
    //1. Write a Java program to create an ArrayList and add elements to it.
    List<String> list = new ArrayList<>();
    list.add("Test");

    //Write a Java method to iterate over a LinkedList.

    List<String> ll=new LinkedList<>();
    ll.add("Testing LinkedList 1");
    ll.add("Testing LinkedList 2");
    System.out.println(ll);
    for(String li:ll){
      System.out.println(li);
    }

    int [] intArr={1,2,3,4,5};
    for(int i:intArr){
      System.out.println(i);
    }

    //Write a Java program to create a HashSet and add elements to it.
    Set<String> set = new HashSet<>();
    set.add("6211"); // to check if really sorts as the hash value results sorting for single digit numbers
    set.add("7");
    set.add("2");
    set.add("5");
    set.add("1");
    set.add(null);
    set.add(new String("1"));
    set.add((new StringBuffer("1")).toString());
    System.out.println("****** Hash Set ******");
    System.out.println(set);

    //Write a Java method to check if an element exists in a TreeSet.

    Set<Integer> intSet = new TreeSet<>();
    intSet.add(1);
    intSet.add(3);
    intSet.add(2);
    intSet.add(1);
    intSet.add(5);
    intSet.add(4);
    // intSet.add(null); //error as it doesn't accepts the null value unlike HashSet

    System.out.println("****** Tree Set ******");
    intSet.stream().forEach(e->System.out.println(e));

    //Write a Java program to create a HashMap and add key-value pairs to it.

    Map<String, Object> hm =new HashMap<>();
    hm.put("1", 1);
    hm.put("1", "One");
    hm.put("One", 1);
    System.out.println(hm);

    //Write a Java method to iterate over the keys of a TreeMap

    Map<String,String> tm = new TreeMap<>();
    tm.put("1", "One");
    tm.put("1", "1");
    tm.put("One", "One");
    tm.put("One", "1");

    System.out.println(tm);

    //Write a Java program to create a PriorityQueue and add elements to it.
    System.out.println("***** Priority Queue *******");
    PriorityQueue<Task> pq=new PriorityQueue<>((a,b)->{
      if(a.priorityLevel<b.priorityLevel) return 1;
      else if(a.priorityLevel>b.priorityLevel) return -1;
      else return 0;
    });

    pq.add(new Task("Look", 3));
    pq.add(new Task("Look Again", 2));
    pq.add(new Task("Look Once More", 1));

    System.out.println(pq);

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
    System.out.println(pq);


  }

}

class Task{
  public int priorityLevel;
  public String taskName;

  Task(String taskName, int priorityLevel){
    this.priorityLevel=priorityLevel;
    this.taskName=taskName;
  }

  @Override
  public String toString(){
    return "[ Task: "+this.taskName+", Priority: "+this.priorityLevel+" ]";
  }
}

