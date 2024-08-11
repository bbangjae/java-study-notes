package finalexample;

public class ElectricCar extends Car {
    String name;
    int speed;

    ElectricCar(String name) {
        this.name = name;
    }

    void speedUp(int acceleration) {
        int newSpeed = this.speed + acceleration;
        if (newSpeed > Constant.MAX_SPEED) {
            return;
        }
        this.speed = newSpeed;
    }

    void modifyCarName(final String newName) {
        // 컴파일 오류
        // newName = Tesla;
        this.name = newName;
    }

    // final 메서드 오버라이딩 불가
    // @Override
    // void startEngine() {
    //     System.out.println("전기차 가동");
    // }
}
