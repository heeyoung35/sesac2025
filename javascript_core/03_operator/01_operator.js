/**
 * 연산자(Operator)는 두 개 이상의 값을 조작하거나 비교하여 결과를 생성하는 기호이다.
 * 자주 사용되는 연산자에는 산술 연산자, 할당 연산자, 증감 연산자 등이 있다.
 */

// 1. 산술 연산자

var a = 10;
var b = 3;

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
console.log(a % b);    // 나머지 값이 출력
console.log(a ** b);   // 거듭제곱

// 2. 할당 연산자
var c = 5;    // 할당 연산자 5를 c에 할당한다.
c += 3;  // c= c+3의 값을 c에 할당한다는 의미이다.
// c -= 3;
console.log(c);

// 3. 증감 연산자
var d = 5;
console.log(d++); // 후의 증가 먼저 출력을 5를 하고 1을 더하는 것이기 때문에 값은 6이 된다.
console.log(++d); // 위의 과정으로 d의 결과 값이 6에서 먼저 1을 더하고 출력을 하기 때문에 7이 출력된다. 
console.log(--d); // 위의 과정으로 d의 결과 값이 7인데 여기서 1을 빼주기 때문에 6이 출력되고
console.log(d--); // 위의 과정으로 d의 결과가 6이기 때문에 6이 먼저 출력된다.