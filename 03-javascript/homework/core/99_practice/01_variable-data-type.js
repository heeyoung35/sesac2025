// [문제 1] 변수 선언과 데이터 타입
/*
1. 이름(name), 나이(age), 주소(address)를 저장할 수 있는 변수를 선언하고 값을 할당하세요.
2. 각 변수를 콘솔에 출력하세요.
3. typeof를 이용해 데이터 타입을 확인 해보세요.
*/
const name ="강하늘";
const age = 30;
const address = "서울 동대문구 고산자로32길 78 청량리역한양수자인그라시엘 333호 ";
console.log(name);
console.log(age);
console.log(address);
console.log(typeof name);
console.log(typeof age);
console.log(typeof address);


// [문제 2] 객체 생성 및 속성 다루기
/*
1. 학생 정보를 저장하는 객체를 만드세요. 객체에는 다음 속성을 추가하세요:
   - 이름(name): 문자열
   - 학번(studentId): 숫자
   - 전공(major): 문자열
2. 객체의 각 속성 값을 콘솔에 출력하세요.
3. 새로운 속성 '학년(year)'을 추가하고 값을 할당하세요.
4. '전공(major)' 속성을 삭제하세요.
5. 최종 객체를 출력하세요.
*/
const student = {
   name : "강하늘",
   studentId : 2505039,
   major : "컴퓨터과학과",
}
console.log(student);

student.year = 3;
console.log(student);

delete student.major;
console.log(student);



// [문제 3] 배열과 배열 메소드 활용
/*
1. 좋아하는 음식 목록을 배열로 만드세요. 배열에는 최소 5개의 음식 이름이 들어가야 합니다.
2. 다음 작업을 수행하세요:
   - 배열에 새로운 음식을 추가하세요.
   - 배열의 마지막 음식을 제거하세요.
   - 배열의 첫 번째 음식을 제거하세요.
   - 배열의 첫 번째에 새로운 음식을 추가하세요.
3. 최종 배열을 콘솔에 출력하세요.
*/
const food = ['햄버거', '치킨', '샐러드', '족발', '떡볶이'];
food.push('짜장면');
console.log(food);
food.pop();
console.log(food);
food.shift();
food.unshift('피자');
console.log(food);


// [문제 4] forEach와 배열 탐색
/*
1. 숫자 배열을 만드세요. (예: [10, 20, 30, 40, 50])
2. forEach 메소드를 사용하여 각 숫자를 2배로 만들어 새로운 배열에 저장하세요.
3. 최종 배열을 콘솔에 출력하세요.

hint : 새로운 빈 배열 생성해두기
			 배열 메서드인 push()와 *(곱하기)연산자 활용
*/



// [문제 5] 객체 배열 다루기
/*
1. 3명의 학생 정보를 저장하는 객체 배열을 만드세요. 각 객체는 다음 속성을 가져야 합니다:
   - 이름(name): 문자열
   - 학년(grade): 숫자
   - 점수(score): 숫자
   
2. 다음 작업을 수행하세요:
   - 모든 학생의 정보를 콘솔에 출력하세요.(foreach 활용)
   ex) 이름: 홍길동, 학년: 1학년, 점수: 75
*/