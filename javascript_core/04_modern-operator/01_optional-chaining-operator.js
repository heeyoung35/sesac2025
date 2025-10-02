/**
 * 옵셔널 체이닝 연산자
 * ES11에서 도입된 연산자로 좌항의 피연산자가 null 또는 undefined인 경우 undefined를 반환하고
 * 그렇지 않으면 우항의 프로퍼티 참조를 이어간다.
 * 단축평가를 이용할 경우 null 값이거나 0인 의미있는 경우 false로 판단하는데 이것을 보완할 수 있다.
 */

var obj = null;
// var val = obj.value; // TypeError

var val = obj?.value;  // '.' 참조 연산자 앞에 물음표를 넣어서 비교
// val 값이 null이나 undefined의 경우 undefined가 출력되고 그렇지 않으면 value가 출력된다. 
// 옵셔널 체이닝 연산자 이전에는 논리연산자 &&를 사용한 단축 평가로 확인했었다.
// 그러나 빈 문자열과 같은 Falsy한 값을 false로 취급해서 생기는 문제가 있다.
var str = '';
console.log(str.length);  // 터미널에 0이 출력 

// 빈 문자열과 같은 Falsy 값을 false 취급해서 생기는 문제
var len = str && str.length; // 빈문자열에 대한 길이를 알고 싶은경우 단축평가에서는
console.log(len)  // 의도한 빈문자열의 길이인 0이 아니라 빈문자열 그대로 출력된다. 

// 빈 문자열은 null 또는 undefined가 아니므로 문자열의 길이 값이 담긴다. 
var len = str?.length;
console.log(len) // 출력값 문자열의 길이 값이 없기 때문에 0이 출력된다.