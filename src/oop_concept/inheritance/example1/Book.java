package oop_concept.inheritance.example1;

class Book extends Item {
    String author;

    Book(String name, int price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    void print() {
        super.print();
        System.out.println("- 저자:" + author);
    }
}
