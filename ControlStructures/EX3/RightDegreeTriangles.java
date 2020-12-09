package ControlStructures.EX3;

public class RightDegreeTriangles {

    public static void main(String args[]){

      int a,b,c;

      do {
        System.out.print("A: ");
        a = Integer.parseInt(System.console().readLine()); 
        
      } while (a < 1 || a > 100);

      do {
        System.out.print("B: ");
        b = Integer.parseInt(System.console().readLine()); 
        
      } while (b < 1 || b > 100);

      do {
        System.out.print("C: ");
        c = Integer.parseInt(System.console().readLine()); 
        
      } while (c < 1 || c > 100);
      

      for (int i = 1; i < a; i++)
          for (int j = 1; j < b; j++)
            for (int j2 = 1; j2 < c; j2++)
              if ( ((i * i) + (j * j)) == (j2 * j2) )
                System.out.println("\nFor\nA = "+ i + "\nB = " + j + "\nC = " + j2 + 
                "\nThe following is true: a^2 + b^2 = c^2");
    }
}