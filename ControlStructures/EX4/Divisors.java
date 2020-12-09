package ControlStructures.EX4;

import java.util.Scanner;

public class Divisors{

    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int number = input.nextInt();

        for (int i = 1; i <= number; i++) if (number % i == 0) System.out.println(i);

  }
}