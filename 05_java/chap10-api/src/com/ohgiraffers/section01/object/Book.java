package com.ohgiraffers.section01.object;

import java.util.Objects;

public class Book {

    private int number;
    private String title;
    private String author;
    private int price;

    public Book() {}

    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {  // object에 있는 재정의해서 정보를 얻을 수 있다.
        return "Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // 오버라이딩 해서 재정의 한 객체는 객체의 값을 받아서 클래스 값과 비교
        // 매개변수에 object가 들어있다는 것은 다형성이 적용되어 있다. book은 object의 자손이기 때문에 다운캐스팅을 한 것이다.
        // 상속의 개념도 포함되어 있다.
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o; // 받은 book을 바꿔서
        return number == book.number && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        // 필드값을 모두 비교해서 &&로 비교해서 다 같다면 true로 출력하게끔 변경
    }

    @Override
    public int hashCode() {  // 해쉬코드도 동일하게 하기 위함.
        return Objects.hash(number, title, author, price);
    }
}
