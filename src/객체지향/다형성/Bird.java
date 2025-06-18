package 객체지향.다형성;

public class Bird extends Animal implements Fly {

    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("날고 있습니다.");
    }
}
