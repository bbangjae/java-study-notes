## SOLID 원칙
객체 지향 프로그래밍(OOP)에서 **유지보수성과 확장성을 높이기 위한 5가지 설계 원칙**

### 🎯 목적 
- **유지보수성:** 변경 시 영향 최소화
- **확장성:** 새로운 기능 추가 용이
- **재사용성:** 코드 중복 감소
- **유연성:** 구조 개선 및 테스트 용이

### 1️⃣ S - SRP (Single Responsibility Principle, 단일 책임 원칙)
**하나의 클래스**는 **하나의 책임**만 가져야 한다

#### 🎯 목적 
변경 이유를 하나로 제한해, **수정 시 연쇄 영향 방지**

#### ✅ 예시
```java
// ❌ 잘못된 예: UserService가 DB 접근까지 수행 
public class UserService {
    public void createUser(String name) {
        // 비즈니스 로직 + DB 저장을 한 클래스에서 처리
        System.out.println("사용자 생성 로직");
        System.out.println("DB 저장");
    }
}

// ✅ 올바른 예: 책임 분리
public class UserRepository {
    public void save(String name) {
        System.out.println("DB 저장");
    }
}

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public void createUser(String name) {
        System.out.println("사용자 생성 로직");
        userRepository.save(name); // DB 접근 분리
    }
}
```

### 2️⃣ O - OCP (Open/Close Principle, 개방/폐쇠 원칙) 
**확장에 열려 있고, 변경에는 닫혀 있어야 한다.**

#### 🎯 목적
기존 코드를 **수정하지 않고도 기능 확장이 가능하도록함** (인터페이스·추상화 활용)


#### ✅ 예시
```java
// ❌ 잘못된 예: OrderService가 결제 방식을 직접 변경
public class OrderService {
    public void order(String paymentType, int amount) {
        if (paymentType.equals("CARD")) {
            System.out.println("카드 결제: " + amount);
        } else if (paymentType.equals("KAKAO")) {
            System.out.println("카카오페이 결제: " + amount);
        }
    }
}

// ✅ 올바른 예: 전략 패턴 기반 확장
public interface Payment {
    void pay(int amount);
}

public class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카드 결제: " + amount);
    }
}

public class KakaoPayPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카카오페이 결제: " + amount);
    }
}

public class OrderServiceV2 {
    private final Payment payment;

    public OrderServiceV2(Payment payment) {
        this.payment = payment;
    }

    public void order(int amount) {
        payment.pay(amount);
    }
}

// 메인
OrderServiceV2 order1 = new OrderServiceV2(new CardPayment());
order1.order(1000);

OrderServiceV2 order2 = new OrderServiceV2(new KakaoPayPayment());
order2.order(2000);
```

### 3️⃣ L - LSP (Liskov Substitution Principle, 리스코프 치환 원칙)
**자식 클래스는 부모 클래스**를 **대체할** 수 있어야 한다.

#### 🎯 목적
상속관계에서 자식이 **부모의 규약을 깨지 않도록** 설계

#### ✅ 예시

```java
// 부모 클래스
class Animal {
    void sound() {
        System.out.println("동물 소리");
    }
}

// ❌ 잘못된 예시 (행동 규약을 어김)
class WrongCat extends Animal {
    @Override
    void sound() {
        System.out.println("고양이가 달린다"); // sound()가 소리를 내야 하는 규약을 위반
    }
}

// ✅ 올바른 자식 클래스
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("고양이 소리");
    }
}
```

### 4️⃣ I - ISP (Interface Segregation Principle, 인터페이스 분리 법치)
하나의 범용 인터페이스 보다 **여러 개의 구체적인 인터페이스가 낫다**

#### 🎯 목적
사용하지 않는 메서드 규현 강제를 피하고, **역할별 인터페이스 분리**

#### ✅ 예시
```java
// ❌ 잘못된 예
public interface Animal {
    void eat();
    void fly(); // 날지 못하는 동물도 구현해야 함
}

// ✅ 올바른 예
public interface Eatable {
    void eat();
}

public interface Flyable {
    void fly();
}
```

### 5️⃣ D - DIP (Dependency Inversion Principle, 의존성 역전 원칙)
상위 모듈은 하위 모듈에 의존하지 않는다. **추상화에 의존**해야 한다

#### 🎯 목적
**구현체 교체가 쉽도록 인터페이스에 의존**

#### ✅ 예시
```java
// ❌ 잘못된 예: NotificationService가 구현체(EmailSender)에 직접 의존
public class NotificationService {
    private final EmailSender emailSender = new EmailSender();

    public void notify(String message) {
        emailSender.send(message); // EmailSender에 강하게 결합
    }
}

public class EmailSender {
    public void send(String message) {
        System.out.println("이메일 전송: " + message);
    }
}

// ✅ 올바른 예: 인터페이스에 의존
public interface MessageSender {
    void send(String message);
}

public class EmailSenderV2 implements MessageSender {
    public void send(String message) {
        System.out.println("이메일 전송: " + message);
    }
}

public class SmsSender implements MessageSender {
    public void send(String message) {
        System.out.println("SMS 전송: " + message);
    }
}

public class NotificationServiceV2 {
    private final MessageSender sender;

    public NotificationServiceV2(MessageSender sender) {
        this.sender = sender;
    }

    public void notify(String message) {
        sender.send(message);
    }
}

// 메인
NotificationServiceV2 emailService = new NotificationServiceV2(new EmailSenderV2());
emailService.notify("안녕하세요!");

NotificationServiceV2 smsService = new NotificationServiceV2(new SmsSender());
smsService.notify("반갑습니다!");
```
