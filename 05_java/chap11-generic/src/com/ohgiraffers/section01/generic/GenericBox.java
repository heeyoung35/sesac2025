package com.ohgiraffers.section01.generic;
// Generics은 T, E, K, V를 활용한다. 다이아몬드 연산자와 함께 사용한다.
// 클래스 내부에서 타입인것 처럼 사용할 수 있다. 사용할 때 타입을 정해줄 수 있다.
public class GenericBox<T> {

    private  T content;

    public void setContent(T content) {
        this.content = content;

    }

    public T getContent() {
        return this.content;
    }
}
