package 객체지향.상속.자동차예제;

public class ElectricCar extends Car{
    String carName;

    ElectricCar(int speed, String carName) {
        super(speed);
        this.carName = carName;
    }

    @Override
    void move() {
        super.move();
        System.out.println("전기차가 출발 합니다.");
    }
}
