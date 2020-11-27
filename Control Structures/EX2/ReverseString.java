import java.util.Scanner;

public class ReverseString{

    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        
	String word = input.nextLine();

        for (int i = word.length()-1 ; i >= 0; i--) System.out.print(word.charAt(i));
        System.out.println();
  }
}