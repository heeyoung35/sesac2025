/** 함수 호이스팅 
 * 코드는 위에서 아래로 한줄 한줄 읽어나간다. 
 * 함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 실행된다.
 * 따라서 선언문 이전에 함수를 참조, 호출할 수 있다.
 * 함수 선언문이 코드 선두로 끌어 올려진 것처럼 동작하는
 * 자바스크립트 고유의 특징을 함수 호이스팅이라고 한다. 
*/

console.log(hello); // [Function: hello]
//console.log(hi);   // undefined

console.log(hello('홍길동'));

// console.log(hi('판다'));  // undefined

// 함수 선언문은 실행하기 전에 제일 앞에 있는 것처럼 자바스크립트가 읽기 때문에 함수 선언문 위에서 출력코드를 사용해도 출력된다.
function hello(name) {     // funtion함수이름(재료)
    return `${name}님 안녕하세요!`  // 반환 값
}

// 함수 표현식은 실행하기 전에 참조할 수 없다. 변수에 할당되는 표현식은 참조할 수 없다.
var hi = function(name) {  // hi가 함수 식별자로 함수를 호출 할 수 있다.
    return `${name} 안녕~`
}