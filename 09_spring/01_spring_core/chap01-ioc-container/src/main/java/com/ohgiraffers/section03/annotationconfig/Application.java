package com.ohgiraffers.section03.annotationconfig;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // .getBeanDefinitionNames() 빈들의 이름을 배열로 받아오는 메소드
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName :" + beanName);
           /* 출력값
            beanName :contextConfiguration
            beanName :memberDAO
            */

            // 메소드에 어노테이션을 달았을 때 메소드이름으로 빈이름으로 사용합니다.
            // 클래스 명의 소문자를 등록해서 빈의 이름을 사용해서 빈을 꺼내오고 있다.
            // 클래스명의 첫 글자를 소문자로 바꾼 이름이 기본 id가 된다.
            MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
            System.out.println(memberDAO);

            System.out.println(memberDAO.selectMember(1));
            System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "신사임당")));
            System.out.println(memberDAO.selectMember(3));
        }
    }
}
