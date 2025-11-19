package com.ohgiraffers.restapi.section01.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
//Lombok 어노테이션을 사용하면 반복적인 getter,setter, 생성자 코드를 직접 작성하지 않아도 된다.
@Getter
@ToString
@AllArgsConstructor  // 모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor  // 기본생성자
public class Message {
// 기본적인 HTTP 응답 메시지 구조를 정의하는 DTO
    private int httpStatusCode;  // HTTP 상태 코드를 저장(예: 200, 404등)
    private String message;  // 응답 메시지 저장


}
