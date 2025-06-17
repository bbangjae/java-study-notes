package oop_concept.poly;

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
