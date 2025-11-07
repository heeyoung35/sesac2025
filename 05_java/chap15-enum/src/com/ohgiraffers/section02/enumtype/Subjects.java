package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    // 작성한 순서대로 0부터 값이 자동 부여된다. 정수 상수로 했을 때의 문제점을 다 해결할 뿐만 아니라 타입안정성이 있다.
    // 하나하나의 고유한 객체로 생성되어 관리되기 때문에 안전하고 toString()등 편의사항으로 반환받아 볼 수 있다.
    // 가독성과 유지보수가 용이히다. 상수가 살아있는 객체라면 자신만의 필드와 메서드를 가질 수 있다.
    JABA,
    MYSQL,
    HTML,
    JDBC,
    CSS,
    JAVASCRIPT
}
