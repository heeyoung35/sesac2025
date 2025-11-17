package com.ohgiraffers.section02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                // com.ohgiraffers.section02하위에 있는 모든 빈을 찾아서 등록해줘!
                =new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }

        PokemonService pokemonService = context.getBean(PokemonService.class);

        pokemonService.pokemonAttack();
    }
}
