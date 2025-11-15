package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {

        BookDTO book = new BookDTO();

        BookDTO book2 = new BookDTO("자바의 정석", "남궁성", "도우출판");
        BookDTO book3 = new BookDTO("홍길동전", "허균","활빈당", 50000, 0.5 );

        book.printInfo();
        book2.printInfo();
        book3.printInfo();

    }
}
