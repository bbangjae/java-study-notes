package 객체지향.상속.자동차예제;

public class Car {
    int speed;

    Car (int speed) {
        this.speed = speed;
    }

    void move() {
        System.out.println("차가 출발합니다.");
    }
}
