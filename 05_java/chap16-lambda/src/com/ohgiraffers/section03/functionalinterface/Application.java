package com.ohgiraffers.section03.functionalinterface;

import java.time.LocalDateTime;
import java.util.function.*;

public class Application {
    public static void main(String[] args) {

        /* 표준 함수형 인터페이스 */
        // 1. Consumer<T> : T타입의 인자를 받아 소비만 한다. (반환값 없음)
        // 데이터를 받기만 하고 돌려주는 것이 없다. 그래서 System.out.println이 대표적이다.
        Consumer<String> printer = message -> System.out.println(message);
        // accept() : Consumer가 값을 소비하기 위해 사용하는 메소드
        printer.accept("hello, Consumer!");

        // 2. Supplier<T> : 아무것도 받지 않고, T 타입의 객체를 '공급'한다.
        // 아무것도 입력받지 않고 무엇인가를 생산해서 돌려준다.
        Supplier<LocalDateTime> timeSupplier = () -> LocalDateTime.now();
        // get() : Supplier로부터 값을 공급받기 위해 사용하는 메소드
        System.out.println("현재 시간 : " + timeSupplier.get());

        // 3. Function<T, R> : T 타입의 인자를 받아, R 타입의 객체로 '변환'하여 반환한다.
        // 레퍼클래스를 통해 int -> Integer로 Auto-Boxing 된다.
        Function<String, Integer> lengthFunction = str -> str.length();
        // apply() : Function의 변환 기능을 입력값에 적용하기 위해 사용하는 메소드
        System.out.println(lengthFunction.apply("hello, Function"));

        // 4. Operator<T> : 동일한 T 타입의 인자들을 받아 '연산'하고, 같은 T 타입으로 반환한다.
        // 인자가 두개일 때 BinaryOperator 사용 연산에 강하다.
        BinaryOperator<Integer> sumOperator = (num1, num2) -> num1 + num2;
        // Function을 상속받았기 때문에 똑같이 apply()사용
        System.out.println(sumOperator.apply(100,200));

        // 5. Predicate<T> : T 타입의 인자를 받아 '검사'하고, boolean으로 '판단' 하여 반환한다.
        // 문자열을 받아서 문자열이고 빈값이 아니면 true
        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();
        // test() : Predicate의 판단 기능을 실행하기 위해 사용
        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));

    }
}
