# 1. JVM & GC

## JVM (Java Virtual Machine)

자바 프로그램이 운영체제에 종속되지 않고 실행될 수 있게 해주는 **가상 머신**

### 🎯역할
- 플랫폼 독립성 제공: 한 번 작성하면 어디서나 실행(Write Once, Run Anywhere)
- 바이트코드 해석·실행
- 메모리 관리 및 GC 수행

### JVM 실행순서

1. `.java 파일`을 컴파일러을 통해 `.class`파일로 변환
2. `class 파일`을 JVM의 ClassLoader(클래스로더)에 적재
3. 실행 엔진이 바이트코드를 해석·JIT 컴파일
4. 런타임 데이터 영역에 객체, 메서드 정보 저장
5. GC가 사용하지 않는 객체 메모리 해제

### JVM 메모리 구조

- **Method Area (메서드 영역)** : 클래스 정보(메타데이터), static 변수, 상수 풀 저장
- **Heap Area (힙 영역)** : 객체 인스턴스와 배열 저장 (GC 대상)
- **Stack Area (스택 영역)** : 각 스레드별 메서드 호출 스택(지역 변수, 매개변수)
- **PC Register (프로그램 카운터 레지스터)** : 현재 실행 중인 명령어 주소 저장
- **Native Method Stack (네이티브 메서드 스택)** : C/C++ 같은 네이티브 코드 실행 위한 스택

## GC (Garbage Collection)
- JVM이 **더 이상 참조되지 않는 객체**를 자동으로 메모리에서 해제하는 과정

### 🎯 목적
- 메모리 누수 방지
- 메모리 관리 자동화

## GC 기본 동작 방식
1. Reachability Analysis로 객체 참조 여부 확인
2. 참조가 끊긴 객체(가비지)를 수집
3. 힙 메모리를 정리

---

# 2. HashMap & ConcurrentHashMap

## 해싱 (Hashing)

- 데이터를 **빠르게 저장하고 조회** 할 수 있도록 하는 기법
- **Key에 특정 연산(해시 함수)** 을 적용하여 **테이블의 저장 위치**를 계산

## 해시 함수 (Hash Function)

- 임의의 데이터를 특정 값으로 매핑시키는 함수
- Java에서는 주로 객체의 hashCode() 메서드를 해시 함수로 사용
- 시간 복잡도: 일반적으로 **O(1)**

## 해시 충돌

- 서로 다른 키가 **같은 해시값을 반환하는 경우**
- 해시 충돌이 발생하면, **같은 버킷(bucket)에 여러 데이터가 저장**
- 좋은 해시 함수는 충돌 가능성을 **최대한 낮게 설계**


## HashMap

해시 기반 자료구조는 **Key-Value 쌍**으로 데이터를 저장하는 구조  
**해시 함수(Hash Function)** 를 통해 키(key)를 해시값으로 변환하여 데이터를 저장

```java
Map<String, Integer> map = new HashMap<>();
```

### ⚙️ 특징
- **Key-Value 구조**로 데이터를 저장함
- **중복된 키(key)는 허용되지 않음**
- **순서에 상관없이** 데이터를 **저장/조회**할 수 있음


### ✅ 장점
- 해시 충돌 없는 경우 **검색, 삽입, 삭제**가 **빠름** (평균 O(1))
- Key를 통해 직접 접근 → **빠르고 효율적인 조회**
- 데이터 양이 많아도 **성능 유지에 강함** (충돌이 적을 경우)

### ❌ 단점
- 해시 충돌 시 **성능 저하** (최악 O(n))
- 순서가 보장되지 않음 (단, LinkedHashMap 사용 시 순서 유지)


## ConcurrentHashMap
멀티스레드 환경에서 안전하게 동작하도록 설계된 `java.util.concurrent` 패키지의 **Map 구현체**

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
```


### 🎯 목적

- 멀티스레드 환경에서 **동시성(Concurrency) 보장**
- `synchronized`블록 없이 **고성능 읽기/쓰기 가능**
- 동시성 제어 및 성능 저하 최소화

### ️ ⚙️ 특징
- 여러 스레드가 동시에 접근해도 안전
- Java 8 이후 버킷 단위 락(Bin Lock) & CAS(Compare-And-Swap) 기반으로 동작
- Null Key/Value 허용하지 않음

### ⏱️ 시간 복잡도

| 연산   | 평균 시간 복잡도 | 최악 시간 복잡도 | 설명                              |
|--------|-----------------|-----------------|---------------------------------|
| 접근   | -               | -               | 직접 인덱스 접근 불가            |
| 탐색   | O(1)            | O(n)            | 해시 충돌 시 버킷이 리스트로 작동 |
| 삽입   | O(1)            | O(n)            | 해시 충돌이 없는 경우 빠름       |
| 삭제   | O(1)            | O(n)            | 해시 충돌이 없는 경우 빠름            |

---
# 3. 오버로딩 (Overloading) & 오버라이딩 (OverRiding)

## 오버 로딩 (Overloading)
**같은 이름의 메서드**를 매개변수의 타입/개수만 **다르게 정의**하는 것

### 🎯 목적
- 같은 기능을 하는 메서드를 다양한 매개변수 형태로 제공
- 코드 가독성 및 재사용성 향상

### ⚙️ 특징
- 동일 메서드명, 매개변수는 다르다
- 반환 타입만 다르고 매개변수 목록이 같으면 오버로딩 불가

```java
public class Calculator {
    // int 두 개 덧셈
    public int add(int a, int b) {
        return a + b;
    }

    // double 두 개 덧셈 (오버로딩)
    public double add(double a, double b) {
        return a + b;
    }

    // int 세 개 덧셈 (오버로딩)
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

## 오버라이딩 (OverRiding)
**상속받은 메서드**를 자식 클래스에서 **재정의**하는 것

### 🎯 목적

- 부모 클래스의 기능을 자식 클래스 상황에 맞게 **변경·확장**
- 다형성(Polymorphism) 구현

### ⚙️ 특징
- 메서드 이름, 매개변수 목록, 반환 타입이 부모 메서드와 동일해야 함

```java
class Animal {
    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound(); // 멍멍
    }
}
```


