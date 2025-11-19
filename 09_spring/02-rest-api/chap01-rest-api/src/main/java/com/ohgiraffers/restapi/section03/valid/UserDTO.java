package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
/* 유효성 검사 제약 조건을 필드에 명시한 DTO */

    private int no;

    // 필드에 유효성에 제약조건을 수행할 수 있도록 한다. 메세지도 속성으로 전해줄 수 있다.
    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;
    @NotNull(message = "비밀번호는 반드시 입력 되어야 합니다.")
    @Length(max = 10, message = "비밀번호는 길이 10을 초과할 수 없습니다.")
    private String pwd;
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    @Size(max = 10, message = "이름은 길이 10을 초과할 수 없습니다.")
    private String name;
    @Past(message = "가입일은 현재보다 과거 날짜가 입력 되어야 합니다.")
    private Date enrollDate;

    /* @NotNull: 필수 값이 누락되지 않았는지 검사
     * @NotBlank: 문자열이 null이 아니고 공백이 아닌지 검사
     * @Length(max = 10): 비밀번호 길이가 10을 초과할 수 없음을 명시
     * @Size(max = 10): 이름 길이가 10을 초과할 수 없음을 명시
     * @Past: 가입일이 현재보다 과거 날짜여야 함을 검사
     * message: 각 어노테이션에 message 속성을 통해 제약 조건 위반 시 출력할 메시지를 정의 */
}
