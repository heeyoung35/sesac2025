package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* jdbc는 개발자가 모든 제어권을 갖는 전통방식으로 모든 객체의 생성과 연결을 개발자가 다 해야한다면
           스프링의 제어의 역전은 제어권이 개발자가 아니라 스프링 프레임워크가 가져가는 것을 의미한다.
           스프링에서는 개발자가 new를 사용하지 않고 선언만 하면 스프링이 bean을 보관소에서 꺼내서 의존성 주입을 해준다.*/
        /* 설정에 대한 메타정보를 만드는 것은 3가지 방법이 있는데
         * xml설정방식, java 설정방식, annotation 설정방식이 있다.
         * [xml 설정방식]
         * 장점 :xml 설정 방식은 자바코드를 수정하지 않고, xml 파일만 수정하여 애플리케애션의 의존 관계를 변경
         * 단점: 빈이 많아지면 xml 팔이이 길고 복잡해니다.
         *      설정 정보가 문자열 기분이라 오타의 경우 컴파일 시점이 아닌 런타임 시점에 오류 발생
         * */

        // 1. xml 설계도를 읽어서 Ioc컨테이너(스프링 컨테이너)를 생성한다.

        // 리소시스 하위의 경로 작성
        ApplicationContext context =
                // xml 설정 파일을 읽어서 스프링 Ioc컨테이너를 생성하고 초기화하는 핵심 클래스
                // xml 파일에 정의한 빈들을 실제로 메모리에 생성하고 관라하는 공장을 만드는 실행자 역할
                // xml 설정 파일의 빈 생성 및 의존성 주입
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 2. 컨테이너에게 member라는 이름으로 등록한 빈을 달라고 요청
        // bean의 id를 이용해서 가져오는 방법
        // MemberDTO member = (MemberDTO) context.getBean("member");

        // bean의 클래스 메타 정보를 전달하여 가져오는 방법
        // 반환하는 값이 MemberDTO.class이기 때문에 형변환이 필요하지 않다.
        // MemberDTO member = context.getBean(MemberDTO.class);

        // 두가지 다 전달하여 가져오는 방법
        // 내가 원하는 방법으로 설계한 설계도에서 가져오는 방법으로 데이터 타입까지 맞추서 가져오게 된다.
        // 내가 new로 객체를 생성하지 않았지만 프레임워크가 생성해준다.
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);

    }
}
