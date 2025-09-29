/**
 *  매개변수(parameter)와 인수(argument)
 */

// 함수 선언문
function hello(name) { // name를 매개변수 또는 파라미터라 한다.

    // 매개변수는 함수 몸체 내부에서만 참조할 수 있다. 
    console.log(name);

    // 모든 인수는 암묵적으로 arguments 객체의 프로퍼티로 보관된다. 
    console.log(arguments); // [arguments]{'0' : '코알라'} 출력된다. /  가변인자 함수 구현시 유용하게 사용된다. 

    return `${name}님 안녕하세요!`;  // 반환하는 값 , 아직 함수를 호출하기 전
}
// console.log(name); 함수 몸체 외부에서는 매개변수를 확인할 수 없다. 

// 함수를 호출한다는 것은 함수를 실행하는 것인데 판다는 전달받은 name
var result = hello(`판다`)   // 함수 호츨하는 호출문, 전달하는 값을 '인수(argument)'라고 한다. 
console.log(result); // return값을 출력하는 출력문

result = hello(); // 인수가 부족해서 할당되지 않은 매개변수 값은 undefined, 출력문 undefined님 안녕하세요!가 출력 
console.log(result);

result = hello('코알라','판다');
console.log(result); // 매개변수보다 인수가 더 많은 경우 초과된 인수는 무시된다. 


function hi(name = '호랑이'){
    // 인수를 전달하지 않았을 경우, ES6에서 도입된 매개변수 기본값을 사용할 수 있다. 
    return `${name} 인녕~`;
}

result = hi();
console.log(result);