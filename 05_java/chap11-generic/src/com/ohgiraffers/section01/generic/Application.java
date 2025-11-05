package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {
        NormalBox normalBox = new NormalBox();
        //object타입은 모두 담을 수 있다. 그렇기 때문에 모든 자료형이 담기기 때문에 의도와 다를 수 있다.
        // 실행을 통해서만 의도와 다름을 알 수 있다. 그런데 더 큰 문제는 오브젝트 타입에서 꺼낼 때이다.
        // 실수로 잘못된 값을 넣어도 컴파일 에러가 나지 않는다.
        normalBox.setContent("안녕하세요");
//      normalBox.setContent(123);

        // 값을 꺼낼때는 원래 타입은 String 으로 강제형변환을 해주어야 한다.
        // 실행해서 발생되는 런타임 에러는 치명적이고 매번 강제형변환을 해주어야 하는 것은 불편하다.
        // 그래서 generic을 사용한다.
       String content = (String) normalBox.getContent();

       // 이 박스는 오직 String 타입만 담겠습니다! GenericBox의 타입은 모두 String으로 지정된다.
       GenericBox<String> stringBox = new GenericBox<>();

       stringBox.setContent("Hello World");
//     stringBox.setContent(123);  // 컴파일에러 발생 오브젝트 타입에서는 컴파일 에러가 발생하지 않는 위험을 원천적으로 차단

        String strContent = stringBox.getContent();
        System.out.println(strContent);

        // 제네릭에 들어가는 타입은 반드시 "객체 타입"이어야 한다.
        // 기본자료형은 제레릭에세 업케스팅을 할 수 없기 때문에 객체형태로 만들어서 사용해야 한다.
        // 기본형을 쓰고 싶다면 래퍼 클래스를 사용하자!!!
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setContent(100);
        int intContent = integerBox.getContent();
        System.out.println(intContent + 1);
    }
}
