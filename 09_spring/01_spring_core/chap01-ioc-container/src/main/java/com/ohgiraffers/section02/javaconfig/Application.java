package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class Application {
    public static void main(String[] args) {
        /* [java 설정 방식]
         * @Configuration, @Bean, @ComponentScan, @Autowired 등의 어노테이션(Annotation)을 사용
         * 장점 :타입안정성으로 오타나 잘못된 타입을 컴파일 시점에 잡을 수 있다
         *      가독성 및 유지보수가 용이하여 코드를 파악하기 쉽고 코드 수정이 편리
         *      자바의 프로그래밍 로직을 설정에 사용가능
         * */
        /* 생성자에 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달 */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 빈을 가져오는 방식
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);

    }
}
