package oop_concept.poly;

public class Main {
    public static void main(String[] args) {

        Animal[] aArr = { new Cat(), new Caw() };
        for (Animal animal : aArr) {
            animalSound(animal);
        }
    }

    private static void animalSound(Animal animal) {
        animal.sound();
    }
}
