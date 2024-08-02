package staticexamples.variable;

import static staticexamples.variable.MathArrayUtils.*;
public class ArrayMain {
    public static void main(String[] args) {

        int[] values = {3, 1, 9, 4, 5};

        System.out.println("sum=" + sumArray(values));
        System.out.println("average=" + averageArray(values));
        System.out.println("min=" + minArray(values));
        System.out.println("max=" + maxArray(values));
    }

}

