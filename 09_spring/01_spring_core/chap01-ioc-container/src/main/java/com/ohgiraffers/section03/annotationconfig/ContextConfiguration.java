package com.ohgiraffers.section03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
// 경로를 작성하면 오지라퍼스 하위를 모두 포함 하위에 있는 컴포넌트를 찾아서 빈으로 등록해달라는 요청
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

    /* ComponentScan?
    *  basePackages로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록
    *  @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록
    *  목적에 따라 @Controller, @Service, @Repository, @Configuration 등을 사용 */


}
