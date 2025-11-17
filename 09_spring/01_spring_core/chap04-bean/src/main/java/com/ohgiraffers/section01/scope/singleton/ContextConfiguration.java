package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
/* 이 파일은 스프링 컨테이너에 어떤 빈들을 등록할지 정의하는 클래스*/
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

    @Bean   // @Scope 어노테이션이 없기 때문에 싱글톤이 적용으로 cart빈은 스프링 컨테이너 전체에서 단 하나의 인스턴스만 생성
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
 }
