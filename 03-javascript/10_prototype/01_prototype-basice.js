/**
 * 자바스크립트의 모든 객체는 [[Prototype]]이라는 '연결고리'를 가지고 있다.
 * 이 연결고리는 다른 객체를 가리킬 수 있는데, 이 대상을 '프로토타입'이라고 부른다.
*/

const user ={
    actibate: true,
    login: function() {
        console.log('로그인 되었습니다.');
    }
};

const student = {
    passion: true
};

const greedyStudent = {
    actibate: false
};


// student의 프로토타입을 user로 설정합니다.
// student는 user의 기능을 빌려 쓸 수 있게 된다. 
// 원래는 각기 다른 객체이기 때문에 호출할 없는데 연결고리를 통해 가능하다. 
student.__proto__ = user;      // student가 user의 기능을 빌려쓸 수 있도록 연결해 주는 기능(.__proto__)

// greedyStudent가 student에게 연결한다. 본인에게 기능이 있는지 찾고 없으면 연결고리를 타고 student를 찾고 없으면 user에게까지 가서 찾는다. 
greedyStudent.__proto__ = student;  // chain으로 연결해서 user까지 연결하도록 한다. 


// student 객체에 ativate 프로퍼티가 없으면, 연결된 user에서 찾아본다.
console.log(student.actibate);   // user에 설정한 true가 출력된다. (상속의 개념)

student.login();
greedyStudent.login();

console.log()

