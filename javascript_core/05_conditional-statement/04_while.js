/**
 * 반복문: while
 * 조건이 참인 동안 코드를 반복 실행한다.
 */

let count = 3; // 변수를 선언하고 할당

while (count > 0) {
    console.log(`카운트다운: ${count}`);
    count--;
}

/**
 * 반복문: do-while
 * 최소 한 번 실행한 후 조건을 검사합니다.
 * do {
 *     // 조건에 상관없이 처음 실행할 구문(무조건 실행)
 * } while(조건) 그리고 조건에 맞으면 실행
 */

let number = 1;

do {
    console.log(`숫자: ${number}`); // number가 5일때에도 조건에 상관없이 실행하기 때문에 숫자: 5 출력
    number++;
} while (number <= 3); // number가 1일 때는 조건과 비교해서 조건에 맞을 때까지 실행