import java.util.ArrayList;
import java.util.Scanner;

public class Newton {

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                i++;
            }

    }

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        int[] b = new int[1];
        b[0] = 132;
        System.out.println(String.valueOf(b[0]).length());

        ArrayList<Double> numbers = new ArrayList<Double>();
        System.out.print("Enter the starting number for the equation: ");
        numbers.add(input.nextDouble());
        input.nextLine();
        double equation1;
        double derivativeOfEquation;
        for (int i = 0; i < 10; i++) {
            equation1 = Math.pow(numbers.get(i), 5) + Math.pow(numbers.get(i), 4) + Math.pow(numbers.get(i), 3) + Math.pow(numbers.get(i), 2) + numbers.get(i) - 999;
            derivativeOfEquation = 5 * Math.pow(numbers.get(i), 4) + 4 * Math.pow(numbers.get(i), 3) + 3 * Math.pow(numbers.get(i), 2) + 2 * numbers.get(i) + 1;
            numbers.add(numbers.get(i) - (equation1 / derivativeOfEquation));
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
