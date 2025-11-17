package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                // aop 하위 패키지 전체를 스탠하여 어노테이션이 붙은 클래스를 모두 빈으로 등록하고
                // 스프링 컨테이너를 시작
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        // 컨테이너에서 memberService빈을 가지고 올 때 원본 객체가 아닌 공통 기능이 합쳐진 프록시 객체를 반환
        MemberService memberService = context.getBean("memberService", MemberService.class);

        System.out.println("=============== selectMembers =============");
        System.out.println(memberService.selectMembers());
        System.out.println("================ selectMember =============");
        System.out.println(memberService.selectMember(3L));


        /* 스프링 프레임워크의 3대 핵심 요소
        * 1. IOC : 제어의 역정
        * - 객체를 만들고 관리하는 것이 개발자가 아닌 프레임워크로 넘어가는 것으로
        * - 개발자는 new를 쓰는 대신, 스프링 컨테이너에게 만들어둔 객체를 달라고 요청(get Bean)
        * 2. DI : 의존성 주입
        * - 객체를 만들지 직접 만들지 않고 선언만으로 컨테이너가 보관하고 있던
        * - 객체를 선언한 곳으로 주입 (생성자 주입방식 권장)
        * 3. AOP : 관점 지향 프로그래밍
        * - 핵심 비즈니스 로직과 공통 기능을 분리해서 관리
        * - 핵심 로직은 그대로 두고, 어떤 메소드가 실행되기 전/후/예외 시에 공통 기능을 끼워 넣으라고 설정*/
    }
}
