## 캡슐화
**데이터와 메서드를 하나의 단위로 묶고, 접근을 제한**하는 것

#### 🎯 목적
- 객체 내부 **상태(데이터) 보호**
- 변경 시 **영향 최소화**

#### ✅ 예시

```java
class MusicPlayerOop {
    private int volume; // 외부 접근 제한

    void volumeUp(int volume) {
        if (!isOn) {
            System.out.println("전원이 꺼져 있습니다.");
            return;
        }

        if (this.volume + volume > 100) {
            System.out.println("더 이상 볼륨을 늘릴 수 없습니다.");
            return;
        }

        this.volume += volume;
        System.out.println("현재 볼륨 상태: " + this.volume);
    }
}
```