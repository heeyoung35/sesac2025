package com.ohgiraffers.section01.exception;

public class Application1 {
    public static void main(String[] args) throws Exception {


    /* 오류는 시스템 상에서 문제가 발생해서 개발자가 미리 예측하거나 코드로 처리불가한 상황
    *  예외는 개발자가 미리 예측하고 처리할 수 있는 미약한 오류로 비정상적인 종료를 개발자가 처리
    * */

        ExceptionTest et = new ExceptionTest();

        System.out.println("정상 케이스");
        // 예외를 처리해야되 나도 나를 처리한 곳으로 예외를 던지는 것이다. 결국 JVM에게 처리를 떠넘기게 됩니다.
        // JVM도 처리할 것이 없음으로 프로그램을 종료시켜 버립니다. 프로그램의 안정성을 해치게 된다.
        et.checkEnoughMoney(10000, 30000);

        System.out.println("예외 발생 케이스");
        et.checkEnoughMoney(10000, 3000); // Exception발생으로 즉시 비정상적으로 프로그램 종료

        System.out.println("프로그램을 종료합니다.");
    }
}
