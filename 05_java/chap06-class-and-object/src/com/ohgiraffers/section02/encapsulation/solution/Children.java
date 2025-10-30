package com.ohgiraffers.section02.encapsulation.solution;

public class Children {

    /*
    * [ 접근 제한자]
    * 클래스 혹은 클래스의 멤버에 참보 연산자로 접근할 수 있는 범위를 제한하기 위한 키워드
    *
    * (+) public : 모든 패키지에서 접근 허용
    * (#) protected: 동일 패키지에서 접근 허용 (단, 상속 관계에 있는 경우 다른 패키지에서도 접근 가능)
    * (~) default : 동일 패키지 내에서만 접근 허용 (작성하지 않는 것이 default)
    * (-) private : 해당 클래스 내부에서만 접근 허용
    *
    * 위 네가지 접근제한자는 크래스, 생성자, 클래스의 멤버(필드, 메소드)에 모두 사용 가능하다.
    * 단, 클래스 선언 시 사용하는 접근제한자는 public과 default만 사용 가능하다.
    *  */

    /* [캠슐화]
    * 유지보서성을 증가시키기 위해 필드의 직접 접근을 제한하고
    * public 메소드(getter, setter)를 이용해 접근하여 사용할 수 있도록 만든 기술이다.
    * 클래스 작성 시 특별한 목적이 아닌 이상 캡슐화가 기본 원칙으로 사용 되고 있다.
    * */

    private String name;   //  default 상태로 같은 패키지에서는 접금이 가능하다.
    private int age;
    /*
    * [Getter와 Setter 메소드]
    * Getter(접근자): 내부 필드의 값을 외부로 읽어서 (Get) 전달(반환)하는 역할을 하는 메소드
    * Setter(변경자): 외부에서 전달된 값을 받아, 내부 필드의 값을 설정(Set) 또는 변경하는 역할을 하는 메소드
    * private로 접근 제한을 둔 필드에 접근하기 위해서 Getter와 Setter는 public로 한다.
    *
    * 외부에서 이 메소드를 호출함으로써, 우리는 내부의 private 필드에
    * 안전하게 접근하여 값을 변경하거나 조회할 수 있다.
    * */

    // age를 설정하는 Setter 메소드
    public void setAge(int age) {
        if (age >= 0 ) {
            this.age = age; // this: 현재 객체 자기 자신을 가르키는 참조 변수 children을 가리키는 것이다.
        } else {
            System.out.println("나이는 음수일 수 없습니다!");
            this.age = 0; // 나이는 음수일 수 없기 때문에 0으로 초기화
        }
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

}
