package com.ohgiraffers.section02.initdestroy.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// @Component
public class Owner {

    /* 스프링 컨테이너는 초기화 시점에 @PostConstruct 어노테이션을 사용하고 빈 소멸 시점에는
    * @PreDestroy가 붙은 메소드를 자동으로 찾아 실행 가독성이 좋기 때문에 권장  */
    /* 싱글톤: 스프링이 생성부터 소멸까지 모든 생명주기를 관리하기 때문에 컨테이너 종료시 destroyMethod / @PreDestroy 호출됨
    *  프로토타입: 스프링이 생성과 초기화까지만 관여하기 때문에 소멸은 관리하지 않기 때문에 destroyMethod / @PreDestroy 호출되지 않음
    * */

//    @PostConstruct  // initMethod와 같은 역할
    public void openShop() {
        System.out.println("가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.");
    }
//    @PreDestroy    // destroyMethod와 같은 역할
    public void closeShop() {
        System.out.println("가게 문을 닫았습니다. 이제 쇼핑을 하실 수 없습니다.");
    }

}
