package oop_concept.encapsulation.oop;

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
