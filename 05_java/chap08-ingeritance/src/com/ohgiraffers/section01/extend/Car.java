package com.ohgiraffers.section01.extend;

public class Car {

    private boolean runningStatus;

    public Car() {
        System.out.println("Car 클래스의 기본 생성자 호출..");
    }

    public void run() {
        runningStatus = true;
        System.out.println("자동차가 달립니다.");
    }
}
