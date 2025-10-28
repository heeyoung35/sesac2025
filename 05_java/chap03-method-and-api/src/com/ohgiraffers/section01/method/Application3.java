package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /*
        * static 메소드 호출(모든 객체가 가질 수 있는 것)
        * 클래스명.메소드명(); // 객체를 만들지 않아도 사용가능, 동작흐름은 같다.
        * */
        System.out.println("10과 20의 합: " + Application3.sumTwoNumbers(10,20));

        // 동일한 클래스 내에 작성된 static 메소드는 클래스명 생략이 가능하다.
        System.out.println("20과 30의 합: " + sumTwoNumbers(20,30));
    }
    // 클래스에서 만들어진 것을 모두 공유하기 때문에 객체를 생성하지 않음
    public static int sumTwoNumbers(int first, int second) {
        return first + second;
    }
}
