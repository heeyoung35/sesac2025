package com.ohgiraffers.section03.dto;

public class Application {
    public static void main(String[] args) {

        // 비어있는 데이터 상자를 하나 생성한다.
        MemberDTO member = new MemberDTO();

        // setter를 이용하여 데이터를 담는다.
        member.setNumber(1);
        member.setName("홍길동");
        member.setAge(20);
        member.setGender('남');
        member.setWeight(180);
        member.setHeight(60);
        member.setActivated(true);

        System.out.println(member.getAge());
        System.out.println(member.getName());

    }
}
