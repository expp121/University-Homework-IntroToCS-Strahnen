package ControlStructures.EX6;

public class RandomNumber {

    public static void main(String args[]){
        float avg = 0;
        int generatedNumber;

        for (int i = 0; i < 100; i++){
            generatedNumber = (int)(Math.random()*100)+1;
            avg += generatedNumber;
            System.out.print(generatedNumber + ",");
        }
            System.out.println(" = " + avg/100);        
  }
}