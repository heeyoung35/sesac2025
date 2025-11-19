package com.ohgiraffers.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 프로젝트 전체의 예외를 관리하는 클래스
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    /*@ExceptionHandler(UserNotFoundException.class)를 통해 UserNotFoundException이 발생하면
     * 이 메소드가 가로채서 처리하며 HTTP 상태 코드 404 NOT_FOUND와 함께 ErrorResponse 객체를 반환 */
    public ResponseEntity<ErrorResponse> handleUserException(UserNotFoundException e) {
        String code = "ERROR_CODE_00000";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage(); // 예외에 담긴 메시지 사용

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {
        /* @ExceptionHandler(MethodArgumentNotValidException.class)를 통해
         * @Valid 검증 실패 시 발생하는 예외를 처리 예외 객체에서 에러 메시지(getDefaultMessage())와
         * 규칙 이름(getCode())을 추출하여, 규칙 이름(NotNull, NotBlank, Size 등)에 따라
         * 에러 코드와 설명을 매핑하여 400 BAD_REQUEST와 함께 ErrorResponse를 반환*/
        String code = "";
        String description = "";
        // getDefaultMessage(): DTO에 적어둔 message가 담겨있다.
        String detail = e.getBindingResult().getFieldError().getDefaultMessage();
        // getCode() : NotNull, NotBlank 등 규칙 이름
        String binedResultCode = e.getBindingResult().getFieldError().getCode();

        switch (binedResultCode) {
            case "NotNull" :
                code = "ERROR_CODE_00001";
                description = "필수 값이 누락되었습니다."; break;
            case  "NotBlank" :
                code = "ERROR_CODE_00001";
                description = "필수 값이 공백입니다."; break;
            case  "Size" :
                code = "ERROR_CODE_00003";
                description = "글자 수를 확인해주세요"; break;
        }

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST);
    }
}
