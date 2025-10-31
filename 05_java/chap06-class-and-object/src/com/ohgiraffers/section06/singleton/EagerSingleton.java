package com.ohgiraffers.section06.singleton;

public class EagerSingleton {

    /* 킄래스가 초기화 되는 시점에 인스턴스를 생성한다. */
    // 자료형의 변수를 만든것이고 static 변수를 초기화 한 것이다.
    // jvm이 로드 될 때 딱 한번 실행
    private static EagerSingleton eager = new EagerSingleton();

    /* 싱글톤 패턴은 생성자 호출을 통해 외부에서 인스턴스 생성하는 것을 제한 */
    private EagerSingleton() {}

    /* public 인터페이스로 인스턴스를 반환하도록 한다. */
    public static EagerSingleton getInstance() { // 다른곳에서도 접근할 수 있도록 반환하는 자료형을 반환한다.
        return eager;
    }

}
