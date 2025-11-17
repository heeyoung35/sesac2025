package com.ohgiraffers.section03.properties;

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

        /* context.getBean(...): 컨테이너에서 carpBread, milk, water 빈을 가져옵니다.
        * 이 빈들은 하드코딩된 값이 아니라 .properties 파일에서 읽어온
        * 값들(예: "붕어빵", 1000)을 가지고 있습니다.*/

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 : " + cart1.getItems());


        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 : " + cart2.getItems());

        /* destroy 메소드는 빈 객체 소멸 시점에 동작하므로 컨테이너가 종료 되어야 확인 가능하기 때문에 강제 종료! */
        ((AnnotationConfigApplicationContext)context).close();
    }
}
