package com.ohgiraffers.section03.grammer;

public enum UserRole {
    // 1. 각 상수별로 고유한 데이터("상수에 대한 설명정의")를 정의
    GUEST("게스트"),
    CONSUMER("구매자"),
    PRODUCER("판매자"),
    ADMIN("관리자");

    // 2. 그 데이털르 지정할 필드 선언
    private final String description;

    // enum도 생성자를 가질 수 있는데 생성 규칙으로 생성자는 외부에서 new로 호출할 수 없기 때문에,
    // 접근제한자는 자동으로 private이 된다.
    // enum이 처음 호출 될 때 자바에서 딱 한번 호출된다.
    private UserRole(String description) { // 생성자 필드를 받아서 초기화
        System.out.println("UserRole 생성자 호출" + description);
        this.description = description;
    }
    // 외부에서 description 값을 가져갈 geter
    public String getDescription() {
        return this.description;
    }

    public String getNameToLowerCase() {
        return this.name().toLowerCase();
    }
}
