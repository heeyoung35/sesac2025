package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 이 클래스가 공통 기능을 정의한 Aspect 클래스임을 나타낸다.
@Aspect // 공통기능을 정의한 클래스임을 나타냄
@Component // Aspect 클래스도 스프링 빈으로 등록되어야 하기 때문에 컴포넌트 스캔대상
public class LoggingAspect {

    // 핵심!!: '어디에' 공통기능을 적용할지 범위를 지정
    // 표현식 전달 aop패키지 아래에 있는 *Service로 끝나는 모든 클래스에 적용하는데 (..) 파라미터가 0개 이상인 모든 메서드에 적용한다.
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    // 어느시점에 무엇을 할지 기능을 정의
    // logPointcut에 정의된 메소드가 실행되기 전에 logBefore 메소드 실행
    @Before("logPointcut()") // Pointcut으로 지정되니 메소드가 실행되기 '전'에 동작할 공통기능
    public void logBefore(JoinPoint joinPoint) { // JoinPoint : 현재 실행되는 메소드의 정보를 담고있는 객체
        System.out.println("Before joinPoint.getSignature() :" + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0]" + joinPoint.getArgs());
        }
    }

    // 메소드의 성공과 실패에 상관없이 종료된 후에 logAfter실행
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget() :" + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() :" + joinPoint.getSignature());
    }
    // returning속성은 리턴값으로 반환된는 애를 객체로 받는 것이다.
    // 리턴 값으로 받아올 객체의 매개변수 이름과 동일해야 한다.
    // 메소드가 정상적으로 성공 했을 때 실행됨 설정을 통해 대상 메소드의 반환값(result)을 받을 수 있습니다.
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result : " + result);
    }

    // 메소드 실행 중 예외가 발생했을 때 실행 설정을 통해 발생한 예외 객체(exception)를 받을 수 있다
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
        public void logAfterThrowing(Throwable exception) {
        System.out.println("AfterThrowing 동작!!");
        System.out.println(exception);
    }



}
