/**
 * 프로토타입 상속의 가장 중요한 규칙 두 가지
 * 1. 읽을 때는 올라가고, 쓸 때는 내 객체에 쓴다.
 * 2. 메소드를 빌려와도, this는 내 자신을 가르킨다. 
 */

const user = {
    id: 'user',
    login: function(){
        console.log(`${this.id}님 로그인 되었습니다.`);

    }
};

const student = {
    __proto__:user   // student.__proto__ = user와 같다. 
};

// 규칙 1: '쓰기'는 프로토타입에 영향을 주지 않고, 자기 자신에게 프로퍼티를 만든다.
student.id = 'student01';

console.log('student.id', student.id);
console.log('user.id', user.id);

// 규칙2: user의 login 메소드를 빌려왔지만, this는 무조건 메소드를 호출한 '주체'가 된다. 
student.login(); // 빌려와서 사용해도 this는 메서드를 호출한 주체를 가리키게 된다. 위에서 빌려와서 사용해도 각자의 이름과 아이디를 사용하게 된다. 

