package com.ohgiraffers.section02.package_and_import;
// import구문을 상단에 작성하면 알아서 import를 해온다.
// import com.ohgiraffers.section01.method.Calculator;
// alt + Enter키로 자동으로 추가할 수 있다.
import com.ohgiraffers.section01.method.Calculator;
// static 클래스의 메서드를 직접 import 할 수도 있다.
import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

// 같은 패키지 내에서는 동일한 클래스의 이름을 만들 수 없다.
// 클래스의 명은 패키지 명을 모두 포함한 풀클래스 명이다.
public class Application {
    public static void main(String[] args) {

        // non-static 메소드 호출
        // 서로 다른 패키지에 있는 풀클래스명을 적어주어야 한다.
        // 이렇게 풀클래스 명을 적어주면 코드가 지저분해지기 때문에 import 구문을 사용한다.
        com.ohgiraffers.section01.method.Calculator calc = new com.ohgiraffers.section01.method.Calculator();
        int min = calc.minNumberOf(30,20);
        System.out.println(min);

        // static 메소드 호출
        int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(30,20);
        System.out.println(max);

        // import 사용하여 다른 패키지의 클래스 사용하기
        // non-static
        Calculator calc2 = new Calculator();   // 패키지명 생략 가능
        int min2 = calc2.minNumberOf(30,20);
        System.out.println(min2);

        // static
        int max2 = Calculator.maxNumberOf(30,20); // static은 클래스 이름(Calculator)은 여전히 필요한다.
        System.out.println(max2);

        /* 메소드 이름만으로 호출 가능하지만 권장하지 않음
        *  이 기능이 어디에서 온건지 한눈에 파악하기 어려움 */
        // 어느 클래스에서 가지고 왔는지 한눈에 알아보기 어렵기 때문에 실무에서는 클래스 명과 함께 사용한다.
        int max3 = maxNumberOf(40,10); // static import 해서 클래스명 없이 메소드 이름만으로 사용이 가능하다.
        System.out.println(max3);
    }
}
