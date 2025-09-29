/** 1. 함수 선언문 */

// 함수 선언문에서는 함수의 이름을 생략할 수 없다.
function hello(name) {     // funtion함수이름(재료)
    return `${name}님 안녕하세요!`  // 반환 값
}

// 함수 호출
console.log(hello('홍길동'));

/** 2. 함수 표현식 */

var hi = function(name) {  // hi가 함수 식별자로 함수를 호출 할 수 있다.
    return `${name} 안녕~`
}

console.log(hi('판다'));

// 함수 표현식에서 함수명을 생략하지 않아도 문제는 없다.
var calc = function add(a, b) {  // 식별자와 함수명을 다르게 하면 함수명이 아닌 식별자로 이루어진다. 
    return a + b;
}
// 단 , 함수 호출은 식별자로 이루어진다. 
console.log(calc(10,20));

// ReferenceError: add is not defined
// console.log(add(10,20)); 