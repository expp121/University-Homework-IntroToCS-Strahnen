public class Test {

    public static void main(String[] args) {
        List l = new List();

        l.insert(new OrderedInteger(20));

        l.insert(new OrderedInteger(80));

        l.insert(new OrderedInteger(50));
        System.out.println(l.elementCount());
        l.printElements();

//        int[] vec = new int[3];
//        try {
//            initialize(vec);
//            process(vec);
//            show(vec);
//        } catch (RuntimeException e) {
//            Terminal.put("Incorrigible Error");
//        }
//
//        List<ComparableInteger> l = new List<ComparableInteger>();
//        l.insert(new ComparableInteger(5));
//        l.insert(new ComparableInteger(3));
//        l.insert(new ComparableInteger(6));
//        l.insert(new ComparableInteger(4));
    }
//
//    private static void initialize(int[] v) {
//        for (int count = 0, val = 1; count < v.length; ++count, val += val) {
//            v[count] = val;
//            Terminal.put(val);
//        }
//    }
//
//    private static void process(int[] v) {
//        int sum = 0;
//        try {
//            for (int i = 0; i <= v.length; ++i) {
//                sum = sum + v[i];
//                v[i] = sum;
//                Terminal.put(sum);
//            }
//        } catch (Exception e) {
//            Terminal.put("Error in \"process\"");
//        }
//    }
//
//    private static void show(int[] v) {
//        for (int k = 0; k <= v.length; k = k + k + 1) {
//            Terminal.put(v[k]);
//        }
//    }
//

}

class OrderedInteger implements Ordered {

    private int value;

    @Override
    public String toString() {
        return "OrderedInteger{" +
                "value=" + value +
                '}';
    }

    public OrderedInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Ordered other) {
        return value - ((OrderedInteger) other).value;
    }
}

class ComparableInteger implements Comparable {
    private int value = 0;

    public ComparableInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Comparable other) {
        return this.value - ((ComparableInteger) other).value;
    }
}
