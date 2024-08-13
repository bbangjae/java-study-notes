package oop_concept.inheritance.example1;

class ShopMain {
    public static void main(String[] args) {
        Book book = new Book("몰입", 10000, "황농문");
        Album album = new Album("Blinding Lights", 15000, "The Weeknd");
        Movie movie = new Movie("굿 윌 헌팅", 18000, "구스 반 산트", "맷 데이먼");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("상품 가격의 합: " + sum);
    }
}
