/**
 *  함수의 정체는 일급 객체
 * 자바스크립트에서 함수는 '값(value)'으로 취급될 수 있다. 
 */

// 1. 변수에  담을 수 있다. (함수 표현식)
var sayHello = function() { // sayHello에 함수 자체(통째로)를 담아주고 있다. 이렇게 될 수 있는 이유는 자비스크립트는 함수를 값으로 인식하고 있기 때문이다. 
    console.log('안녕!!');
}

sayHello();

// 2. 객체의 속성으로 담을 수 있다.(메서드)
// 객체는 (키 : 값)인데 값에 함수를 담을 수 있다. 

var myObject = {
    sayHi: function() {
        console.log('반가워~!');
    },
    // 최신 문법으로는 아래와 같이 단축해서 사용 가능하다. 
    sayBye() {  // function 키워드를 생략해서 사용할 수 있다. 
        console.log('잘가~');
    }
};

myObject.sayHi();
myObject.sayBye();

// 3. 함수의 인자(argument)로 전달할 수 있다.
// 4. 함수의 결과(return value)로 반환될 수 있다. 

function manager(tsak, count) {
    console.log(`매니저가 업무를 지시합니다.`);
    for(let i = 0; i < count; i++) {
        tsak(); // 위의 sayHello 함수를 호출함, 즉 함수의 인자로 함수를 받을 수 있다. 인자로 받은 함수(task)를 실행!
    }

    // 함수를 결과물로 반환!!
    return function() {
        console.log('모든 업무가 완료되었습니다.');
    };
}
// sayHello 함수를 인자로 전달
var report = manager(sayHello, 3); // 변수에 함수가 담겨있는 형태

// manager 함수가 바환한 새로운 함수를 실행
report();