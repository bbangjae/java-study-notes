# 📖 `Final`키워드와 상수

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ Final](#-Final)
   1. [특징](#특징)
   2. [장점](#장점)
   3. [사용 예시](#사용-예시)
4. [🏷️ 상수](#-상수)
   1. [특징](#특징-1)
5. [🏆 결론](#-결론)

# 📚 소개

`Final`키워드는 한번 설정한 값은 변경 할 수 없으며, 프로그램이 끝날 때까지 동일한 값을 유지합니다.

# 🔍 핵심 질문
1. `final`키워드는 무엇이고 사용하면 어떤 장점이 있는가?
2. `final`키워드는 어떤 경우에 사용되는가?

# 🏷️ `Final`

한번 만 할당되거나 정의된 후 변경될 수 없도록 하는 키워드

## 특징

1. 값을 고정 시킴
2. 오버라이딩 또는 상속이 불가능 함
3. 메서드 및 클래스의 변경 불가능

## 장점

1. **안정성 향상:** 변수 값이 변경되지 않아 예기치 않은 오류 발생 가능성을 줄인다.
2. **가독성 및 유지보수성 향상:** 변수의 값이 변경되지 않음을 명확히 표시하여 코드 이해를 돕는다.

## 사용 예시

1. **변수**
   1. `final` 키워드를 사용하여 변수 선언 시, 해당 변수는 상수가 된다.

       ```java
       final int MAX_SPEED = 100;
       // MAX_SPEED = 200; // 컴파일 오류
       ```

2. **메서드**
   1. 메서드에 `final` 키워드를 사용하면, 하위 클래스에서 해당 메서드를 오버라이딩 할 수 없다.

       ```java
       class Car {
           final void startEngine() {
               System.out.println("엔진 가동");
           }
       }
    
       // class ElectricCar extends Car {
       //   // 오류 발생 
       //   final void startEngine() {
       //         System.out.println("전가차 엔진 가동");
       //     }
       ```

3. **클래스**
   1. 클래스에 `final` 키워드를 사용하면 해당 클래스를 상속할 수 없다.
   
       ```java
       final class Car {
           final void move() {
               // 메서드의 내용
           }
       }
    
       class ElectricCar extends Car { // 오류 발생
    
         }
       ```

4. **매개변수**
   1. 매개변수에 `final`을 사용하면, 해당 매개변수의 값을 변경할 수 없다..

       ```java
       void modifyCarName(final String newName) {
         // 컴파일 오류
         // newName = Tesla;
         this.name = newName;
       }
       ```

5. **참조 형 변수**
   1. 참조형 변수의 참조 값은 변경할 수 없지만, 참조 대상의 멤버 변수는 변경할 수 있다.

       ```java
       public static void main(String[] args) {
               final ElectricCar tesla = new ElectricCar("ModelS");
               //tesla = new ElectricCar("ModelY");
               tesla.name = "ModelY";
           }
    
       class ElectricCar {
           String name;
    
           ElectricCar(String name) {
               this.name = name;
           }
       }
       ```

# 🏷️ 상수

변하지 않는 값

- `static final` 을 사용하여 선언한다.
- 상수명은 대문자를 사용하고  단어는 `_`로 구분한다. (`CONST_VALUE`)
- 상수들은 애플리케이션 전반에서 사용 되므로 보통 `Constant`클래스로 관리한다.

## 특징

1. 여러 곳에서 사용되지만, 하나만 만들어 메모리 낭비를 방지할 수 있습니다.
2. 상수를 한 클래스에서 관리할 수 있어 유지보수가 용이합니다.
3. 변수명만 보고도 의미를 이해할 수 있어 매직 넘버를 피할 수 있습니다.
4. 상수를 프로그램 전역에서 재사용할 수 있습니다.

```java
// Constant.java
public class Constant {
  static final int MAX_SPEED = 100;
}

// ElectricCar.java
public class ElectricCar {
  void speedUp(int acceleration) {
      int newSpeed = this.speed + acceleration;
      if (newSpeed > Constant.MAX_SPEED) {
          return;
      }
      this.speed = newSpeed;
  }
}
```

# 🏆 결론

`final`키워드는 자바 프로그램의 안정성과 가독성을 높인다.

- **장점:**
  - **메모리 효율성:** 변하지 않는 객체를 활용하여 메모리 낭비를 방지한다.
  - **코드 안정성:** 예기치 않은 값 변경을 방지하여 오류 발생 가능성을 줄인다.
  - **가독성:** 코드의 의도를 명확하게 전달한다.
- **주요 용도:**
  - 상수 선언
  - 메서드 오버라이딩 방지
  - 클래스 상속 방지