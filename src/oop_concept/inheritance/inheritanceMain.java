package oop_concept.inheritance;

public class inheritanceMain {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar(100, "tesla");
        System.out.println(tesla.speed);
        System.out.println(tesla.carName);
        tesla.move();
    }
}
