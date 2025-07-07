package 객체지향.다형성;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = { new Cat(), new Caw(), new Bird()};
        for (Animal animal : animals) {
            animalSound(animal);
            if (animal instanceof Fly) {
                ((Fly) animal).fly();
            }
        }
    }

    private static void animalSound(Animal animal) {
        animal.sound();
    }
}
