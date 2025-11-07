package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
    /*UserRle 타입의 변수를 만들기만 해도, 클래스가 로드되면서 UserRole의 모든 상수가 인스턴스화 된다. (생성자 호출) */
        // 상수에 대한 생성자가 한번에 다 호출이 된다. 클래스가 로드될 때 생성자가 모두 호출된다.
        UserRole admin = UserRole.ADMIN;

        // 다시 만들어도 싱글톤 객체이기 때문에 만들어진 것으로 재사용될 뿐 다시 호출되지 않는다.
        // 인스턴스가 위에서 이미 생성되었기 때문에 생성자가 다시 호출되지 않는다. -> 싱글톤
        UserRole guest = UserRole.GUEST;

        System.out.println("역할 : " + admin.name());
        System.out.println("설명 : " + admin.getDescription());
        System.out.println("영문 소문자 : " + admin.getNameToLowerCase());
        /* 출력값
        역할 : ADMIN
        설명 : 관리자
        영문 소문자 : admin
        */

        // 싱글톤이기 때문에 객체를 하나만 만들고 재사용하기 때문에 메모리상에 완전 동이한 객첼르 가리키고 있다.
        // 싱글톤이기 때문에 이미 생성된 인스턴스를 재사용한다. '==' 비교에서 true가 나온다!!
        UserRole admin2 = UserRole.ADMIN;
        // 주소값 비교
        System.out.println("admin == admin2 : " + (admin == admin2));  // 출력값 admin == admin2 : true

        // enum만을 위한 빠르고 효율적인, EnumSet
        // 1. allOf() : 모든 상수 가져오기
        EnumSet<UserRole> allRoles = EnumSet.allOf(UserRole.class);
        printEnumSet(allRoles);

        // 2. of() : 특정 상수만 골라 담기
        // 권한 관리에 유용
        EnumSet<UserRole> userRoles = EnumSet.of(UserRole.CONSUMER, UserRole.PRODUCER);
        printEnumSet(userRoles);

        // 3. complementOf() : 특정 상수만 제외하고 담기 (여집합)
        // EnumSet.of를 만들어 준 형태를 전달해서 complementOf(EnumSet<E> s)
        EnumSet<UserRole> memberRoles = EnumSet.complementOf(EnumSet.of(UserRole.GUEST));

    }
    // EnumSet의 내용을 보기 좋게 펼쳐보기 위해서 출력하기 위한 헬퍼 메소드
    public static void printEnumSet(EnumSet<UserRole> enumSet) {
        Iterator<UserRole> iter = enumSet.iterator();  // 반복자를 이용해서 받아온다. Set은 중복불가하고 순서가 없다.
        while (iter.hasNext()) {
            UserRole role = iter.next();
            System.out.println(role.name() + "(" + role.getDescription() +")");
        }
        System.out.println();
    }
}
