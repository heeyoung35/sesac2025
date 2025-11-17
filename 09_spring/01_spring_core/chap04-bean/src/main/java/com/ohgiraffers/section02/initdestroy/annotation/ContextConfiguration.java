package com.ohgiraffers.section02.initdestroy.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestroy.annotation")
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
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    // @Bean어노테이션의 destroyMethod 속성 지정으로 스프링은 owner빈을 생성한 후
    // 컨테이너가 종료되어 빈을 소멸시켜야 할 때 Owner클래스의 closeShop()메소드를 찾아서 실행
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
 }
