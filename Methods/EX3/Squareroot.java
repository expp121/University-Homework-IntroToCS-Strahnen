public class Squareroot {

  public static void main(String args[]) {
    System.out.println(squareRoot(3));
    System.out.println(squareroot(3));

  }

  public static double squareRoot(double d) {
    return Math.pow(d, 0.5);
  }

  public static double squareroot(double d) {
    double half = d / 2;
    double squareRoot = (half + (d / half)) / 2.0;

    do {
      half = squareRoot;
      squareRoot = (half + (d / half)) / 2.0;
    } while ((half - squareRoot) != 0);

    return squareRoot;
  }
}