let globalVar = '전역 변수';     // 가장 넓은 스코프
// 바깥 젼역 변수는 안에서 안에서도 사용가능하지만 안의 스코프는 바깥에서 사용불가능하다. 
if (true) {
    let blockVar = '블록 스코프 변수'  // if문 안에서만 유효

    function sayHi() {
        let functionVar = '함수 스코프 변수'; // sayHi 함수 안에서만 유효

        console.log(globalVar);
        console.log(blockVar);
        console.log(functionVar);
    }
    sayHi();

    // console.log(functionVar); //function 안쪽의 함수 스코프를 접근할 수 없다. ReferenceError: functionVar is not defined
}

// console.log(blockVar); // if문 안쪽의 함수 스코프이기 때문에 바깥에서 젒근할 수 없다. ReferenceError: functionVar is not defined

/**
 * 원칙 1: 기본적으로 모든 변수는 const로 선언한다. (가장 안전)
 * 원칙 2: 값이 반드시 바뀌어야만 하는 변수에만 let을 사용한다.
 * 원칙 3: var는 이제 사용하지 않는다. 
 */