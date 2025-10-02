/**
 * continue: 현재 반복문의 나머니 코드를 건너뛰고, 다음 반복으로 넘어간다.
 * break: 현재 반복문을 완전히 종료한다.
 * 
 * 이 두 가지 문은 반복문의 흐름을 제어하는 데 매우 유용하며, 
 * 특정 조건에서 반복을 건너뛰거나 중단해야 할 때 사용한다.
 */

for(let i = 1; i <= 10; i++){  // for문이 반복문인에 continue를 만나면 아래 코드를 건너뛰고 증감식으로 간다.
    if(i % 2 === 0) {
        continue;  // i가 짝수라면 continue를 만나서 증감식으로 가서 +1이 되면 홀수이기 때문에 continue를 만나지 않고 출력된다.
    }
    console.log(i);
}

for (let i = 1; i <= 10; i++) {
    if(i > 5 ){  //  break문을 만나면 for문을 빠져나온다. 조건을 만나면 반복문을 종료시켜 버린다. 
        break;
    }
    console.log(i)
}

for (let i = 0; i <=3; i++) {
    for (let j = 1; j <=3; j++) {
        if (j === 2) {
            continue;    //j가 2일 때 현재 반복을 건너뛰고 j의 증감식으로 간다.
        }
        console.log(`i: ${i}, j:${i}`);
    }
}

// berak를 사용한 중첩 반복문 예제
outerLoop: for (let i = 0; i <=3; i++) {
    for (let j = 1; j <=3; j++) {
        if (j === 2) {
            break outerLoop;    //j가 2일 때 현재 반복을 종료하고 i의 증감식으로 간다.
        }                       // lable(outerLoop)을 통해서 종료시킬 수도 있다. 한번 출력되고 끝나버린다. 
        console.log(`i: ${i}, j:${i}`);
    }
}

// for...of 반복문(ES6)
// 이는 배열이나 이터러블(iterable) 객체의 각 요소를 순회하는 데 사용
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];

for (const number of numbers) { // number에 순차적으로 반복해서 순회되면서 숫자가 number에 담기면서 하나씩 출력된다.
    console.log(number);
}