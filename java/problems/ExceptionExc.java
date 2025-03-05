public class ExceptionExc {

  public static void main(String[] args) {
    try {
        throw new CustomException("Some Error");
    } catch (CustomException e) {
      System.out.println(e.getMessage());
    }
  }
  
}


class CustomException extends  Exception{
  public CustomException(String message){
    super(message);
  }

}
