package com.ohgiraffers.section01.wrapper;

public class Application {
    public static void main(String[] args) {
        // 기본 자료형 8가지는 빠르고 가볍지만 객체는 아니다. 그래서 자바가 8가지 자료형을 객체처럼 사용하도록 만들었다.
        // 이것을 wrapper클래스라 한다.

        String heighStr = "175.5";
        String weightStr = "69.3";
        System.out.println("입력받은 키: " + heighStr);
        System.out.println("입력받은 몸무게: " + weightStr);

        System.out.println(heighStr + weightStr);  // 문자열 이어 붙이기가 된다. 숫자처럼 생긴 문자열로는 아무런 계산을 할 수 없다.

        // 파싱 : 문자열 데이터를 실제 해당 타입의 기본 자료형으로 변환하는 과정
        // Wrapper 클래스들은 'parse자료형()' 형태의 static 매소드를 제공한다.
        double height = Double.parseDouble(heighStr);  // 파씽하는 기능을 문자열 기능을 실제 기본 자료형으로 변환
        double weight = Double.parseDouble(weightStr);

        double bmi = weight / ((height / 100) * (height / 100));
        System.out.println("계산된 bmi 지수 : " + bmi);

        /* 기본 자료형이 아닌 '객체 ' 형태로 데이터를 다뤄야 할 때가 있다.
        *  이때 기본 자료형을 감싸서(Wrap) 객체로 만드는 것을 'Boxing(박싱)' 이라고 한다. */
        // int -> Integer
        // char -> Character 그외는 앞글자가 대문자이다.

        // Integer num = new Integer(10); // 예전 방식!! (지금은 사용 비권장)

        Integer age = 20;  // Auto-Boxing: 컴파일러가 Integer.valueOf(20)으로 자동 변환.

        int unboxedAge = age; // Auto-Unboxing : 컴파일러가 age.intValue()로 자동 변환.

        // Wrapper 클래스 객체의 값 비교는 반드시 .equals()를 사용해야 한다. (== 연산자는 주소 비교)
        // true(byte범위(-128 ~ 127) 캐싱으로 인해 예외적으로 true
        // false (범위를 벗어나면 다른 객체로 생성됨)
        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println(num1 == num2);  // true 출력 int 범위에 속하기 때문에 true가 출력된다.

        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4);  // false int의 범위는 -128 ~ 127까지이다. 속하지 않는 범위는 항상 false출력

        System.out.println(num3.equals(num4));

        // 숫자로 변환한 데이터를 문자열로 바꾸는 방법
        /* 숫자 데이터를 다시 문자열로!
        *  계산이 끝난 데이터를 화면에 표시하거나, 저장하려면 다시 문자열로 변환해야 한다.
        * 1. String.valueOf(값)
        * 2. 값 + "" (간편한 방법)
        * */

        String bmiStr1 = String.valueOf(bmi);
        String bmiStr2 = bmi + "";

        System.out.println("당신의 BMI는 " + bmiStr1 + "입니다.");

    }
}
