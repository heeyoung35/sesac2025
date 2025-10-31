package com.ohgiraffers.section06.finalkeyword;

import com.ohgiraffers.section02.encapsulation.solution.Children;

public class Application {
    public static void main(String[] args) {
        // 상수를 선언할 때 final을 붙여서 사용했었다. 메소드, 클래스에도 붙일 수 있다.

        /*
        * final 키워드
        * 1. 변수(지역/필드)에 사용: 값 변경 불가 -> 상수가 된다.
        * 2. 메소드에 사용: 재정의 (Override)불가
        * 3. 클래스에 사용 : 상속 불가
        * */

        System.out.println("원주율 :" + MathConstant.PI);
        //    MathConstant.PI = 3.14;  // final변수는 다시 값을 할당 할 수 없다.

        Person person = new Person("000000-1111111", "홍길동");
        person.setName("홍길동 주니어");
//      person.ssn = "0101022-232454"; // final 변수는 private이 아니어도 외부에서 변경이 불가능하다

        // 부모의 'final' 메소드를 사용하는 것은 가능하다. 하지만 오버라이딩은 불가능하다.
        Child child = new Child();
        child.coreMethod();
    }
}
