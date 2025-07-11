# 📖 자바 다형성(Polymorphism)

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ 다형성과 메모리 구조](#-다형성과-메모리-구조)
4. [🏷️ 다형성(Polymorphism)이란?](#-다형성polymorphism이란)
   1. [특징](#특징)
   2. [사용 예시](#사용-예시)
5. [🏷️ 인터페이스와 다형성](#-인터페이스와-다형성)
    1. [사용 예시](#사용-예시-1) 
6. [🏆 결론](#-결론)

# 📚 소개

자바의 **다형성(Polymorphism)** 개념을 실전 예제와 함께 설명하고, 객체지향 프로그래밍에서 다형성이 왜 중요한지 정리합니다.

# **🔍 핵심 질문**

1. 다형성은 무엇이고 사용하면 어떤 이점이 있을까?
2. 다형성 구현 시 메모리 구조는 어떻게 동작하는가?
3. 다형성과 오버라이딩을 통해 코드의 확장성과 유연성을 어떻게 높일 수 있는가?

# **🏷️ 다형성(Polymorphism)이란?**

> **다형성(Polymorphism)은 객체지향 프로그래밍의 핵심 개념으로,  
> “하나의 타입(부모 클래스 또는 인터페이스)으로 여러 형태의 객체(자식 클래스들)를 다룰 수 있게 해주는 원리”입니다.**

## 특징

1. **동적 바인딩:** 실행 시점에 실제 객체의 메서드가 호출되어 유연한 코드 작성이 가능하다.
2. **코드의 확장성:** 새로운 기능 추가 시 기존 코드를 수정하지 않고 확장할 수 있다.
3. **유지보수 용이**: 공통 인터페이스나 부모 클래스를 활용해 코드의 중복을 줄이고 관리가 편리하다.

# **🏷️** 다형성과 메모리 구조

1. 객체 생성 시 부모와 자식 클래스 모두 메모리에 생성되며, 부모 생성자가 먼저 호출된다.
2. 메서드 호출 시 실제 객체의 타입에 따라 오버라이딩된 메서드가 실행된다.
3. 필드 접근 시 참조 변수의 타입 기준으로 접근한다.
4. 업캐스팅/다운캐스팅을 통해 다양한 객체를 하나의 배열이나 컬렉션으로 묶어 처리할 수 있다.

## 사용 예시

### 다형성과 오버라이딩 활용
- 부모 타입(Animal) 배열이나 리스트에 여러 자식 객체(Cat, Caw)를 담아, 반복문으로 공통 메서드를 호출하면 각 객체에 맞는 동작이 실행시킨다.
- **객체를 추가로 생성하지 않고** 이미 생성된 객체의 다형적 특성을 활용하여 유연하게 동작을 확장할 수 있다는 장점을 가진다. 

```java
// Animal.java
abstract class Animal {

    void sound() {
        System.out.println("동물 소리");
    }
}

// Cat.java
class Cat extends Animal {

    void sound() {
        System.out.println("냐옹");
    }
}

// Caw.java
class Caw extends Animal {
    void sound() {
        System.out.println("음메");
    }
}



// Main.java
public class Main {
    public static void main(String[] args) {

        Animal[] animals = { new Cat(), new Caw() };
        for (Animal animal : animals) {
            animalSound(animal);
        }
    }

    private static void animalSound(Animal animal) {
        animal.sound();
    }
}
```
# **🏷️ 인터페이스와 다형성**

> **인터페이스(Interface):** 반드시 구현해야 할 메서드 집합 정의 → 다양한 클래스가 동일한 동작을 여러 방식으로 구현 가능
    
## 사용 예시
- 별도의 객체 생성이나 코드 수정 없이, 기존 객체들의 **다형성 및 인터페이스 구현 여부를 활용하여 동작을 유연하게 확장**할 수 있음을 보여준다.

```java
// Fly.java
interface Fly {
    void fly();
}

// Bird.java
public class Bird extends Animal implements Fly {

    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("날고 있습니다.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat(), new Caw(), new Bird()};
        for (Animal animal : animals) {

            if (animal instanceof Fly) {
                ((Fly) animal).fly();
            }
        }
    }
}
```

# **🏆** 결론

다형성은 자바를 비롯한 객체지향 프로그래밍에서 **유연성**, **확장성**, **유지보수성**을 크게 향상시킨다.

- **장점:**
    - **확장성:** 새로운 기능이나 클래스를 추가할 때 기존 코드를 거의 수정하지 않아도 되어 변화에 유연하게 대응할 수 있습니다.
    - **유지보수성:** 코드 중복을 줄이고, 수정 시 영향 범위를 최소화하여 안정적인 코드 관리를 가능하게 합니다.
    - **재사용성:** 작성된 클래스나 인터페이스를 다양한 상황에서 재활용할 수 있어 개발 효율성과 코드 품질이 함께 향상됩니다.