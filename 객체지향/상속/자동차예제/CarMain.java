package 객체지향.상속.자동차예제;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar(100, "tesla");
        System.out.println(tesla.speed);
        System.out.println(tesla.carName);
        tesla.move();
    }
}
