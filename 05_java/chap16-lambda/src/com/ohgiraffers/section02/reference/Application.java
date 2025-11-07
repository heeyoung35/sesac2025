package com.ohgiraffers.section02.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {

        // 정적(static) 메소드 참조
        // 문자열 -> 함수 Function 인터페이스를 이용해서 타입을 변환
        // 람다식은 전달하는 역할 다른 메소드를 호출하는 역할을 할 때 메소드 참조를 할때
        // [람다식]
        Function<String, Integer> parseInt = str -> Integer.parseInt(str);

        // [메소드 참조]
        // 클래스이름 : 정적메소드이름
        // str -> Integer.parseInt(str); =  Integer::parseInt;
        Function<String, Integer> reference_parsInt = Integer::parseInt;
        System.out.println("결과 : " + reference_parsInt.apply("123") * 2); // 장수 변환으로 연산확인

        // [람다식]
        // System.out.println 시스템 클래스에 있는 out이라는 스태틱메소드에 .println함수
        Consumer<String> println = str -> System.out.println(str); // 반환없이 소비

        // [메소드 참조]
        // 객체참조변수::인스턴스메소드이름
        Consumer<String> reference_println = System.out::println;
        reference_println.accept("hello Method Reference!");

        // forEach와 함께 사용
        List<String> subjects = Arrays.asList("java", "mysql", "jdbc","css");
//      subjects.forEach(subjects -> System.out.println(subjects));
        subjects.forEach(System.out::println); // 메소드 참조!!

        // 불특정 다수 객체의 인스턴스 메소드 참조
        // [람다식]
        BiFunction<String, String, Boolean> equals = (s1, s2) -> s1.equals(s2);

        // [메소드 참조]
        // 클래스이름::인스턴스메소드이름
        BiFunction<String, String, Boolean> reference_equals = String::equals; // String클래스에 있는 equals를 쓰겠다.

        // [생성자 참조]
        // 생성자 참조는 클래스이름::new 형식으로 사용된다.
        // 어떤 생성자를 참조할지는 우리가 사용하는 함수형 인터페이스의 시그니처에 따라 컴파일러가 추론한다.
//      Supplier<Account> newAccount = () -> new Account(); 람다식 형태

        Supplier<Account> newAccount = Account::new; // 파라미터가 없는 생성자는 기본생성자를 호출합니다.
        System.out.println("기본 생성자로 생성된 계좌 : " + newAccount.get()); // 기본 생성자 이기 때문에 필드가 null

        // 매개변수 인자가 하나인 것
        Function<String, Account> newAccountWithName = Account::new;
        System.out.println("이름과 함께 생성된 계좌 : " + newAccountWithName.apply("홍길동"));

        // 매개변수 인자가 두개인 것
        BiFunction<String, Integer, Account> newAccountFull = Account::new;
        System.out.println("모든 정보와 함께 생성된 계좌 : " + newAccountFull.apply("유관순", 100000));



    }
}
