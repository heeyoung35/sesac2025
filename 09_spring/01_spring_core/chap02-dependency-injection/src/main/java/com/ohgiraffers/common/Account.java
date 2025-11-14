package com.ohgiraffers.common;

public interface Account {
    // 인터페이스는 추상메서드로 자동 작성된다.
    String getBalance();

    String deposit(int money);

    String withDraw(int money);
}
