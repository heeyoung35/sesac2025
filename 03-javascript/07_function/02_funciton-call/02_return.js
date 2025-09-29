/**
 * return(반환문)
 * 함수의 결과를 밖으로 꺼내올 수 있는 것
 */

function hello(name) {  // function(함수) hello(함수이름)(name(매개변수))의 형식이다. 
    // 반환문
    return `${name}님 안녕하세요~!`; // 반환문을 만나면 함수는 종료되기 때문에 

    console.log(name); //반환문 이후에 쓰는 코드는 무시가 된다.

}
// 리턴 키워드 뒤에 오는 값을 반환한다. 
console.log(hello('다람쥐'));

function func() {
    console.log('함수가 호출되었습니다.');
    return;
    // 하지만 반환값을 명시적으로 지정하지 않았기 때문에 undefined가 출력된다.
    // 또는 반환문을 생략할 수도 있다. 이때도 암묵적으로 undefined가 반환된다. 
    // 동작만 수행하게 할 때는 return이 생략되기도 한다. 
} // 함수가 호출되기 전이라 함수가 실행되지 않는다.

console.log(func()); // 함수가 호출되면서 함수가 실행되어 함수 내부에 있는 return 키워드 이후 문자열이 출력된다. 함수가 호출되었습니다 출력

