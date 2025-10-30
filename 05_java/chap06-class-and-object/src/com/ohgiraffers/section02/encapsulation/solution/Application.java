package com.ohgiraffers.section02.encapsulation.solution;

public class Application {
    public static void main(String[] args) {

        Children child1 = new Children();
        child1.setAge(-10);  // setter 메소드로 나이 설정

        System.out.println("어린이 정보 : " + child1.getAge() + "세");

//      child1.age = -30;  // age라는 필드에 참조연산자로 직접 접근할 수 있다. 직접 접근을 차단 private 필드로 변경해서 접근제한
        System.out.println("어린이 정보 : " + child1.getAge() + "세");

    }
}
