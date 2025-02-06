
import java.util.List;

public class BinarySearch{
  public static void binarySearch(List<Integer> li,int targetValue){
    int n=li.size();
    int targetIndex=n/2;
    while(true){
      if(li.get(targetIndex)==targetValue){
        break;
        
      }else{
        if(targetValue>li.get(targetIndex)){
          targetIndex=(targetIndex+n)/2;
        }else if(targetValue<li.get(targetIndex)){
          n=targetIndex;
          targetIndex/=2;
        }
      }
    }
    System.out.println("AT: "+targetIndex+", Value= "+li.get(targetIndex));
    
  }
}