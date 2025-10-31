package com.ohgiraffers.section08.initblock;

public class Application {
    public static void main(String[] args) {

        /* 초기화 블럭
        *  복잡한 초기화를 수행할 수 있는 블럭, 인스턴스 초기화 블럭과 정적 초기화 블럭으로 구분된다.
        * 1. 인스턴스 초기화 블럭({초기화 내용 작성})
        * - 인스턴스가 생섣되는 시점에 생성자 호출 이전에 먼저 샐행 된다.
        * - 인스턴스를 호출하는 시점마다 호출이 된다.
        * - 인스턴스변수를 초기화하며 정적필드에는 실행시점마다 값을 덮어쓴다
        *
        * 2. 정적 초기화 블럭( static {초기화 내용 작성} )
        * - 클래스가 로드될 때 한 번 동작한다.
        * - 정적 필드를 초기화하며, 인스턴스변수는 초기화하지 못한다.
        *
        * 최종 순서 :
        * 인스턴스 변수: 기본값 -> 명시적 초기값 ->  인스턴스 초기화 블럭-> 생성자 순서로 적용 그리고 뒤에 동작한 것이 덮어 씌어진다.
        * 클래스(static) 변수 : 기본값 -> 명시적 초기값 -> 정적 초기화 블럭 -> 인스턴스 초기화 블럭 -> 생성자
        * */

        // 정적 초기화 이후에 기본생성자 동작
        Product product = new Product();

        Product product2 = new Product("대륙폰", 500000,"샤우미");

        // 앞에 모든 것을 무시하고 덮어 씌운다.
        System.out.println(product.getInformation());
        System.out.println(product2.getInformation());
        /* 출력값
        매개변수 있는 생성자 호출됨...
        Product [아이폰15000000샤우미]
        Product [대륙폰500000샤우미]
        */
    }
}
