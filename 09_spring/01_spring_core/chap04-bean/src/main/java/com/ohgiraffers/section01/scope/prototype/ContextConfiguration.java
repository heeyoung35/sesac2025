package com.ohgiraffers.section01.scope.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수" , 3000, 500);
    }

    @Bean
    /* prototype스코프로 설정된 Bean은 getBean()으로 호출될 때마다 또는 의존성 주입(DI)이 발생할 때마다
     * 매번 새로운 객체 인스턴스를 생성하여 반환한다.
     * @Bean 어노테이션과 함께 @Scope("prototype")을 명시
     * 만약 @Component스캔을 사용한다면 틀래스 레벨에 직접 붙여도 된다.
     * 하지만 prototype Bean은 스프링이 생성하고 초기화까지만 담당하고 클라이언트 코드에 전달한 후에는 더 이상 빈을 관리하지 않음
     * 싱글톤 빈은 스프링 컨테이너가 시작할 때 생성되고 종료될 때 소멸 콜백 메서드가 호출되어 정리함 */

    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
 }
