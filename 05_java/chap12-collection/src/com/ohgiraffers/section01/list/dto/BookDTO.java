package com.ohgiraffers.section01.list.dto;

public class BookDTO implements Comparable<BookDTO>{

    private int number;
    private String title;
    private String autor;
    private int price;

    public BookDTO() {}

    public BookDTO(int number, String title, String autor, int price) {
        this.number = number;
        this.title = title;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", price=" + price +
                '}';
    }
    /*
    * comparable 인터페이스로부터 오버러이딩해야하는 메소드이다.
    * 이 메소드는 현제 객체(this)와 매개변수로 전달ㄴ된 객체(0)의 순서를 비교하여
    * 어떤 객체가 더 앞에 와야 하는지를 결정하는 규칙을 정의한다.
    * */
   @Override
    public int compareTo(BookDTO o) {
       /* 정렬 기준: 책 번호(number)를 기준으로 오름차순으로 정하겠다.
       * - 현재 객체(this)의 number가 o의 number보다 작으면 -> 음수 반환 (자리 유지)
       * - 현재 객체(this)의 number가 o의 number보다 크면 -> 양수 반환 (자리 바꿈)
       * - 두 객체의 number가 같으면 -> 0 반환 (자리 유지)
       * */
       // this.number와 o.getNumber()를 비교해서 뒤의 수가 크면 음수 반환 앞의 수가 크면 양수 반환
        return Integer.compare(this.number, o.getNumber());
//      return this.number - o.getNumber(); // int범위를 넘으면 오버플로우 위험!!!
    }
}
