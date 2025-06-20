# 📖 예외 처리 적용 네트워크 메시지 전송 예제

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ 예외 처리 전 코드의 문제점](#-예외-처리-전-코드의-문제점)
    1. [오류 처리 방식](#오류-처리-방식)
    2. [문제점](#문제점)
4. [🏆 결론](#-결론)

# 📚 소개

이 예제는 자바에서 예외 처리(Exception Handling), 언체크 예외(Unchecked Exception), 예외 계층화, Try-With-Resources 등 실무에서 사용하는 패턴을 적용하여 네트워크 메시지 전송 과정을 구현한 코드입니다.  
정상 흐름과 예외 흐름을 명확히 분리하고, 예외별 세분화 및 자동 리소스 관리를 통해 실무 수준의 코드 품질과 유지보수성을 확보하고자 작성하였습니다.

# 🔍 핵심 질문

1. 예외 처리를 적용하면 코드가 어떻게 달라지는가?
2. 실무에서 예외 처리를 왜 중요하게 여기는가?
3. 예외 상황을 어떻게 구체적으로 구분하고, 사용자와 개발자에게 각각 어떻게 안내할 수 있는가?
4. 체크 예외와 언체크 예외의 차이는 무엇이며, 언제 어떻게 선택하는가?

# 💡 예외 처리 개념 정리
## 🔐 체크 예외(Checked Exceptions) vs 언체크 예외(Unchecked Exceptions)

| 특성                | 체크 예외 (Checked)                     | 언체크 예외 (Unchecked)                                 |
|---------------------|-------------------------------------|----------------------------------------------------|
| **컴파일 시 검증**  | 필수 (`catch` 또는 `throws`)            | 선택 사항 (`throws` 생략 가능)                             |
| **상속 계층**       | `Exception` 하위 클래스                  | `RuntimeException` 하위 클래스                            |
| **처리 의무**       | 반드시 명시적 처리 필요                       | 개발자 선택                    |
| **예시**            | `IOException`, `SQLException`       | `NullPointerException`, `IllegalArgumentException` |

---

> **체크 예외 (Checked Exceptions):**
> - 복구 가능한 상황(예: 파일 없음, 일시적 네트워크 장애 등)에 주로 사용. 반드시 예외 처리 또는 throws 선언 필요  
> - 컴파일러가 강제 검사 → 미처리 시 컴파일 에러

> **언체크 예외 (Unchecked Exceptions)**
> - 복구 불가능한 상황에 사용. 예외 처리 강제하지 않음.

## 🔄 Try-With-Resources

- **자동 리소스 관리:** AutoCloseable을 구현한 객체는 try-with-resources 구문에서 사용 시 자동으로 close() 호출

- **리소스 누수 방지:** 예외 발생 시에도 안전하게 리소스 해제

- **코드 간소화:** 명시적인 finally 블록 불필요

```java
// NetworkService.java
void sendMessage(String data) {
   try (NetworkClient networkClient = new NetworkClient(address)) {
      networkClient.initError(data);
      networkClient.connect();
      networkClient.send(data);
   }
}

// NetworkClient.java
class NetworkClient implements AutoCloseable {
   @Override
   public void close() {
      disconnect();
   }
}
```

# 💡 예외 처리 적용의 목적과 효과 

- **정상 흐름과 예외 흐름의 명확한 분리** 
  - 가독성, 유지보수성, 확장성 향상

- **예외 계층화** 
  - 오류 원인별 세분화, 각 예외에 맞는 핸들러 작성 가능

- **언체크 예외 전략**
  - 복구 불가능 오류에 대한 실무적 접근, throws 선언 최소화로 코드 간결화

- **Try-With-Resources 활용**
  - 네트워크 등 리소스 자동 해제, 안전성 확보

# 🏷️ 핵심 코드 및 구조

#### 예외 계층화
```java
// NetworkException.java
public class NetworkException extends RuntimeException { }
public class SendException extends NetworkException { }
public class ConnectException extends NetworkException { }
```
- 예외를 계층화해 원인별 구분 가능
- 상위 예외로 통합 처리 또는 하위 예외로 세분화 처리 가능

---

#### 핸들러 분리

```java
// Main.java
   public static void main(String[] args) {
       try {
           networkService.sendMessage(input);
       } catch (ConnectException e) {
           handleConnectException(e);
       } catch (SendException e) {
           handleSendException(e);
       } catch (Exception e) {
           handleUnknownException(e);
       }
   }
```
- 예외별 로깅/대응 전략 구분 가능 
- 가독성, 유지보수성, 확장성 향상

--- 

#### 언체크 예외 & Try-With-Resources 적용

```java
// NetworkService.java
void sendMessage(String data) {
    try (NetworkClient networkClient = new NetworkClient(address)) {
        networkClient.initError(data);
        networkClient.connect();
        networkClient.send(data);
    }
}
```
- 코드 간결화
- 리소스 누수 방지

# **🏆** 결론

- **정상 흐름과 예외 흐름의 명확한 분리의 필요성**
  - 예외 처리를 하지 않으면 코드 흐름이 뒤섞여 가독성과 유지보수성이 크게 저하 할 수 있다.

- **예외 계층화의 중요성**
  - 예외를 세분화함으로써 오류 원인을 구체적으로 파악할 수 있고, 예외별로 다른 대응이 가능하다.

- **언체크 예외(Unchecked Exception) 활용의 장점** 
  - 체크 예외보다 언체크 예외를 사용하는 것이 코드의 간결성과 실용성을 높인다.
  
- **Try-With-Resources 문법의 실효성**
  - 리소스 누수 위험을 줄이면서 코드가 더욱 깔끔하고 안전하게 작성 할 수 있다.