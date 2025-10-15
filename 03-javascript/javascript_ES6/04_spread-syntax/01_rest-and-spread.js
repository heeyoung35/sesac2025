/**
 * [Rest 파라미터와 스프레드 문법]
 * 똑같이 점 세 개(...)를 사용하지만, 쓰이는 위치에 따라 정반대의 역할을 한다.
 * - Rest(나머지) Parameter: 여러 개의 값을 하나의 배열로 '모으기'
 * - Spread(펼치기) Syntax: 하나의 배열을 여러 개의 값으로 '펼치기'
 */


/**
 * [Rest Parameter]
 * 함수의 '매개변수' 자리에 사용하여, 정해지지 않은 개수으 인수들을
 * 하나의 '배열'로 모아서 받습니다.
 */
// Rest 파라미터는 반드시 매개변수 목록의 가장 마지막에 위치해야 한다. 
function merge(first, ...args) {
    // ...을 붙이는 경우 정해지지 않는 파라미터의 경우 나머지에 모두 배열로 호출된다.
    // 나머지 :  [ '반갑습니다.', '저는 판다입니다.' ] 출력
    console.log(`첫 번재: ${first}`);
    console.log(`나머지 : `, args);

    let message = first;
    for (let arg of args) {
        message += arg;
    }
    return message;
}

merge('안녕하세요', '반갑습니다.');
merge('안녕하세요', '반갑습니다.', '저는 판다입니다.');  
console.log(merge('안녕하세요', ' 반갑습니다.', '저는 판다입니다.'));

/**
 * [Spread Syntax]
 * 함수의 '인수' 자리나, 배열/객체 리터럴 안에서 사용하여
 * 배열의 요소들을 개별 값의 목록으로 펼쳐준다. 
 */

// 1. 함수 인자로 사용하기
const numbers = [10, 20, 30];
// Math.max는 낱개의 숫자들을 인수로 받는다. Math.max(10, 20, 30)
// console.log(Math.max(numbers));  배열의 가장 큰 수를 받고 싶어서 배열 통째로 담으면 NaN 출력

// ...numbers는 [10, 20, 30]을 10, 20, 30으로 펼쳐준다.
console.log(Math.max(...numbers)); 

// 2. 배열 리터럴에서 사용하기 (배열 합치기/복사)
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const mergedArray = [...arr1, ...arr2];
console.log('병합된 배열', mergedArray);

// 배열 '얕은 복사'(값만 복사)
// 변수는 주소 값을 담는 것인데 그렇기 때문에 고유의 주소값이 있는데 얕은 복사는 값만 복사하고 주소값은 새로 생성한다. 
const arr1Copy = [...arr1] // [1, 2, 3] 배열이 펼쳐져서 배앨 리터럴안에 들어가는 모습이다. 
console.log('원본 배열', arr1);
console.log('복사된 배열', arr1Copy);
console.log('두 배열이 같은가?', arr1 === arr1Copy); // 얕은 복사의 경우 값과 타입을 비교하면 flase가 출력

arr1Copy.push(4); // 복사본을 변경해도 원본은 바뀌지 않는다. 
console.log('원본 배열', arr1);
console.log('복사된 배열', arr1Copy);

// 3. 객체 리터럴에서 사용하기 (객체 합치기/복사)
const obj1 = {name:'홍길동', age:20};
const obj2 = {job:'개발자'};

const mergedObject = {...obj1, ...obj2, location: '서울'};
console.log('병합된 객체:', mergedObject);

// 객체 '얕은 복사'
const obj1Copy = {...obj1};
obj1Copy.age = 30; // 복사본을 변경해도
console.log(obj1); // 원본은 바뀌지 않음



