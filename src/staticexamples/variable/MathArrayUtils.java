package staticexamples.variable;

class MathArrayUtils {

    // 인스턴스 생성 막기
    private MathArrayUtils() {

    }

    static int sumArray(int[] values) {
        if (values.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int value : values) {

            sum += value;
        }
        return sum;
    }

    static double averageArray(int[] values) {
        if (values.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int value : values) {

            sum += value;
        }
        return (double) sum / values.length;
    }

    static int minArray(int[] values) {
        if (values.length == 0) {
            return -1;
        }
        int min = 0;
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    static int maxArray(int[] values) {
        if (values.length == 0) {
            return -1;
        }
        int max = 0;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
