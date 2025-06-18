package 객체지향.상속.상품예제;

class Album extends Item {
    String artist;

    Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    void print() {
        super.print();
        System.out.println("- 아티스트:" + artist);
    }
}
