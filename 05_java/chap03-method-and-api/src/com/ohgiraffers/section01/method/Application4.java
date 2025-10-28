package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {
        /* 다른 클래스에 작성한 메소드 호출 */

        int first = 100;
        int second = 50;

        /* non static 메소드의 경우
        *  클래스가다르더라도 사용한느 방법은 동일하다
        *  클래스명 사용할이름 = new 클래스명()
        *  사용할이름.메소드명();
        * */

        Calculator cslc = new Calculator(); // 객체생성
        int min = cslc.minNumberOf(first, second); // int에 받아서 위에 정의한 수를 담아주고 있다.

        System.out.println("최소값은: " + min);

        /* static 메소드인 경우
        *  다른 클래스에 작성한 static 메소드의 경우 호출할 때 클래스명을 반드시 기술
        *  글래스명.메소드명()
        * */
//        int max= maxNumberOf(first, second);
          int max = Calculator.maxNumberOf(first, second);
        System.out.println("최대값은: " + max);

//        int max2 = cslc.maxNumberOf(first, second);  객체로 접근할 수 있지만 권장하지 않음
        // static은 모든 객체들이 공유해서 사용하기 때문에 객체가 만들어지는 공간과 static에서 사용하는 공간은 다르다.
        // new키워드로 만들어진 객체의 주소값을 가지고 있는 것이고 static은 클래스에 속한 메서드이기 때문이다.
        // 클래스 명으로 반드시 호출해 주어야 한다.



    }
}


