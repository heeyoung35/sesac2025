package com.ohgiraffers.section02.abstractclass;
// 플레이어라는 추상 클래스를 상속받고 있기 때문에
// 클래스 'Wizard'은(는) abstract로 선언되거나 'Player'에서 추상 메서드 'attack()'을(를) 구현해야 합니다
// 애러발생으로 메서드를 반드시 사용할 수 있도록 강제한다.
public class Wizard extends Player{

    @Override
    public void attack() {
        System.out.println("마법사가 파이어볼 마법으로 공격합니다. 화르륵~~");
    }
}
