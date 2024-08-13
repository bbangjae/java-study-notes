package oop_concept.inheritance.example1;

class Item {
    String name;
    int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void print() {
        System.out.println("이름:" + name + ", 가격:" + price);
    }

    int getPrice() {
        return price;
    }
}
