# 📖 static 변수 (정적 변수, 클래스 변수)의 이해와 필요성

## 📑 목차
1. [📚소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ static 변수 (정적 변수, 클래스 변수)](#-static-변수-정적-변수-클래스-변수)
   1. [특징](#특징)
4. [💡 static 변수의 필요성](#-static-변수의-필요성)
   1. [가정](#가정)
   2. [방법 1: 멤버 변수 사용](#방법-1-멤버-변수-사용)
   3. [방법 2: 별도 클래스 사용](#방법-2-별도-클래스-사용)
   4. [✨ 대안: static 변수 사용](#-대안-static-변수-사용)
5. [🔍 멤버 변수(필드)의 종류](#-멤버-변수필드의-종류)
6. [📊 변수 비교](#-변수-비교)
7. [🔓 static 변수 접근 방법](#-static-변수-접근-방법)
8. [🏆 결론](#-결론)

## 📚 소개
static 변수는 클래스에 속하며 모든 인스턴스가 동일한 값을 공유하는 변수다. 이를 통해 메모리 효율성을 높이고 데이터를 쉽게 공유할 수 있습니다.

## 🔍 핵심 질문
* **static 변수의 필요성:** static 변수가 무엇이고, 어떨 때 사용하는지 확인하고 싶습니다.

## 🏷️ static 변수 (정적 변수, 클래스 변수)

- 모든 인스턴스가 공유하는 변수

### 특징

- **공유:** 모든 인스턴스가 같은 `static`변수를 공유하며, 어떤 인스턴스에서든 값을 변경할 수 있다.
- **관리:** `static` 변수는 메서드 영역이 관리하는 변수이다. 메서드 영역에 클래스 변수는 하나만 존재한다.
- **접근:** 인스턴스를 통해서도 접근할 수 있지만, **클래스를 통해 접근하는 것이 권장됨**

## 💡 static 변수의 필요성

### 가정
특정 객체가 몇 번 생성되었는지 구한다고 해보자.

### 방법 1: 멤**버 변수 사용**

- **문제점:** 객체가 생성될 때마다, 멤버 변수 값이 계속 초기화 되기 때문에 멤버 변수만으로는 생성된 객체의 수를 추적할 수 없다.

```java
public class Student {
  String name;
  int age;
  int studentCount; // 객체 생성 시마다 해당 멤버변수 계속 초기화됨
}
```

### 방법 2: 별도 **클래스 사용**

- **방법**: `Counter`클래스를 만들고 객체의 개수를 추적한다.
- **문제점**
  - `Counter`클래스를 별도로 만들어야 함



```java
public class Main {
  public static void main(String[] args) {
        Counter count = new Counter();
        Student byun = new Student("byun", 13, count);
        Student jae = new Student("jae ", 15, count);

        System.out.println(count.studentCount); // 2 
    }
}

class Counter {
    int studentCount;
}

class Student {
    private String name;
    private int age;

    Student (String name, int age, Counter counter) {
        this.name = name;
        this.age = age;
        counter.studentCount++;
    }
}
```
## ✨ 대안: **static 변수 사용**

- **해결방법:** `Student` 클래스의 `studentCount`를 `static` 변수로 정의하여, 객체의 개수를 간단하게 추적할 수 있다.


```java
public class Main {
  public static void main(String[] args) {
        Student byun = new Student("byun", 13);
        Student jae = new Student("jae ", 15);

        Student.showStudentCount(); // 2
    }
}

class Student {
    private String name;
    private int age;
    private static int studentCount; //static 변수

    Student (String name, int age) {
        this.name = name;
        this.age = age;
        studentCount++; // static 변수를 통해 객체의 수를 셀수 있다.
    }

    static void showStudentCount() {
        System.out.println("총 학생 수: " + studentCount);
    }
}
```

## 🔍 멤버 변수(필드)의 종류

- **인스턴스 변수:** `static`이 **붙지 않는** 변수
- **클래스 변수(정적 변수, static 변수):** `static`이 **붙은** 변수

## 📊 변수 비교

|  | 인스턴스 변수 | static 변수 (클래스 변수, 정적 변수) | 지역 변수 |
| --- | --- | --- | --- |
| 메모리 저장 위치 | 힙 영역 | 메서드 영역 | 스택 영역 |
| 생성 횟수 | 인스턴스가 생성될 때마다 | 한 번 | 메서드가 호출될 때마다 |
| 목적 | 특정 객체의 변수 값으로 | 여러 곳에서 공유하는 목적 | 메서드안에서 사용하기 위해 |
| 생명 주기 | GC(가비지 컬렉션)가 발생 전 (동적) | JVM 로딩 시부터 종료 시까지 (정적) | 메서드 종료 시 제거 |

## 🔓 static 변수 접근 방법

- **인스턴스를 통한 접근 `Student.studentCount`**
  - 힙 영역으로 갔다가 메서드 영역으로 접근
  - **권장 하지 않음:** 인스턴스를 통해 접근하는 것처럼 보일 수 있음
- **클래스를 통한 접근 `Student.studentCount`**
  - 직접 Method 영역으로 접근


# 🏆 결론

**`static`변수**는 클래스의 모든 인스턴스가 동일한 값을 공유하는 변수

- **장점:**
    - **메모리 효율성:** `static` 변수는 클래스 로드 시 메모리에 할당되며, 프로그램이 종료될 때까지 유지되므로, 인스턴스마다 별도의 메모리를 할당하지 않아서 메모리 사용을 절약할 수 있다.
    - **데이터 공유:** 여러 인스턴스 간에 데이터를 공유할 때 유용하다. 예를 들어, 전체 객체의 개수, 애플리케이션 설정 값 등을 static 변수로 관리할 수 있다.