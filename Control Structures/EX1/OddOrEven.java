import java.util.Scanner;

public class OddOrEven{
    
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int number = input.nextInt();

        if (number % 2 == 0)
            System.out.println("Even");
        else System.out.println("Odd");

  }
}