package Methods.EX2;

public class PoweredNumber {

    public static void main(String args[]){
    System.out.println(power(2,3));
    System.out.println(power(3,3));    

  }


  public static int power(int x, int exponent){
    int temp = x;

    for (int i = 1; i < exponent; i++)      
        x *= temp;
    return x;
  }
}