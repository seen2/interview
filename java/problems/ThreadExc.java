public class ThreadExc {

  public static void main(String[] args) throws InterruptedException {
    MyThread t1=new MyThread();
    t1.start();
    t1.join();
    System.out.println("Inside main: "+Counter.getCount());

    Runnable r1=()->{
      Counter.increament();
      System.out.println("Inside Runnabel: "+Counter.getCount());
    };
    Thread t2 = new Thread(r1);

    t2.start();
    t2.join();
    System.out.println("Inside main: "+Counter.getCount());

    MyCounter counter=(a)->{
      a++;
      return a;
    };
    System.out.println(counter.increament(0));

    MyCounter counter2=new MyCounter(){

      @Override
      public int increament(int a){
        a++;
        return a;
      }
    };

    System.out.println(counter2.increament(1));


    
  }
  
}


class MyThread extends Thread{


  @Override
  public void run(){
    Counter.increament();
    System.out.println("Inside thread: "+Counter.getCount());
  }

  



}

class Counter{
  private static int count=0;

  public static int getCount(){
    return count;
  }

  public static void increament(){
    count++;
  }
}

@FunctionalInterface
interface MyCounter{
  int increament(int count);
}
