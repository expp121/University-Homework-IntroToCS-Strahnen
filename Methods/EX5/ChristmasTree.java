import java.util.Scanner;
public class ChristmasTree{
    
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int height;
        System.out.print("Trunk Height ? ");
        height = input.nextInt();
        
        for (int i = 0; i < (3*height) + 1; i++) {
            
            if (i < height*2 + 1) {
            
                for (int j = 0; j < (2 * height - i ); j++) System.out.print(' ');
            
                for (int j = 0; j < (1 + i * 2); j++) System.out.print('*');
                
                for (int j = 0; j < (2 * height - i ); j++) System.out.print(' ');
                System.out.println();
            }
            else{
                
                    for (int j = 0; j < 2 * height; j++) System.out.print(' ');
                    System.out.print('*');
                    for (int j = 0; j < 2 * height; j++) System.out.print(' ');
                    System.out.println();
            }
        }

  }
}