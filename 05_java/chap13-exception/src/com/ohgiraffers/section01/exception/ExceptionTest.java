package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception {
        System.out.println("가지고 계신 돈은" + money + "원 입니다.");

        if(money >= price) {
            System.out.println("상품을 구입하기 위한 돈이 충분합니다.");
        } else {
            // Exception도 클래스로 계층구조를 가지고 있다.
            // 오버라이드를 통해 throws Exception을 추가해서 예외를 호출한 곳으로 던진다.
            throw new Exception("돈이 부족합니다.!!");
            // 예외 종류가 많다. 기본적으로 처리 되어 있는 예외의 종류
            // 반드시 예외 처리를 해야하는 종류가 있다.
        }

        System.out.println("즐거운 쇼핑 하세요~");
    }

}
