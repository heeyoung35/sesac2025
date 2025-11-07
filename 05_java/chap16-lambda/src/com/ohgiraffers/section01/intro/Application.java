package com.ohgiraffers.section01.intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        /* 람다 표현식을 이용하면 많은 과정이 필요없이 코드 조각으로 자유롭게 주고 받을 수 있다.
        **/
        /* 전통적인 방식*/
        Calculator c1 = new CalculatorImpl();

        System.out.println(c1.sumTwoNumber(10, 20));

        /* 익명 클래스를 사용하는 방식 */
        Calculator c2 = new Calculator() {  // 이름이 없는 익명클래스를 사용
            @Override
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };
        System.out.println(c2.sumTwoNumber(10,20));

        /* [람다식을 활용한 방식] */
        // c3는 자바가 Calculator라는 형식을 알고 있다. 메소드가 하나만 있다는 것도 알고 있다.
        // 메소드 이름 반환타입을 다 생략할 수 있다. 괄호 안에 하나밖에 없는 메소드의 매개변수 목록이고
        // 매개변수가 int인 것을 추론할 수 있다. 화살표는 람다함수이다.
        // 중괄호와 return이 한줄로 다 생략된 것이다.
        // 람다식 조건은 하나의 메소드만 정의 되어야 한다.

        /* 자바가 Calculator 인터페이스에 메소드가 하나만 있는 것을 알고 있다.
        * 따라서 메소드 이름을 생략하고, 파라미터와 구현부만 간결하게 작성할 수 있다.
        * (x, y) -> x + y; 이 코드 조각이 곧 Calculator 인터페이스의 구현체가 된다. */
        Calculator c3 = (x, y) -> x + y;  // 인터페이스와 메소드가 하나만 정의되어 있으면 람다식 가능

        /* int와 int를 받아 int를 반환한느 것과 같은 흔한 작업은 자바 개발자들이 이미
        * java.util.function 패키지에 인터페이스를 만들어 두었다. */
        // BiFunction<T, U, R> : T와 U 타입의 두 개 인자를 받아 R 타입으로 반환한느 함수형 인터페이스
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y; //Calculator를 대체
        // 메소드 이름도 sumTwoNumber 가 아닌 apply로 표준화 되어 있다.
        System.out.println(sum.apply(100,200));

        /* 람다식은 컬렉션에서 가장 빛이난다.*/
        // List에서 Arrays.asList 배열을 통해서 리스트로 만드는데 뷰로만 보기 위한 것이다.
        // 추가 삭제는 불가능하지만 수정 가능하다.
        // for Each는 행동을 전달해주면 행동에 대한 설계가 Consumer 라는 함수가 있다.
        List<String> names = Arrays.asList("홍길동","유관순","이순신");
        for(String name : names) {
            System.out.println(name);
        }

        // Consumer<T> :T 타입의 인자를 하나 받고 아무것도 반환하지 않는 (소비하는) 함수령 인터페이스
        // 중괄호 블럭 없이 의도가 표현되어 코드가 간결하고 가독성이 높아진다. 이름 없는 함수 표현방식
        // 컨슈머가 행동의 설계도이고 람다는 그 '설계도를 따르는 실제 행동' 이라고 생각하면 된다.

        // 행동: name이라는 문자열을 받아서 람다식으로 , 환영합니다. name님 ! 출력
        Consumer<String> printName = name -> System.out.println("환영합니다," + name + "님!"); // 이름을 받아서 이름을 출력
        // names 리스트의 forEach 메소드에 그 기능(위에서 만든  printName)을 전달하여 실행
        names.forEach(printName);

        names.forEach(name -> System.out.println("반갑습니다." + name + "님!"));
    }
}
