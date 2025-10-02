const foods =['짜장면', '샌드위치', '우동'];
console.log(foods);

// push(); 맨 뒤에 값 추가하기
foods.push('탕수육');
foods.push('곱창');
console.log(`push 후: ${foods}`);  

// pop(): 맨 뒤의 값 떼어내기
foods.pop();
console.log(`pop 한번: ${foods}`);
const food = foods.pop();  // 제거한 값을 반환한다.    // 탕수육 출력
console.log(`pop 두번: ${foods}`);

/**
 * unshift(): 맨 앞에 값을 추가한다.
 * shift(): 맨 앞의 값을 제거한다. 
 */

foods.unshift('후라이드치킨');
foods.unshift('양꼬치');
console.log(`unshift 후: ${foods}`)

foods.shift();
console.log(`shift 후: ${foods}`)

/**
 * indexOf(값): 특정 값이 있는 '첫 번재 인덱스'를 알려준다. 없으면 -1을 반환한다.
 * includes(값): 특정 값이 있는지 여부만 true/false로 알려준다.
 */

foods.push('짜장면');
console.log(foods);

console.log(foods.indexOf('짜장면'));  // 짜장면은 몇번째인덱스에 있는지 확인. 중복으로 있어도 가장 첫번재 있는 인덱스 번호를 알려준다.
console.log(foods.indexOf('돈까스'));  // 없는 값은 -1 출력

console.log(foods.includes('샌드위치'));
console.log(foods.includes('김치찌게'));

// MDN(Mozilla Developer Network) 참고
