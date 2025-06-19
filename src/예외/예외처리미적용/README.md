# 📖 예외 처리 전 코드

## 📑 목차
1. [📚 소개](#-소개)
2. [🔍 핵심 질문](#-핵심-질문)
3. [🏷️ 예외 처리 전 코드의 문제점](#-예외-처리-전-코드의-문제점)
    1. [오류 처리 방식](#오류-처리-방식)
    2. [문제점](#문제점)
4. [🏆 결론](#-결론)

# 📚 소개

자바에서 **예외 처리를 적용하기 전**에 작성한 네트워크 메시지 전송 과정을 다루는 예제입니다.  
이 코드는 예외 처리를 사용하지 않고, 오류 상황을 문자열로 처리하는 방식으로 구현되어 있습니다.  
이를 통해 예외 처리의 필요성과 한계를 직접 경험하고 이해할 수 있습니다.

# **🔍 핵심 질문**

1. 예외 처리 없이 네트워크 오류를 어떻게 처리했을까?
2. 예외 처리 전 코드의 문제점은 무엇일까?
3. 예외 처리를 적용하면 어떻게 개선될 수 있을까?

# **🏷️ 예외 처리 전 코드의 문제점**

## 오류 처리 방식

#### 오류 발생 시 예외를 던지지 않고, `connectError`, `sendError` 같은 문자열을 반환하여 상태를 전달합니다.

```java
String connect() {
    if(connectError) {
        return "connectError";
    }
    System.out.println(address+ " 서버 접속 성공");
    return "success";
}
```

<br>

#### 반환된 문자열을 검사하여 오류 여부를 판단하고, 메시지를 출력합니다.

```java
class NetWorkService {
   void sendMessage(String message) {
      String address = "https://www.google.com";
      NetWorkClient netWorkClient = new NetWorkClient(address);
          netWorkClient.initError(message);
       
       // 연결 단계에서 오류가 발생하면 메시지 출력
       if (isError(netWorkClient.connect())) {
           System.out.println("[네트워크 오류] 서버 연결 실패");
       // 전송 단계에서 오류가 발생하면 메시지 출력
       } else if (isError(netWorkClient.send(message))) {
           System.out.println("[네트워크 오류] 데이터 전송 실패");
       }
       netWorkClient.disconnect();
       }

    private static boolean isError(String result) {
        return !result.equals("success");
    }
}
```

## 문제점
- 정상 흐름과 예외  흐름이 코드 내에서 섞여 있어, 한눈에 로직을 파악하기 어렵고 가독성이 떨어집니다.
- 오류 처리 로직이 분산되고, 문자열 비교에 의존해 실수가 발생할 수 있습니다. 
- 오류의 종류가 많아질수록 관리와 확장이 더욱 어려워집니다.

# **🏆** 결론
- 예외 처리를 사용하지 않고 문자열 상태값으로 오류를 처리하는 방식은 간단하지만, 정상 흐름과 예외 흐름이 뒤섞여 코드의 가독성과 유지보수가 떨어지는 심각한 단점이 있습니다.
- 예외 상황이 많아질수록 코드가 복잡해지고, 실수나 버그가 발생할 위험이 커집니다.
- `자바의 예외 처리(Exception Handling)`를 적극적으로 활용하면, 오류 상황을 명확하게 구분하고, 코드의 안정성과 유지보수성을 크게 높일 수 있을걸로 보입니다.