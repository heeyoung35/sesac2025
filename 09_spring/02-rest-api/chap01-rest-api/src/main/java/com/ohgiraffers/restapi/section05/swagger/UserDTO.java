package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Schema(description = "회원정보 DTO")
// Swagger 문서에서 해당 클래스나 필드에 대한 설명을 추가하여 API가 주고받는 것을 확인할 수 있도록 합니다.
public class UserDTO {
    // API가 주고받는 것을 확인할 수 있다.
    @Schema(description = "회원번호(PK)")
    private int no;
    @Schema(description = "회원ID")
    private String id;
    @Schema(description = "회원비밀번호)")
    private String pwd;
    @Schema(description = "회원이름")
    private String name;
    @Schema(description = "회원등록일")
    private Date enrollDate;

}
