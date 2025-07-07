# 📖 static 메서드 (정적 메서드, 클래스 메서드)의 이해와 필요성

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ static 메서드 (정적 메서드, 클래스 메서드)](#-static-메서드-정적-메서드-클래스-메서드)
    1. [특징](#특징)
4. [💡 static 메서드의 필요성](#-static-메서드의-필요성)
   1. [가정](#가정)
   2. [✨ 대안: static 메서드 활용](#-대안-static-메서드-활용)
5. [static 메서드 내에 인스턴스 변수, 인스턴스 메서드 사용 예시](#static-메서드-내에-인스턴스-변수-인스턴스-메서드-사용-예시)
6. [🔓 static 메서드 접근 방법](#-static-메서드-접근-방법)
7. [🔍 메서드의 종류](#-메서드의-종류)
   1. [📊 메서드 비교](#-메서드-비교)
8. [🏷️ import static](#-import-static)
9. [🏆 결론](#-결론)

# 📚 소개

`static` 메서드는 클래스 인스턴스화 없이 호출할 수 있으며, 클래스가 메모리에 로드 될 때 자동으로 생성됩니다.

## 🔍 핵심 질문
* **static 메서드의 필요성:** static 메서드가 무엇이고, 어떨 때 사용하는지, 사용했을 때의 장점이 무엇인지 확인하고 싶습니다.

# 🏷️ static 메서드 (정적 메서드, 클래스 메서드)

객체를 생성하지 않고 사용할 수 있는 메서드

## 특징

1. **관리**: `static` 메서드는 메서드영역 안에 있는 클래스 자체에 저장 되고 호출 시 바로 메서드 영역에서 가져옴. 따라서 객체를 생성 하지 않고 클래스 이름을 통해 직접 호출한다.
2. **제한:** `static` 메서드 내에서는  `static`**변수**와 `static` **메서드**만 사용할 수 있다. 그러나, 인스턴스 참조를 통하여 인스턴스 변수와 인스턴스 메서드 사용 가능하다.
3. **접근:** `static` 메서드는 인스턴스를 통해서도 접근할 수 있지만, **클래스 이름을 통해 접근하는 것이 권장된다.**
4. **용도:** 주로 유틸리티 클래스에서 사용된다. (`Math.max()`, `Math.sqrt()`)

# 💡 static 메서드의 필요성

## 가정

멤버 변수가 필요 없는 서로의 숫자를 계산 해주는 클래스를 만든다고 가정 해보겠습니다.

### 방법: 클래스 내 메서드 사용

- **문제점:** 멤버 변수를 초기화를 해주지도 않는데 객체를 생성한다.

```java
public class Main {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    System.out.println(calculator.add(5,3)); // 8
    System.out.println(calculator.subtract(5,3)); // 2
  }
}

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }
}
```

## ✨ 대안: static 메서드 활용

- `static` 메서드를 활용하여 객체를 생성하지 않고 바로 메서드를 호출할 수 있다. **(특징1)**

```java
public class Main {
  public static void main(String[] args) {
        // 객체를 생성 하지 않고 static 메서드 호출
        System.out.println("5와 3을 더한 결과: " + Calculator.add(5, 3)); // 8
        System.out.println("5와 3을 뺀 결과: " + Calculator.subtract( 5, 3)); // 2
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
```

## **static 메서드 내에 인스턴스 변수, 인스턴스 메서드 사용 예시**

- 객체의 참조 값을 받아 `static` 메서드에서도 인스턴스 변수와 인스턴스 메서드를 사용 할 수 있다. 

```java
public class StaticMethodExampleMain {
    public static void main(String[] args) {
        MaxCalculator maxCalculator = new MaxCalculator(10);
        MaxCalculator.callMaxValue(maxCalculator); // 10, 10
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
        // static 메서드에서는 인스턴스 변수와 메서드를 직접 접근할 수 없지만, 인스턴스 메서드와 변수는 참조를 통해 접근 가능    
        System.out.println("static 메서드에서 인스턴스 변수를 호출 한 값: " + maxCalculator.maxValue);
        System.out.println("static 메서드에서 인스턴스 메서드를 호출 한 값: " + maxCalculator.getMaxValue());
    }
}
```

## 🔓 static 메서드 접근 방법

- **인스턴스 접근:** 인스턴스를 통해 접근
    - 객체를 생성한 후 해당 인스턴스를 통해서 접근 (`calculator.add(5,3)`)
- **클래스 접근:** 클래스를 통해 바로 접근
    - 객체를 생성하지 않고 클래스를 통해서 바로 접근 (`Calculator.add(5,3)`)

# 🔍 메서드의 종류

- **인스턴스 메서드:** `static`이 **붙지 않는** 메서드
- **클래스 메서드(정적 변수, static 변수):** `static`이 **붙은** 메서드

## 📊 메서드 비교

|  | 인스턴스 메서드               | static 메서드(클래스 메서드, 정적 메서드) |
| --- |------------------------| --- |
| 메모리 저장 위치 | 메서드 영역 (단, 객체와 연결 됨)   | 메서드 영역 |
| 생성 횟수 | 한 번                    | 한 번 |
| 생명 주기 | GC(가비지 컬렉션)가 발생 전 (동적) | JVM 로딩 시부터 종료 시까지 (정적) |
| 초기화 | 객체 생성 시 초기화            | 클래스 로딩 시 자동 초기화 |
| 접근성 | 인스턴스 변수와 메서드가 접근 가능    | 인스턴스 변수나 인스턴스 메서드가 직접 접근 불가 |
| 용도 | 객체의 상태나 행동에 따라 작업 수행   | 클레스 레벨의 공통 작업 수행, 유틸리티 함수등 |

# 🏷️ import static

- 특정 클래스의 `static`메서드를 클래스 이름 없이 바로 사용하도록 할 수 있도록 해주는 문법입니다.
- **사용방법:** `import static` **패키지명.클래스명.함수명**

```java
// StaticMethodExampleMain.java
package 정적.메서드;

import static 정적.메서드.util.MathUtil.max;

public class StaticMethodMain {
    public static void main(String[] args) {
        // 클래스 이름 없이 static 메서드 호출 (import static 사용 시)
        System.out.println("3과 5 중 더 큰 값: " + max(3, 5)); // 5 
    }
}

// MathUtil.java
public class MathUtil {
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
```

# 🏆 결론

**`static`메서드**는 객체를 생성하지 않고 사용할 수 있는 메서드입니다.

- **장점:**
    - **메모리 효율성:** 객체를 생성하지 않고도 메서드를 호출 할 수 있어, 메모리 자원을 효율적으로 사용할 수 있다.
    - **재사용성:** 객체 생성 없이도 접근할 수 있어, 다양한 클래스에서 공통적으로 사용할 수 있다.
- **주요 용도:**
    - **유틸리티 클래스:** 상태를 가지지 않고 공통적인 작업을 수행하는 메서드를 정의할 때 주로 사용된다.