package com.ohgiraffers.restapi.section02.responseentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
/* 사용자의 데이터를 표현하는 객체로 API 요청시 JSON 데이터를 이 객체로 변환하거나,
*  DB에서 조회한 사용자 정보를 이 객체에 담아 JSON으로 응답하는 데 사용*/
    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate;
    private String status; // 사용자 상태 필드 (예: "active, inactive)
}
