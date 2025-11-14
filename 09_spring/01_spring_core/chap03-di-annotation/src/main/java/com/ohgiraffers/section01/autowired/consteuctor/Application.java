package com.ohgiraffers.section01.autowired.consteuctor;

import com.ohgiraffers.section01.autowired.field.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        com.ohgiraffers.section01.autowired.field.BookService bookService = context.getBean(BookService.class);

        bookService.selecAllBooks().forEach(System.out::println);

        System.out.println(bookService.searchBookSequence(1));
        System.out.println(bookService.searchBookSequence(2));
    }
}
