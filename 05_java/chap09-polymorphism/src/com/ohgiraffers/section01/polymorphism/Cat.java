package com.ohgiraffers.section01.polymorphism;

// 고양이는 동물이다가 성립되어야 상속이 가능하다.

public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("고양이가 생선을 먹습니다.");
    }

    @Override
    public void run() {
        System.out.println("고양이가 달려갑니다. ~ 슝~");
    }

    @Override
    public void cry() {
        System.out.println("고양이가 울음소리를 냅니다. 야옹~");
    }

    public void jump() {
        System.out.println("고양이가 점프합니다. 점프~~");
    }
}
