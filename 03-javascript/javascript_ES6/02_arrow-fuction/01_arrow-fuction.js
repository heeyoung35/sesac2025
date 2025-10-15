/**
 * [화살표 함수]
 * ES6에서 도입된, 함수를 간결하게 표현하는 새로운 문법이다.
 * 단순히 문법만 짧아진 것이 아니라, 'this'를 다루는 방식이 혁신적으로 바뀌었다.
 */

// 기본 변환
let massage = function() {return "Hello World!"};
let arrowMsg1 = () => {return "Hello World!"};
console.log(arrowMsg1());

// 본문이 return 한 줄이면, 중괄호{}와 return을 동시 생략!
let arrowMsg2 =() => "Hellow Simple Arrow";
console.log(arrowMsg2());

// 매개변수가 하나일 때만, 소괄호() 셍랙 가능
let power = function(x) {return x * x;};
let arrowPower = x =>  x * x;
console.log(arrowPower(3));

// 매개변수가 없거나, 두 개 이상이면 소괄호() 필수. 소괄호를 넣지 않으면 오류발생
let greet = () => "Hello!";
let sum = (a,b) => a + b;
console.log(sum(10,20))

// 주의!!! 객체 리터럴을 반환할 때는 소괄호()로 감싸야 합니다.
// 감싸지 않으면 함수 몸체의 중괄호{}로 오해한다. 즉 객체가 아닌 return으로 인식한다.
// 고차함수에서 화살표 함수를 사용하면 위력이 크다.
const createUser = (id, name) => ({id, name}) 
console.log(createUser(1,'홍길동'));

const numbers = [1, 2, 3, 4, 5];

// numbers.map(function(val) {return val *10;});
const mappedNumbers = numbers.map(val => val * 10);

console.log(mappedNumbers);