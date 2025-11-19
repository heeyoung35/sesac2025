package com.ohgiraffers.restapi.section02.responseentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    // 표준화된 API 응답 형식을 정의하는 DTO 클래스

    private int httpStatus;  // HTTP 상태 코드
    private String message;  // 응답 메시지
    private Map<String, Object> results;   //실제 데이터는 여기에 담을거다.
    // results 맵에 users란느 키로 사용자 목록을 담거나, user라는 키로 사용자 한 명의
    // 정보를 담는 등 유연하게 데이터를 추가할 수 있다.
}
