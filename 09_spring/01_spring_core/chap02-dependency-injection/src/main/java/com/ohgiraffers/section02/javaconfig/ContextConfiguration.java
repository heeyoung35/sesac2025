package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {


    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20, "110-234-56789");
    }

    @Bean
    public MemberDTO memberGenerator() {
        /*생성자 주입*/
     //   return new MemberDTO(1, "코알라", accountGenerator());

        /* setter 주입*/
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("기린");
        member.setPersonalAccount(accountGenerator());

        return member;

        /* [생성자 주입 방식과 setter 주입 방식의 차이]
        *  - 생성자 주입방식
        *   클래스에 생성자를 하나만 만들거나, @Autowired를 생성자에 붙인다.
        *   의존성을 final 키워드로 선언할 수 있기 때문에 객체가 생성된 이후에 의존성이 변경될 위험이 원천차단
        *   객체가 생성되는 시점에 반드시 의존성이 주입되어야 객체가 생성되기 때문에 NullPointerException 예방
        *   빈간에 순환 참조가 발생하면 스프링이 시작 시점에 오류를 발생시켜 잘못된 설계를 미리 알 수 있다.
        *  - setter 주입방식
        *    메소드 위에 @Autowired를 붙인다.
        *    주입받을 의존성이 선택적 일 때 사용할 수 있다. 주입이 되지 않아도 객체는 생성이 된다.
        *    final 키워드 사용불가
        *    순환 참조가 발생해도 애클리케이션이 실행되기 때문에 실제 호출 시점에서 오류 발생
        * */
    }
}
