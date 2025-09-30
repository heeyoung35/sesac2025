// map: 배열의 모든 요소에 대해 콜백 함수을 호출하고, 그 결과를 모아 '새로운 배열'을 만든다.

const numbers = [1, 2, 3, 4, 5,];

// 각 숫자를 제곱한 새로운 배열 만들기
const squaredNumbers = numbers.map(num => num * num); // 1이라는 숫자가 들어와서 1*1, 2가 들어와서 2*2 이렇게 제곱한 값으로 새로운 배열을 만든는 것
console.log(squaredNumbers);   // 결과값 [ 1, 4, 9, 16, 25 ] 원본배열에는 영향을 주지 않고 새로운 값으로 배열을 만든다.
console.log(numbers);    // 원본 배열에는 영향을 주지 않는다. 

// 객체 배열에서 이름만 뽑아 새로운 배열 만들기
const students = [
    {name: '홍길동', score: 90},
    {name: '유관순', score: 95}
];

const studentNames = students.map(student => student.name);
console.log(studentNames);