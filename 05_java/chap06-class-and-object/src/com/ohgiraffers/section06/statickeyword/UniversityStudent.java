package com.ohgiraffers.section06.statickeyword;

public class UniversityStudent {

    // non-static 필드 : 다른 사람과 공유하지 않는 개인사물함과 같다.
    // 인스턴스가 생성될 때마다 heap영역에 새로 만들어진다.
    private int personalLockerCount;

    // static 필드: 모두가 사용하는 공용 사물함
    // 프로그램 시작 시 static 영역에 단 하나만 생성되며, 모든 인스턴스가 공유한다.
    private static int sharedLockerCount;

    public int getPersonalLockerCount() { // 자신을 가르치는 객체이기 때문에 this
        return this.personalLockerCount;
    }

    public int getSharedLockerCount() {
        return UniversityStudent.sharedLockerCount;
    }

    public void increasePersonalLocker() {
        this.personalLockerCount++;
    }
    public void increaseSharedLocker() {
       // UniversityStudent.sharedLockerCount;
    }
}
