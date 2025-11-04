package com.ohgiraffers.section01.polymorphism;

import java.util.concurrent.Callable;

public class Application {
    public static void main(String[] args) {

        /* [다형성]
        *  하나의 참조 변수(부모타입)나 메소드 호출이,
        * 실제 참조하는 객체가 무엇이냐에 따라 다양한 방식으로 동작하는 것
        * */

        // 다형성이 없다면?
        Zookeeper badZookeeper = new Zookeeper();
        badZookeeper.feed(new Cat());  // 고양이 객체를 바로 전달
        badZookeeper.feed(new Tiger()); //호랑이 객체를 바로 넘겨줌
        // 동물이 많다면 feed라는 메서드를 다양하게 많이 만들어야 하는데 이것을 해결해주는 것이 upcasting을 사용한다.

        // 다형성 적용(업캐스팅) 캣타입에 참조변수를 만들었다. 상속이 적용되면 부모의 타입으로 레퍼런스 변수를 만들 수 있다.
        // 동물의 참조변수로 고양이를 조작할 수 있다. 모든 is a관계가 성립될 때 가능하다.
        // 부모 타입의 참조 변수로 자식 타입의 인스턴스를 가리킬 수 있다.
        Animal a1 = new Cat(); // 자식 객체를 부모 타입의 변수에 할당
        Animal a2 = new Tiger();

        // [동적 바인딩] 컴파일 시점에 애니멀의 크라잉을 가르키는 것 같지만
        // 런타임 시점에는 고양이에 연결되어 있는 오버라이드 된 고양이를 연결한다.
        // 컴파일 시점에는 부모(Animal)의 메소들 ㄹ호출하는 것으로 보이지만,
        // 실행 시점(Runtime)에는 참조 변수가 실제로 가리키는 객체(cat, tiger)의
        // 오버라이딩 되니 메소드가 실행되는 원리이다.
        a1.cry(); // 출력값 야옹 연결된 객체가 무엇이냐에 따라서 달라진다.
        a2.cry(); // 출력값 어흥

//      a1.jump();
        // cat의 타입에 직접 접금이 불가 참조 변수를 고양이로 변경할 수 있다. 다운캐스팅
        // Animal 리모콘이므로 cat만 가진 jump() 호출 불가

        ((Cat)a1).jump();  // 다운캐스팅: 명시적으로 타입 강제 변환 a1을 Cat으로 강제 형변환.
        // 자식이 가지고 있는 고유기술을 사용하려고 할 때

//      ((Cat)a2).cry();  호랑이를 고양이로 바꾸려면?
        // 호랑이를 Cat으로 바꾸려 하면 ClassCastException 발생!! 에러로 프로그램 종료
        // 컴파일 에러는 발생하지 않지만 출력시 오류발생!! 형변환 전에 확인필요 인스턴스 오브 사용
        /* 위와 같은 위험한 상황을 방지하기 위해, 형변환 전에는 반드시
           instanceof 연산자로 가리키는 객체를 확인하고 실행하는 것이 안전하다. */
        System.out.println("a1은 Tiger 타입인가? " + (a1 instanceof Tiger));  // false 출력

        if (a1 instanceof Cat) {
            System.out.println("a1은 고양이가 맞군요! 점프!");
            ((Cat)a1).jump();
        }

        /* 다형성을 활용한 객체 배열 */
        Animal[] animals = new Animal[5];  // 부모타입으로 자식들을 가리킬 수 있다. 다형성이 적용되어서 배열에 담을 수 있다.
        animals[0] = new Cat();
        animals[1] = new Tiger();
        animals[2] = new Tiger();
        animals[3] = new Cat();
        animals[4] = new Tiger();

        // 모든 둥물들아 울어봐 (동적 바인딩 활용)
        for(Animal animal : animals) {  // 임시변수에 담아서 for문으로 반복하며 각자 재졍의한 울음매서드로 호출
            animal.cry();  // 각자 가리키는 객체를 반환한다.
        }

        // 다운케스팅 방법
        // 각자 할 수잇ㄴ느 장기자랑 해봐 (instanceof와 다운캐스팅 활용)
        for(Animal animal : animals) {
            if (animal instanceof Cat) {
                ((Cat)animal).jump();
            }else if (animal instanceof Tiger) {
                ((Tiger)animal).bite();
            }
        }

        // 매개변수의 다형성 + 동적 바인딩 활용
        Zookeeper goodZookeeper = new Zookeeper();
        for (Animal animal : animals) {
            goodZookeeper.feed(animal);
        }
    }
}
