# 멤버 변수 초기화와 접근 제어자 이해

## 주요 질문
- 참조형(클래스) 변수는 처음부터 <span style="color: red; font-weight: bold;">멤버 변수</span>인지 <span style="color: blue; font-weight: bold;">지역 변수</span>인지 궁금합니다.
- 참조형(클래스) 변수를 멤버 변수로 선언할 때 <span style="color: green; font-weight: bold;">기본 초기화</span>가 어떻게 되는지 궁금합니다.
- 클래스 내 메서드에 <span style="color: red; font-weight: bold;">접근 제어자를 적지 않으면</span>, 외부 클래스의 접근 제어자는 어떻게 되는지 궁금합니다.

## 결론
- 클래스 <span style="color: red; font-weight: bold;">내부에 선언된</span> 참조형 변수는 <span style="color: red; font-weight: bold;">멤버 변수</span>입니다. 메서드 내에서 선언된 참조형 변수는 <span style="color: blue; font-weight: bold;">지역 변수</span>입니다.
- <span style="color: red; font-weight: bold;">멤버 변수로 선언된</span> <span style="color: blue; font-weight: bold;">참조형 변수</span>는 <span style="color: red; font-weight: bold;"> 초기화하지 않으면 </span> 기본적으로 `null`로 초기화됩니다.
- 메서드 선언 시 <span style="color: red; font-weight: bold;"> 접근 제어자를 적지 않으면 </span> 기본적으로 **`default`** (package-private) 접근 제어자를 갖습니다.
