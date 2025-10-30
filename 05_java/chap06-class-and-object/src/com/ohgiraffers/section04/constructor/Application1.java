package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application1 {
    public static void main(String[] args) {

        // 기본생성자 호출 구문 생성자 함수를 호출하는 구문
        User user = new User();  // 빈객체를 만들고 하나씩 값을 넣어주었다. 객체를 만들면서 값을 넣어주는 역할이 생성자이다.
        System.out.println(user.getInformation());
        // 출력값은 null이다. User [id=null, pwdnull, namenull, enrollDatenull ]

        user.setId("user01");
        user.setPwd("pass01");
        user.setName("홍길동");
        System.out.println(user.getInformation());

        // id, pwd, name 초기화하는 생성자 호출 매개변수 있는 생성자를 호출
        User user1 = new User("user02", "pass02", "유관순");
        System.out.println(user1.getInformation());

        // 모든 필드를 초기화하는 생성자 호출
        User user2 = new User("user03", "pass03", "이순신", new Date());
        System.out.println(user2.getInformation());
    }
}
