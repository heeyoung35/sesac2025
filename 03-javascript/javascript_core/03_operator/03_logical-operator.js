/**
 * 논리 연산자는 여러 조건을 결합하여 하나의 논리적 결과를 도출한다.
 * 논리 연산자는 AND, OR, NOT 연산자가 있다.
 */

var a = true;
var b = false;

// 1. 논리 AND (&&)
console.log(a && b);   // a 와 b가 모두 true일 때만 true이기 때문에 false 출력

// 2. 논리 OR (||)
console.log(a || b);  // a 또는 b 중에서 하나만 true이면 true 출력

// 3. 논리 NTO (!)
console.log(!a);    // true이면 false로 false이면 true로 반전하기 때문에 false 출력
console.log(!b);    // true

/**
 * 단축 평가
 * 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
 */

//'apple'이 이미 truey 값이어서 true로 평가되고
// 논리 연산의 결과를 결정한 첫 번째 피연산자 apple을 그대로 반횐한다.
console.log('apple' || 'banana');  // apple만 보아도 true 이기 때문에 apple 출력
console.log(false || 'banana');  // banana 결과를 결정한 피연산자를 출력

console.log('apple' && 'banana'); // &&연산자는 두 값을 모두 비교해서 출력하기 때문에 'apple'과 'banana' 중 비교한 결과가 확정된 banana를 출력
console.log(false && 'banana'); // 앞에서 이미 false이기 때문에 뒤의 값을 확인하지 않고 단축평가 해서 false를 출력한다.

var obj = null; 
//TypeError: Cannot read properties of null (reading 'value')
//var val = obj.value;  // TypeError 단축평가로 null값을 확인 할 수 있다. 

// 에러 방지 (Null Check)
var val = obj && obj.value; // obj값이 이미 null값인 false이기 때문에 obj.value은 실행하지 않는다.

/**
 * if(obj !== null) null과 같지 않다면 실행하라는 것인데 이러한 긴 코드를 대체해서
 * 프로그램이 멈추는 것을 막을 수 있는 단축평가를 사용한다. 
 * 단점은 의미있는 값까지 false로 판단할 수 있다.
 */