package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {

        // 클래서 인스턴스(객체) 생성하면 그 안에 있는 메서드들이 호출될 수 있다.
        Application2 app2 = new Application2();

        /*
        * 전달인자(argument)와 매개변수(parameter)
        * - 메소드를 호출할 때 넘겨주는 값을 '전달인자'라고 하며
        * - 메소드에서 이 값을 받기 위해 선언된 변수를 '매개변수'라고 한다.
        * */

        app2.printAge(30); //직접 값 전달

        int myAge = 25;
        app2.printAge(myAge);  // 변수에 담긴 값을 전달

        /* 여러 개의 전달인자를 이용해 메소드를 호출할 수 있다.
        * - 매개변수의 타입, 개수, 순서를 정확히 맞춰서 전달해야 한다. */
        // 메서드의 타입과 개수, 순서를 정확하게 입력하지 않으면 컴파일에러가 발생된다.
        app2.printUserInfo("홍길동", 20, '남');

        String name ="유관순";
        int age = 18;
        char gender = '여';
        app2.printUserInfo(name, age, gender);

        /* - void가 아닌 다른 타입이 명시된 메소드는 반드시 해당 타입의 값을 반환(return)해야 한다.
        * - 반환된 값은 변수에 저장하거나 다른 메소드의 전달인다로 즉시 사용할 수 있다.
        * */
        // 메서드를 호출하면 매개변수가 없이 리턴문만 있다. 그렇기 때문에 반환값이 있어야 한다.
        String message = app2.createGreetingMessage();
        System.out.println(message);

        String profile = app2.createProfileString("신사임당",40);
        System.out.println(profile);

    }
    // printAge메서드이고 이 메서드에 들어갈 재료인 매개변수에 타입을 지정해야한다.
    // 매개변수가 있는 메소드
    public void printAge(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

    // void 메서드의 경우 return이 명시적으로 작성되어 있이 않아도 컴파일러가 임의로 작성되어 있어서 호출한 곳으로 돌아가라고 되어 있다.
    // 호출한 곳으로 반환값을 가지고 갈 수 있기 때문에 이때 값을 return값이 된다.
    public  void printUserInfo(String name, int age, char gender) {
        System.out.println("이름: " + name + ", 나이: " + age +"세, 성별: " + gender);
        return; // vodi메소드의 경우 return을 명시적으로 작성하지 ㅇ낳아도 마지막 줄에 캄파일러가 자동으로 추가해줌
    }

    // void가 아닌 String으로 다른 타입의 메서드이기 때문에 String으로 된 return 문자열 반환값이 있어야 한다.
    public String createGreetingMessage() {
        return "Hello World!";
    }
    // 매개변수와 반환값이 모두 있는 메서드
    public String createProfileString(String name, int age) {
        String profile = name + "님의 나이는" + age +"세입니다.";
        return profile;
    }
}
