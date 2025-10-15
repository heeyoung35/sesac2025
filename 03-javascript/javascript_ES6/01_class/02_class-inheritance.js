/**
 * [클래스 상속]
 * 하나의 클래스가 다른 클래스의 기능과 속성을 물려받아
 * 자신의 것처럼 사용하고, 거기에 더해 자신만의 기능을 확장하는 기술이다.
 * 코드의 재사용성을 극대화하는 객체 지향 프로그램밍의 핵심 원리이다.
 */

// '부모' 클래스 정의
class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }
    eat(foodWeight){
        this.weight += foodWeight;
        console.log(`${this.name}은 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었습니다.`);
    }

    move(lostWeight){
        if(this.weight > lostWeight) this.weight -= lostWeight;
        console.log(`${this.name}은 움직여서 ${lostWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
    }
}

// '자식' 플래스 정의: extends 키워드로 Animal을 상속받는다.
class Human extends Animal {
    // Human 클래스만의 새로운 메서드
    develop(language) {
        console.log(`${this.name}은 ${language}로 개발을 합니다. 정말 재미있습니다 ~_~`);
    }
}

const human = new Human("수강생", 70);

human.eat(3);
human.move(2);

human.develop("javascript");

/** [메서드 오버라이딩]
 * 부모에게 물려받은 메서드를 자식이 재정의 하는 것이다.
 * super 키워드를 사용하면, 자식의 메서드 안에서 부모의 메서드를 호출 할 수 있다. 
*/

class Tiger extends Animal {
    attack(target) {
        console.log(`${this.name}은 ${target}을 공경합니다.`);
    }

    // move 메서드 오버리이딩(재정의)
    move(target){ 
        // supeer를 사용해서 부모의 메서드를 호출한다.
        super.move(0.1);  // super.move()로 부모의 원래 기능 먼저 실행
        // 자식만의 새로운 기능 추가
        this.attack(target);
    }
}
const tiger = new Tiger("호랑이", 100);

tiger.move('슬픈 눈망울의 사슴');

/**
 * 자식 클래스에 새로운 프로퍼티를 추가하고 싶을 때, constructor를 재정의한다.
 */

class Deer extends Animal {
    constructor(name, weight, legLength) {
       /* this.name = name;
        this.weight = weight 대신해서 super(부모의 constructor) 아래와 같이 사용한다. 
        반드시 자식의 constructor에서 this를 사용하기 전에 반드시 super()로 부모의 constructor부터 실행해야 한다.
        즉 부모의 생성자가 먼저 있어야 자식이 생성될 수 있다.*/ 
        super(name, weight); // 부모의 constructor 실행
        this.legLength = legLength;
    }
    hide(place) {
        console.log(`${this.legLength}cm 다리를 가진 ${this.name}은 ${place}에 숨습니다.`);
    }
}

const deer = new Deer ('슬픈 눈망울의 사슴', 40, 120);
deer.eat(0.5);
deer.hide('동굴 안');