var dog = {
    name : '뽀삐',
    eat : function(food) {
        console.log(`${this.name}는 ${food}를 맛있게 먹어요.`)
    }
}

// 마침표 표기법 마침표로 객체의 속성에 접근한다.
console.log(dog.name);
dog.eat('개껌')

// 대괄호 표기법 - 프로퍼티 키는 반드시 따옴표로 감싼 문자열을 사용한다.
console.log(dog['name']);
dog['eat']('간식')

// key가 변수에 담겨있는 경우
var propName = 'naem';

// dog. propName 이라고 쓰면 'propname'이라는 키를 찾으려고 합니다. (undefined) 그래서 대괄호 표기법을 사용해야 한다.
// 변수에 담긴 키 값을 이요해 동적으로 프로퍼티에 접금할 때 유용하게 쓰인다.
console.log(dog[propName])   // dog['name']와 같음

// in 연산자
// 프로퍼티 '존재' 여부 확인하기
console.log("name" in dog);
console.log("age" in dog);

// for in 반복문
// 객체의 모든 프로퍼티 키 순회
for (var key in dog) {            // key : name  dog에 키값을 모두 출력
    console.log(`key : ${key}`);  // key : eat 
    console.log(`dog[${key}] : ${dog[key]}`) // 키에 해당하는 값
    // dog.key 라고 쓰면 'key'라는 이름의 프로퍼니 키를 찾으려 하기 때문에 출력이 되지 않는다.
}