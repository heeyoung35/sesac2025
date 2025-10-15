/**
 * [구조 분해 할당]
 * 배열이나 객체의 속성을 분해하여 그 값을 개별 변수에 쉽게 담을 수 있게 하는
 * ES6의 강력하고 간결한 문법이다. 
 */

/**
 * [배열 구조 분해 할당]
 * 배열은 '순서'가 중요하다. 왼쪽의 변수 자리에 따라 순서대로 값이 할당된다.
 */
const nameArr = ['Panda', 'Kwon'];
// 기존에는 배열에 접근할 때는 인덱스로 접근
// const firstName = nameArr[0]; 
// const lastName = nameArr[1]; 

// 구조 분해 할당 방식은 내가 넣고자 하는 값을 할당받을 변수에 순서대로 대괄호를 사용해서 넣어준다.
const [firstName, lastName] = nameArr;
console.log(lastName, firstName);

// 쉼표를 사용해 특정 요소를 건너 뛸 수 있다. 
const [, , title] = ['Mr', 'Gildong', 'Hong'];
console.log(title);  // 출력값 Hong

// rest 파라미터(...)로 나머지 요소들을 새로운 배열로 모을 수 잇다.
const [leader, ...members] = ['팀장', '팀원1', '팀원2', '팀원3']; 
console.log(leader);  // 출력값 팀장
console.log(members); // 출력값 [ '팀원1', '팀원2', '팀원3' ]

// 기본값(=) 설정: 할당할 값이 없을 때 사용될 기본값을 지정한다. 
const [user1, user2 = '기본값'] = ['사용자'];
console.log(user1); // 출력값 사용자
console.log(user2); // 출력값 기본값 지정한 기본 값으로 설정

/**
 * [객체 구조 분해 할당]
 * 객체는 '키(key) 이름'이 중요하다. 변수 이름과 같은 키를 찾아 값이 할당된다.
 */

const student = {
    name: '유관순',
    age: 16,
    major: '독립운동'
}

// 기존 방식
// const name = student.name;
// const age = student.age;

// 구조 분해 할당 방식
const {name, age} = student; // 변수 이름과 값은 키값을 찾아서 할당한다.
console.log(`이름: ${name}, 나이: ${age}`);

// 순서를 바꿔도 키 이름이 같으면 정확히 찾아간다.
// 콜론(:)을 사용하면 새 변수명으로 할당 할 수 있다.
const {major, name: studentName} = student; // 다른 변수명을 사용하고 싶을 때 콜론 뒤에 다른 변수명을 작성해준다.
console.log(major, studentName);

// rest 파라미터(...)로 나머지 프로퍼티들을 새로운 객체로 모을 수 있다. 
const { age: studentAge, ...restInfo} = student;
console.log(restInfo);

/**
 * 함수에 객체를 인자로 전달할 때, 구조 분해 할당을 사용하면
 * 매개변수의 순서를 신경 쓸 필요 없고, 가독성도 높아진다.
 */

const product = {
    id: 'p-001',
    name: '노트북',
    price: 1700000,
    spece: {
        cpu: 'i7',
        ram: '16GB'
    }
};

// 매개변수에서 바로 구조분해 할당을 한 것 {name, price, spece: {ram}, producer = '삼성'}
function printProductInfo({name, price, spece: {ram}, producer = '삼성'}){
    console.log(name);
    console.log(price);
    console.log(ram);
    console.log(producer); // 전달된 객체에 없으므로 기본값 사용
}
// 그래서 함수 호출을 할 때는 product라는 객체만 넣어주면 바로바로 할당이 된다.
// 함수를 호출할 때 객체 하나만 전달하면 된다. 
printProductInfo(product);
