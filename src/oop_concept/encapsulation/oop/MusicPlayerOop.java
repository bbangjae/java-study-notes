package oop_concept.encapsulation.oop;

class MusicPlayerOop {
    private boolean isOn;
    private int volume;

    MusicPlayerOop(boolean isOn, int volume) {
        this.isOn = isOn;
        this.volume = volume;
    }

    void powerOn() {
        if (isOn) {
            System.out.println("이미 전원이 켜져 있습니다.");
            return;
        }

        isOn = true;
        System.out.println("전원을 켰습니다.");
    }

    void powerOff() {
        if (!isOn) {
            System.out.println("이미 전원이 꺼져 있습니다.");
            return;
        }

        isOn = false;
        System.out.println("전원을 껐습니다.");
    }

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

    void volumeDown(int volume) {
        if (!isOn) {
            System.out.println("전원이 꺼져 있습니다.");
            return;
        }

        if (this.volume - volume < 0) {
            System.out.println("더 이상 볼륨을 줄일 수 없습니다.");
            return;
        }

        this.volume -= volume;
        System.out.println("현재 볼륨 상태: " + this.volume);
    }
}
