package com.ohgiraffers.section02.abstractclass;

// abstract : 이 클래스는 미완성 설계도입니다. 직접 객체를 만들 수 없습니다.
// 추싱 메서드를 하나 이상 포함하는 클래스를 말한다. 대표 타입 사용
public abstract class Player {

    /*
        public void attack() {
        System.out.println("플레이어가 공격 합니다.");
    }*/

    // 추상 메소드: {} 몸통이 없는 미완성 메소드로 클래스와 메소드에 abstract를 같이 사용해야 한다.
    // 이런 기능이 필요하다는 선언만 있는 미완성 메소드
    // 이 클래스를 상속받는 모든 자식은, 반드시 attack()메소드 내용을 직접 구현해야 한다.
    public  abstract void attack();

    // 추상 클래스도 일반 메소드를 가질 수 있다.
    public void levelIp() {
        System.out.println("레벨업!!");
    }
}
