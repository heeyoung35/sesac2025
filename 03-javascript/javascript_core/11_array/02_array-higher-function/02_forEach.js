// forEach: 배열의 각 요소에 대해 콜백 함수를 실행합니다. 반환 값은 없습니다.

const names = ['호랑이', '기린', '늑대'];

// for 반복문
 for(let i = 0; i < names.length; i++) {
    console.log(names[i]);
 }

 // forEach 버전
 names.forEach(name => console.log(name));   // forEach고차함수(콜백함수 하나하나의 이름을 name으로 받아오겠다는 것)
 // names.forEach(function(name){
 //     console.log(name);
 // });

 // 콜백 함수는 요소의 값, 인덱스, 배열 자체를 인자로 받을 수 있다.
 // name만 사용하면 요소의 값인 호랑이를 가지고 오지만 해당하는 요소의 인덱스 값과 배열전체를 받을 수도 있다. 
 names.forEach((name, index, array) =>{
    console.log(`${index + 1}번째 이름: ${name}`);
 } )