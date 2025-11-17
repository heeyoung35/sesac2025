package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/* aspectj의 autoProxy 사용에 관한 설정을 해주어야 advice가 동작힌다. */
@EnableAspectJAutoProxy(proxyTargetClass = true)
/* AOP를 활성화하는 가장 중요한 어노테이션으로 스프링이 @Aspect를 찾아서 프록시 객체를 만들고
*  공통 기능을 적용해 준다. proxyTargetClass = true는 인터페이스가 아닌 클래스 기반으로
*  프록시를 만들도록 설정하는 옵셥*/
public class ContextConfiguration {

}
