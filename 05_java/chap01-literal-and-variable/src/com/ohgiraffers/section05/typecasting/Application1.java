package com.ohgiraffers.section05.typecasting;

public class Application1 {
    public static void main(String[] args) {

        /* 자동 형변환 규칙
        *
        * 데이터 형변환이 필요한 이유
        *  - 자바에서 다른 타입끼리의 연산은 피연산자들이 모두 같은 타임인 경우 실행할 수 있다.
        *  - 즉, 같은 데이터 타입끼리만 연산을 수행할 수 있다.
        * */

        /* 1. 작은 자료형에서 큰 자료형으로는 자동 형변환 된다. */

        byte bnum = 1;
        short snum = bnum;
        int inum = snum;
        long lnum = inum;

        /* 연산 시에도 자동으로 큰 쪽 자료형에 맞춰 계산한다. */
        int num1 = 10;
        long num2 = 10;

//      int result1 = num1 + num2;  // 켬파일 에러 발생 변수를 선언하면서 정수를 담는다고 선언했기 때문에 long형은 작은 int에 담을 수 없다
//      long으로 변경 후 계산하기 때문에 int형 변수에 값을 담을 수 없다.
        long result = num1 + num2;
        System.out.println("result : " + result);

        /*
        * 정수는 실수로 자동 형변환 된다.
        * */

        long eight = 8;
        float four = eight;  // 정수는 실수형에 담아도 컴파일 에러가 발생하지 않는다.

        System.out.println("four : " + four);

        float result2 = eight + four;
        System.out.println("result2 : " + result2);

        /* 논리형은 형변환 규칙에서 제외된다.
        *  어느 자료형이든 boolean을 형변환 해서 담을 수 없다. */
        boolean isTrue = true;
//      byte b = isTrue;
//      short s = isTrue; ...등




    }
}
