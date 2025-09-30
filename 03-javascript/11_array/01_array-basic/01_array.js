/**
 * array(배열)
 * 배열은 여러 개의 값을 순차적으로 나열한 자료구조이다.
 */

// 배열 리터럴을 통해 배열 생성
const fruits = ['바나나', '복숭아', '키워']; // 배열 하나하나의 모든 값을 요소라 한다. 0번부터 인덱스를 가지게 된다.

// 배열의 요소는 자신의 위치를 나타내는 인덱스를 가지며 배열의 요소에 접근할 때 사용된다. 
console.log(fruits[0]); // fruits라는 배열의 0번 인덱스에 접근하겠습니다.
console.log(fruits[2]); // 배열의 길이를 확인하는 length가 있다. 

// 배열은 요소으 개수, 즉 배열의 길이를 나타내는 length 프로퍼티를 갖는다.
console.log(fruits.length);

// 배열은 인덱스와 length 프로퍼티를 갖기 때문에 for문을 통해 순차적으로 요소에 접근할 수 잇다. 
for(let i =0; i < fruits.length ; i++) {  // 배열의 길이를 알지 못하고 순회할 때는 length로 배열의 길이에 맞도록 순회하게 할 수 있다.
    console.log(fruits[i]);
}

console.log(typeof fruits);  // 배열도 객체이다. 