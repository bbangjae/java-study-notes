package 객체지향.캡슐화.절차지향;

public class MusicPlayerMainProcedural {
    public static void main(String[] args) {
        MusicPlayerProcedural musicPlayerProcedural = new MusicPlayerProcedural();

        volumeUp(musicPlayerProcedural, 10);
        powerOn(musicPlayerProcedural);
        volumeUp(musicPlayerProcedural, 10);
        volumeDown(musicPlayerProcedural, 10);
        volumeDown(musicPlayerProcedural, 15);
        volumeUp(musicPlayerProcedural, 110);
        powerOff(musicPlayerProcedural);
    }

    static void powerOn(MusicPlayerProcedural musicPlayerProcedural) {
        if (musicPlayerProcedural.isOn) {
            System.out.println("이미 전원이 켜져 있습니다.");
            return;
        }

        musicPlayerProcedural.isOn = true;
        System.out.println("전원을 켰습니다.");
    }

    static void powerOff(MusicPlayerProcedural musicPlayerProcedural) {
        if (!musicPlayerProcedural.isOn) {
            System.out.println("이미 전원이 꺼져 있습니다.");
            return;
        }

        musicPlayerProcedural.isOn = false;
        System.out.println("전원을 껐습니다.");
    }

    static void volumeUp(MusicPlayerProcedural musicPlayerProcedural, int volume) {
        if (!musicPlayerProcedural.isOn) {
            System.out.println("전원이 꺼져 있습니다.");
            return;
        }

        if (musicPlayerProcedural.volume + volume > 100) {
            System.out.println("더 이상 볼륨을 늘릴 수 없습니다.");
            return;
        }

        musicPlayerProcedural.volume += volume;
        System.out.println("현재 볼륨 상태: " + musicPlayerProcedural.volume);
    }

    static void volumeDown(MusicPlayerProcedural musicPlayerProcedural, int volume) {
        if (!musicPlayerProcedural.isOn) {
            System.out.println("전원이 꺼져 있습니다.");
            return;
        }

        if (musicPlayerProcedural.volume - volume < 0) {
            System.out.println("더 이상 볼륨을 줄일 수 없습니다.");
            return;
        }

        musicPlayerProcedural.volume -= volume;
        System.out.println("현재 볼륨 상태: " + musicPlayerProcedural.volume);
    }
}
