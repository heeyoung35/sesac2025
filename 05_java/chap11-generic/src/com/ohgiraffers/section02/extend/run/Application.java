package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {

        // Rabbit 또는 그 자손만으로 논장 생성할 수 있다.
        RabbitFarm<Rabbit> farm1= new RabbitFarm<>(new Rabbit()); // 토끼를 생성하면서 토끼를 가진 농장 생성
        RabbitFarm<Bunny> farm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> farm3 = new RabbitFarm<>(new DrunkenBunny());

//      RabbitFarm<Snake> farm4 = new RabbitFarm<>(); //<T extends Rabbit> 규칙 위반

        FarmManager manager = new FarmManager();

        manager.manageAnyFarm(farm1);
        manager.manageAnyFarm(farm2);
        manager.manageAnyFarm(farm3);

//      manager.manageBunnyFarm(farm1); // Rabbit은 Bunny의 자손이 아니기 때문에 컴파일 에러
        manager.manageBunnyFarm(farm2);
        manager.manageBunnyFarm(farm3);

        manager.manageRabbitOrBunnyFarm(farm1);
        manager.manageRabbitOrBunnyFarm(farm2);
//      manager.manageRabbitOrBunnyFarm(farm3); // DrunkenBunny는 Bunny의 부모가 아니기 때문에 컴파일 에러
    }
}
