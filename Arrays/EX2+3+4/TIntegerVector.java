public class TIntegerVector {
  public static void main(String args[]) {

    IntegerVector vector = new IntegerVector();
    IntegerVector vector2 = new IntegerVector(5);
    IntegerVector vector3 = new IntegerVector(vector);
    System.out.println(
        "vector 1  size: " + vector.size() + "\nvector 2  size: " + vector2.size() + "\nvector 3  size: " + vector3.size());

    for (int i = 1; i < 6; i++) {
      vector.add(i);
      vector2.add(i);
      vector3.add(i);
    }
    vector.add(vector2);
    System.out.println("vector 1  values: " + vector.toString() + "\nvector 2  values: " + vector2.toString()
        + "\nvector 3  values: " + vector3.toString());
    System.out.println("vector Value at index 2: " + vector.valuetAt(2));
    System.out.println("vector Value at index -2: " + vector.valuetAt(-2));
    System.out.println("vector index of value 2: " + vector.indexOf(2));
    System.out.println("vector index of value 24: " + vector.indexOf(24));
    System.out.println("vector sum: " + vector.sum());
    System.out.println("vector average: " + vector.average());
    System.out.println("vector setting element with index 3 to 42");
    vector.setAtIndex(3, 42);
    System.out.println("vector values: " + vector.toString());
    System.out.println("does vector contain the value 42: " +vector.contains(42));
    System.out.println("Is vector sorted: " +vector.isSorted() + "\nSorting it...");
    vector.sort();
    System.out.println("vector values: " + vector.toString());
    System.out.println("Is vector sorted: " +vector.isSorted());
    System.out.println("Is vector 1 equal to vector 2: " + vector.equals(vector2));
    System.out.println("Is vector 2 equal to vector 3: " + vector2.equals(vector3));

    System.out.println("\n\nvector values: " + vector.toString());
    System.out.println("removing the first found value of \'5\' from the vector");
    vector.removeByFirstFoundVal(5);
    System.out.println("vector values: " + vector.toString());

    System.out.println("removing the value from index 6");
    vector.removeByIndex(6);
    System.out.println("vector values: " + vector.toString());
  }
}