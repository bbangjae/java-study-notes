package finalexamples;

public class finalMain {
    public static void main(String[] args) {

        final ElectricCar tesla = new ElectricCar("ModelS");
        // 참조 값 변경 불가
        //tesla = new ElectricCar("ModelY");
        tesla.name = "ModelY";

        tesla.startEngine();

        // 상수 변경 불가
        // Constant.MAX_SPEED = 200;
    }
}
