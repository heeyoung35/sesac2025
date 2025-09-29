// 1. 변수 중복 선언 금지 -> 코드의 안정성 확보
let msg = '안녕하세요';

//SyntaxError: Identifier 'msg' has already been declared 이미 선언되었다는 에러발생
// let msg = '안녕히가세요';

// 2. 블록({}) 레벨 스코프 -> 변수 오염 방지 중괄호를 모두 존중한다. 
let i = 100;

for(let i = 0; i < 5; i++) {
    // 이 i는 for문 {}안에서만 사는, 이름만 같은 완전히 다른 변수이다. 
    console.log('for문 내부의 i:', i); // 여기에서의 i는 let의 i와 전혀 다르다. 그래서 출력시 for문 바깥의 i: 100로 출력
}
// for문의 i는 전역 i에 전혀 영향을 주지 못한다. 
console.log('for문 바깥의 i:', i);

// 3. 변수 호이스팅이 일어나지 않는 것처럼 동작
// console.log(test); / ReferenceError: Cannot access 'test' before initialization
// 선언과 초기화 단계가 분리되어, 선언 전에 접근하면 에러발생
let test; // 초기화를 하기전에는 접근할 수 없다는 값을 넣어주기 전에는 접근할 수 없다. 
test ='반갑습니다.'
console.log(test);