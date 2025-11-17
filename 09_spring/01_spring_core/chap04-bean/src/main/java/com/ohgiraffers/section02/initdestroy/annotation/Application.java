package com.ohgiraffers.section02.initdestroy.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 : " + cart1.getItems());

        // 만들어둔 카트1번을 다시 사용한다. 기본 범위는 싱글톤이기 때문에 getBean을 사용해도 동일하다.
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 : " + cart2.getItems());

        /* destroy 메소드는 빈 객체 소멸 시점에 동작하므로 컨테이너가 종료 되어야 확인 가능하기 때문에 강제 종료! */
        ((AnnotationConfigApplicationContext)context).close();


    }
}
