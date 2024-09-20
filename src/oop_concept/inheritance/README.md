# 📖 자바 상속과 `super` 키워드

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ 상속](#-상속)
   1. [특징](#특징)
   2. [사용 예시](#사용-예시)
4. [🏷️ 상속과 메모리 구조](#-상속과-메모리-구조)
5. [🏷️ 메서드 오버라이딩](#-메서드-오버라이딩)
   1. [오버라이딩의 조건](#오버라이딩의-조건)
   2. [사용 예시](#사용-예시-1)
6. [🏷️ super 키워드](#-super-키워드)
   1. [사용 예시](#사용-예시-2)
8. [🏆 결론](#-결론)

# 📚 소개

상속은 객체 지향 프로그램 핵심 요소 중 하나로, 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용하게 해준다.

# **🔍 핵심 질문**

1. 상속은 무엇이고 사용하면 어떤 이점이 있을까?
2. 상속 관계에서 객체가 생성될 때 메모리 구조는 어떻게 동작할까?
3. 오버라이딩은 무엇이고 어떤 경우에 사용되는가?
4. `super` 키워드를 어떤 경우에 사용되는가?

# **🏷️ 상속**

## 특징

1. **재사용성:** 부모 클래스에서 정의된 필드와 메서드를 자식 클래스가 그대로 사용할 수 있어 코드의 중복을 줄인다.
2. **단일 상속:** 자바는 **단일 상속**을 지원하므로, 한 클래스는 하나의 부모 클래스만 상속받을 수 있다.
3. **오버라이딩**: 자식 클래스는 부모 클래스의 메서드를 **자신만의 방식으로 재정의**(오버 라이딩) 할 수 있다.

## 사용 예시

- `ElectricCar`클래스에서 `Car`클래스의  `move()`메서드를 정의 하지 않아도 move()를 사용할 수 있다.

```java
// Car.java
class Car {
  int speed;
  
  void move() {
        System.out.println("차가 출발합니다.");
  }
}

// ElectricCar.java
class ElectricCar extends Car {
}

// main.java
public static void main(String[] args) {
  ElectricCar tesla = new ElectricCar();
  tesla.speed = 10; // Car 클래스에서 상속받은 speed 필드를 정의
  tesla.move(); // 차가 출발합니다.

}
```

# **🏷️** 상속과 메모리 구조

1. 자식 클래스의 객체가 생성 될 때, 부모 클래스의 생성자가 먼저 호출되며 **부모 클래스와 자식 클래스가 모두 메모리에 생성**된다.
2. 메서드나 필드를 호출 할 때 **해당 클래스의 메모리**에서 **먼저 확인**하고, **없으면 부모 클래스**를 순차적으로 **확인**한다.
3. 부모 클래스에도 해당 메서드나 필드가 없을 경우 **컴파일 오류** 발생한다.

# **🏷️** 메서드 오버라이딩

오버라이딩은 부모 클래스에서 정의된 메서드를 자식 클래스에서 재정의하는 기능이다.

## 오버라이딩의 조건

1. **메서드 이름, 매개변수, 반환 타입이 부모 클래스**의 메서드와 **동일**해야 한다.
2. **접근 제한자**는 부모 클래스의 메서드보다 더 제한적 일 수 없다.
3. 부모 클래스의 메서드가 `final`로 선언 되어 있으면 오버라이딩 할 수 없다.

## 사용 예시

- `ElectricCar`클래스에서 `Car`클래스의 `move()`메서드를 재정의 하였다.

```java
// Car.java
class Car {
  void move() {
    System.out.println("차가 출발합니다.");
  }
}

// ElectricCar.java
class ElectricCar extends Car {
  @Override
  void move() {
    System.out.println("전기차가 출발합니다.");
  }
}

// main.java
public static void main(String[] args) {
  ElectricCar tesla = new ElectricCar();
  tesla.move(); // 전기차가 출발합니다. 

}
```

# **🏷️ super 키워드**

`super`키워드는 자식의 클래스에서 부모 클래스의 **필드**나 **메서드**를 참조할 때 사용된다. 주로 부모 클래스의 오버라이딩된 메서드를 호출하거나, 부모 클래스의 생성자를 명시적으로 호출할 때 사용된다.

## 사용 예시

1. **부모 클래스 생성자 호출:** 자식 클래스의 생성자에서 부모 클래스의 생성자를 명시적으로 호출 한다.

```java
// Car.java
class Car {
  int speed;
  
  Car (int speed) {
    this.speed = speed;
  }
}

// ElectricCar.java
class ElectricCar extends Car {
  String carName;
  
  ElectricCar (int speed, String carName) {
    super(speed);
    this.carName = carName;
  }
}

// main.java
public static void main(String[] args) {
  ElectricCar tesla = new ElectricCar(100, "tesla");
}
```

2. **부모 클래스의 메서드 호출**: 자식 클래스에서 오버라이딩한 메서드 내에서 부모 클래스의 메서드를 호출할 수 있다.

```java
// Car.java
class Car {
  void move() {
    System.out.println("차가 출발합니다.");
  }
}

// ElectricCar.java
class ElectricCar extends Car {
  @Override
  void move() {
    super.move();
    System.out.println("전기차가 출발합니다.");
  }
}

// main.java
public static void main(String[] args) {
  ElectricCar tesla = new ElectricCar();
  tesla.move(); // 차가 출발합니다. 
                // 전기차가 출발합니다. 
}
```

# **🏆** 결론

상속은 자바 프로그램의 **코드의 재사용성**과 **확정성**을 높이고 **유지보수**를 용이하게 한다.

- **장점:**
  - **코드의 재사용성:** 부모 클래스에서 이미 정의된 속성과 메서드를 자식 클래스에서 다시 정의할 필요 없이 그대로 사용하여 **코드의 중복을 줄이고** 유지보수를 용이하게 한다.
  - **확장성**: 상속을 통해 기존 클래스에 기능을 추가하거나 변경할 수 있어, 유연한 시스템 설계가 가능하다
  - **유지보수 용이성**: 코드의 공통 부분을 부모 클래스에 두고, 자식 클래스에서 이를 재사용하므로 코드 변경이 필요할 때 **부모 클래스에만 수정**하면 되므로 유지보수가 쉽다.