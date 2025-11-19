package com.ohgiraffers.restapi.section03.valid;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
/* 예외 발생 시 클라이언트에게 통일된 형태로 반환할 에러 응답 형식을 정의 */

    private String code;
    private String description;
    private String detail;
}
