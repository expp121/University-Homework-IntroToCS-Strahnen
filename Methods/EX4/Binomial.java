package Methods.EX4;

public class Binomial {

    public static void main(String args[]) {
        System.out.println(binomial(20, 6));
    }
    
    public static long binomial(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}