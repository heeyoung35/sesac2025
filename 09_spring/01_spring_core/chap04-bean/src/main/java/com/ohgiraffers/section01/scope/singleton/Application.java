package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // 컨텍스트 파일을 읽어와 스프링 컨테이너를 생성할 때 ContextConfiguration에
        // 정의된 싱글톤 빈들의 인스턴스가 미리 생성되어 컨테이너에 보관
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        // 컨테이너에 cart라는 이름의 빈을 요청하면 보관하고 있던 ShoppingCart 인스턴스를 cart1변수에 할당
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        // cart1 인스턴스에 붕어빵과 딸기우유를 담는다.
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        // cart1의 내용물이 출력
        System.out.println("cart1 : " + cart1.getItems());

        // 만들어둔 카트1번을 다시 사용한다. 기본 범위는 싱글톤이기 때문에 getBean을 사용해도 동일하다.
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        // cart2에 물을 담지만 인스턴스를 다시 생성하지 않기 때문에 cart1에 있는 내용물에 물까지 담긴다.
        cart2.addItem(water);

        System.out.println("cart2 : " + cart2.getItems());

        // 해시코드가 동리하기 때문에 하나의 인스턴스를 공유한다. 두 카트를 다른 제품을 담으려고 했지만 동일한 카트에 담긴 것이 된다.
        System.out.println("cart1 해시코드" + cart1.hashCode());
        System.out.println("cart2 해시코드" + cart2.hashCode());

        /* Bean의 기본 스코프는 singleton이다.
        * 즉, 스프링 컨테이너가 시작 될 때 딱 한번 생성되고 그 이후 getBean()을 아무리 호출해도 그 동일한 인스턴스를 반환한다.
        *  singleton 스코프를 갖는 bean은 어플리케이션 내에서 유일한 인스턴스를 갖는다.
        * */


    }


}
