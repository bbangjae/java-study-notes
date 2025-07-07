package 객체지향.캡슐화.객체지향;

public class MusicPlayerMainOop {
    public static void main(String[] args) {
        MusicPlayerOop musicPlayerOop = new MusicPlayerOop(false, 0);

        musicPlayerOop.volumeUp(10);
        musicPlayerOop.powerOn();
        musicPlayerOop.volumeUp(10);
        musicPlayerOop.volumeDown(10);
        musicPlayerOop.volumeDown(15);
        musicPlayerOop.volumeUp(110);
        musicPlayerOop.powerOff();
    }
}
