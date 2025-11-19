package com.ohgiraffers.restapi.section03.valid;

public class UserNotFoundException extends RuntimeException {
/* 특정 회우언을 찾을 수 없을 때 발생하는 사용자 정의 예외로 RuntimeException을 상속방는다. */
    public UserNotFoundException(String message) {

        super(message);
    }
}
