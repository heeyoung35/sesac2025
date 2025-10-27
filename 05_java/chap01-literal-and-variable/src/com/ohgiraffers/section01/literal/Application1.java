package com.ohgiraffers.section01.literal;

public class Application1 {

    public static void main(String[] args) {

        // 숫자 형태의 값
        /* 정수 형태의 값 출력 */
        System.out.println(123);
        /* 실수 형태의 값 출력 */
        System.out.println(1.123);

        /* 문자 형태의 값 출력 */
        System.out.println('a');     // 문자 형태의 값은 홑따옴표로 감싸주어야 한다.
//      System.out.println('ab');    // 두 개이상의 문자가 붙으면 문자열로 취급하기 때문에 컴파일 에러가 발생한다.
//      System.out.println('');      // 아무 문자도 기록되니 않는 빈 문자도 에러 발생

        /* 문자열 형태의 값 출력 */
        System.out.println("안녕하세요");  // 문자열은 문자 여러 개가 나열된 형태를 말하며 쌍따옴표로 감싸주어야 한다.
        System.out.println("");         // 아무 값도 없는 빈 쌍따옴표도 문자열로 취급해준다.
        System.out.println("a");        // 한 개의 문자도 쌍따옴표로 감싸면 문자열이다. (문자 a와는 다르다.)

        /* 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println(false);

    }
}
