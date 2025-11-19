package com.ohgiraffers.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 이 파일은 다양한 형태의 HTTP응답(Response)를 반환하는 방법을 보여주는 REST 컨트롤러
@RestController
// 데이터만 응답하는 클래스임을 지정하는 것으로 이 어노테이션을 붙이면 클래스 내의 모든 메소드는 뷰를 반환하는 대신
// String, JSON, XML 등의 데이터를 직접 반환하게 한다.
@RequestMapping("/response") //
// 이 클래스의 모든 메소드가 처리할 요청 URL 앞에 공통적으로 붙는 경로 설정
public class ResponseRestController {
    // /'response/hello' 주소로 GET 요청이 오면 이 메소드 실행

    // 문자열 응답
    @GetMapping("/hello") // get, post 사용자가 요청을 보낼 때 이러한 요청에 대해서 이것을 보내겠습니다.
    public String helloWorld() {
        return "Hello World";
    }

    // 기본 자료형 응답
    @GetMapping("/random")
    public int getRandomNumber() {
        return (int)(Math.random() *10) +1;
    }

    // Object 응답
    // getMessage(): 사용자 정의 객체응답을 반환하면, spring이 이를 json으로 변환하여 응답
    @GetMapping("/message")
    public Message getMessage() {
    return new Message (200, "메세지를 응답합니다");
    }

    // List 응답
    // List 형태의 데이터를 json배열로 변환하여 반환
    @GetMapping("/list")
    public List<String> getList() {
        return List.of(new String[]{"사과", "바나나", "복숭아"}); //JSON 배열로 변환
    }

    // Map 응답
    @GetMapping("/map")
    public Map<Integer, String> getMap() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "서버 에러! 개발자의 잘못입니다."));

        return messageList.stream().collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
        // message객체 리스트를 스트림을 사용해 Map으로 변환하며, getHttpStatusCode를 key로, getMessage를 value로 사용
    }

    // 파일 응답
    /* classpath는 resources 폴더를 의미하며, getClass().getResourceAsStream(...)를 통해
    * resources/images/strawberry.jpg 파일을 바이트 스트림으로 읽어와 byte[] (바이트 배열) 형태로 반환*/
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    // produces = MediaType.IMAGE_JPEG_VALUE의 응답을 Content-Type을 'image/jpeg'로 설정하여,
    // 브라우저가 이 응답을 이미지로 해석
    public byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/images/strawberry.jpg").readAllBytes();
    }

    // ResponseEntity 응답
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {
        return ResponseEntity.ok(new Message(123,"hello world!"));
        /*ResponseEntity는 HTTP 응답의 상태 코드, 헤더, 그리고 본문(body)을 직접 제어할 수 있게 해주는 강력한 객체
        * ResponseEntity.ok(...)는 HTTP 상태 코드를 200(OK)으로 설정하고, 괄호 안의 Message 객체를 본문으로 설정하여 반환
        *  */
    }

}
