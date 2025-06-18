package 객체지향.상속.상품예제;

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
