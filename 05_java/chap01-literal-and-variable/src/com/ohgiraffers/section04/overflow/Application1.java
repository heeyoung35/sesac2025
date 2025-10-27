package com.ohgiraffers.section04.overflow;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 자료형 별 값의 최대 범위를 벗어나는 경우
        * 발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환시킴
        * */

        byte num1 = 127; // byte의 최대 저장 범위

        num1++;         // 1 증가

        System.out.println("num1 overflow  : " + num1); // -128이 출력: byte의 최소 저장 범위 128로 갈 수 없기 때문에 가장 작은 수로 순환시킴

        byte num2 = -128;

        num2--;        // 1 감소

        System.out.println("num2   : " + num2);   // 127로 출력 되는데 -128이 최소 저장범위이기 때문에 반전 시킨다.

        int firstNum = 1000000; // 100만
        int secondNum = 700000; // 70만

        int multi = firstNum * secondNum;
        System.out.println("mult : " + multi);   // -79669248출력값

        // 이미 오버플로우 처리 된 결과를 가지고 변수에 담기 때문에 차이가 없다.
        long longNum = firstNum * secondNum;
        System.out.println("longNum : " + longNum);  // -79669248출력값 // 값이 나오기 전에 강제로 자료형을 바꿔줘야 한다.

        /* 계산이 처리되기 전에 long 타입으로 자료형을 변경해주어야 한다. (강제형변환) */
        long result = (long)  firstNum * secondNum;
        System.out.println("result : " + result);


    }
}
