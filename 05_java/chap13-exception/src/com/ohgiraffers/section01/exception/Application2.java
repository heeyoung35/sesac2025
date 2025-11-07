package com.ohgiraffers.section01.exception;

public class Application2 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        System.out.println("정상케이스");
        try {
            // 상풍 구매 시도
            et.checkEnoughMoney(10000, 300000);
            // try 블록에서 예외가 발생하지 않으면, catch블럭은 실행되지 않고 건너 뛴다.
            System.out.println("상품 구입 가능!!");
        } catch (Exception e) { // 이런 Exception이 발생하면 아래와 같은 코드를 실행하겠습니다.
            System.out.println("상품 구입 불가");
        }
        System.out.println("예외 발생 케이스");

        try {
            // 던져진 예외(Exception)을 받아서, 여기서 책임지고 처리한다.
            // 예외를 처리하기 때문에 마지막까지 프로그램이 정상적으로 종료하게 된다.
            et.checkEnoughMoney(30000, 10000);

            System.out.println("상품 구입 가능!!");

        } catch (Exception e) {
            System.out.println("상풀 구입 불가!!");
            System.out.println(e.getMessage()); // 던졌던 에러 메시지 확인
            e.printStackTrace(); // 어디서 예외가 발생했는지 아래와 경로를 추적하여 아래와 같이 출력한다.
//          at com.ohgiraffers.section01.exception.ExceptionTest.checkEnoughMoney(ExceptionTest.java:12)
//          at com.ohgiraffers.section01.exception.Application2.main(Application2.java:22)
        }
        System.out.println("프로그램을 정상적으로 종료합니다.");
    }
}
