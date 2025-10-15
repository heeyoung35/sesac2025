const studentHQ = {
    activate: true,
    login: function() {
        console.log(`${this.name}님 로그인 되었습니다.`);
    }
};

function Student(name) {
    this.name = name;
}

// 생성자 함수로 새로 만들어질 객체들이 바라볼 프로토타입 객체를 지정
Student.prototype = studentHQ  // 생성자 함수에 프로토타입으로 studentHQ에 연결해준다. 
// 생성자 함수에서 만들어진 학생객체가 프로토타입을 통해 studentHQ연결되도록 해서 login도 사용하게 되는 것

// new 연산자를 사용해 만든 객체는
// 생성자 함수의 프로토타입 정보를 사용해[[Prototype]]을 설정한다.
// student1.__proto__== studentHQ
const student1 = new Student('판다');
const student2 = new Student('코알라');

student1.login();
student2.login();