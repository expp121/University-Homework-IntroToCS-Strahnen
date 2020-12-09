package ControlStructures.EX5;

import java.util.Scanner;

public class MadeOf{
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String args[]){
        
        StringBuilder consistsOf = new StringBuilder();
        int multyplicator = 1;
        int counter = 2;

        System.out.print("Enter a number: ");
        int userNumber = input.nextInt();
        int divisor = userNumber;
        
        do {

            if (isPrime(counter)) {
                if (divisor % counter == 0) {
                    divisor /= counter;
                    multyplicator *= counter;
                    consistsOf.append(counter + " * ");
                    counter = 2;
                }
                else
                    counter++;
            }
            else
                counter++;
                
        } while (multyplicator < userNumber);
        consistsOf.delete(consistsOf.length()-2, consistsOf.length());
        System.out.println(userNumber + " = " + consistsOf.toString());

    }

    public static boolean isPrime(int number) {

        boolean flag = false;

        for(int i = 2; i <= number/2; ++i){
            
            if(number % i == 0){
            flag = true;
            break;
            }
        }

        if (!flag)
            return true;
        else
            return false;
    }
}