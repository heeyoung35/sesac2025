/**
 * 'new' 버튼을 눌렀을 때 내부에서 벌어지는 일 (인스턴스 생성 과정)
 */
function Student(name, age) {

    // 1단계 : 빈 객체가 암묵적으로 만들어지고, this에 할당된다. Student {} 출력
    console.log(this); // this {빈객체}를 할당한다는 것이다. 전역겍체(window)

    // 2단계: this에 할당된 빈 객체에 속성들에 추가하며 초기화합니다. (위에 만들어진 빈 객체에 값이 추가된다.)
    this.name = name; // 속성을 채워나간다. 
    this.age = age;
    this.getInfo = function() {
        return `$(this.name)은 ${this.age}세 입니다.`;
    }
    // 3단계 : 완성된 객체(this)가 암묵적으로 반환된다. 
    //        마치 return this; 코드가 맨 마지막에 있는 것처럼 동작한다. 
}

const student = new Student('홍길동', 20);
console.log(student);

/**
 * 설계도를 잘못 사용했을 때의 위험성 (new 없이 호출)
 */

// new 없이 호출하면 생성자 함수가 아닌 '일반 함수'로 동작한다. 
const student2 = Student('다람쥐', 2);
console.log(student2);  // 생성자 함수를 호출하는데 new를 사용하지 않았을 때 undefined가 출력된다. return이 없기 때문이다.
// 이때 함수 안의 this는 '전역객체(student가 아니라 window)'를 가리키게 된다. (전역 오염)
// console.log(window.name); // '다람쥐'

/**
 * new.target을 이용한 안전장치 설치
 */
function Dog(name, age){

    // 이 함수가 new와 함께 생성자로 호출되었는지 확인한다.
    // new와 함게 호출되면 new.target은 자기 자신(Dog 함수)을 가르킨다. 그렇기 때문에 true가 되어서 if문이 실행되지 않는다.
    // new 없이 일반함수로 호출되면 new.target은 undefined가 된다. undefined가 false인데 ! 붙여서 true가 되어서 if문이 실행되어 new가 붙여서 호출
    if(!new.target) { 
        console.log('new없이 호출했네요~ new를 붙여서 다시 실행합니다.')
        return new Dog(name, age)
    }
    this.name = name;
    this.age = age;
}
const dog1 = Dog('두부', 1);
console.log(dog1);