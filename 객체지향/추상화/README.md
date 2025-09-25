## 추상화
**공통된 속성과 동작을 추출하여 모델화** 하는 것

#### 🎯 목적
- 불필요한 세부사항을 감추고 **핵심만 표현**
- **코드의 재사용성과 유연성 확보**

#### ✅ 예시

```java
// ❌ 추상화 안 된 경우
class Dog {
    void sound() {
        System.out.println("멍멍");
    }
}

class Cat {
    void sound() {
        System.out.println("야옹");
    }
}

// ✅ 추상화 된 경우
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
```