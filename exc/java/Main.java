package exc.java;

public class Main {

  public static void main(String[] args) {
    // int x,y;
    //   try (Scanner sc = new Scanner(System.in)) {
    //       System.out.println("x:");
    //       x=sc.nextInt();
    //       System.out.println("y:");
    //       y=sc.nextInt();
    //       System.out.println("x+y="+(x+y));
    //     }
    Animal human= new Human("Sintu");
    System.out.println(human);
    // human=((Human) human);
    ((Human) human).setGender("M");
    System.out.println(human);

    Cow myCow=new Cow();
    System.out.println("Lay Eggs: "+myCow.layEggs()+", Give Birth: "+myCow.giveBirth());
  }
}

class Animal{
  protected String name;
}

interface Bird{
  public abstract boolean layEggs();
}
interface Mamal{
  public abstract boolean giveBirth();
}

class Human extends Animal{

    private String gender;

    public Human(String name) {
      this.name=name;
    }

    public String getName(String name){
      return this.name;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    @Override
    public String toString(){
      return "N: "+this.name+", G: "+this.gender;
    }
  
}

class Cow extends Animal implements Mamal, Bird{

  @Override
  public boolean layEggs(){
    return false;
  }

  @Override
  public boolean giveBirth(){
    return true;
  }

}