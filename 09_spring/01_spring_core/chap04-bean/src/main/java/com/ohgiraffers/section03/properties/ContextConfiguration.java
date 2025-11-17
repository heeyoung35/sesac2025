package com.ohgiraffers.section03.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.initdestroy.annotation.Owner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
/*resources 하위 경로 기술을 스프링 컨테이너에게 알려주고 product-onfo.properties파일을 로드하라는 의미 */
@PropertySource("section03/properties/product-onfo.properties")
@Configuration
public class ContextConfiguration {

    /* ${bread.carpbread.name} 치환자(placeholder)문법을 이용하여 properties 파일에 저장된 key를 찾아서
    * 그 값을 carpBreadName변수에 넣어줘라는 뜻으로 value를 꺼내온다.
    * 파일에 정의된 key에 해당하는 value을 클래스의 필드(변수)에 주입*/
    @Value("${bread.carpbread.name}")
    private String carpBreadName;
    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;
    @Value("${beverage.milk.name}")
    private String milkName;
    @Value("${beverage.milk.price}")
    private int milkPrice;
    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName,carpBreadPrice, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }
    /* @Value로 미리 주입받은 클래스 필드 값을 사용하여 Bread와 Beverage 객체를 생성하고 빈으로 등록 */


    // 메소드의 파리미터에 값 주입
    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price}") int waterPrice,
                         @Value("${beverage.water.capacity}")int waterCapacity) {
        return new Beverage(waterName,waterPrice,waterCapacity);
    }
    /* @Bean 메소드의 파라미터에 직접 @value를 사용하여 값을 주입받음
    *  스프링이 빈을 만들 때 해당 키와 값들을 찾아 waterName,waterPrice,waterCapacity
    *  파라미터로 넘겨주고, 이 값들로 Beverage 객체가 생성*/

    @Bean
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }
 }
