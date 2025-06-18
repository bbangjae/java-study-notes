package 정적.메서드;

import static 정적.메서드.util.MathUtil.max;
public class StaticMethodExampleMain {
    public static void main(String[] args) {
        // 객체를 생성 하지 않고 static 메서드 호출
        System.out.println("5와 3을 더한 결과: " + Calculator.add(5, 3)); // 8
        System.out.println("5와 3을 뺀 결과: " + Calculator.subtract( 5, 3)); // 2

        // 클래스 이름 없이 static 메서드 호출 (import static 사용 시)
        System.out.println("3과 5 중 더 큰 값: " + max(3, 5)); // 5


        // static 메서드에서는 인스턴스 변수와 메서드를 인스턴스 메서드와 변수 접근 시 컴파일 오류
        // MaxCalculator.invalidCallCalculator();

        // static 메서드에서는 인스턴스 변수와 메서드를 직접 접근할 수 없지만, 인스턴스 메서드와 변수는 참조를 통해 접근 가능
        MaxCalculator maxCalculator = new MaxCalculator(10);
        MaxCalculator.validCallCalculator(maxCalculator);
    }
}
class Calculator {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

class MaxCalculator {
    private int maxValue;

    public MaxCalculator(int maxValue) {
        this.maxValue = maxValue;
    }

    int getMaxValue() {
      return maxValue;
    }

    // static 메서드 인스턴스 변수, 인스턴스 메서드를 사용 한 경우 컴파일 오류가 발생
    // static void invalidCallCalculator () {
    //     System.out.println("static 메서드에서 인스턴스 변수를 호출 한 값: " + maxCalculator.maxValue);
    //     System.out.println("static 메서드에서 인스턴스 메서드를 호출 한 값: " + maxCalculator.getMaxValue());
    // }

    static void validCallCalculator(MaxCalculator maxCalculator) {
        System.out.println("static 메서드에서 인스턴스 변수를 호출 한 값: " + maxCalculator.maxValue);
        System.out.println("static 메서드에서 인스턴스 메서드를 호출 한 값: " + maxCalculator.getMaxValue());
    }
}