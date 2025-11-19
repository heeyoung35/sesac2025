package com.ohgiraffers.restapi.section04.hateoas;


import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/hateoas")
public class HateoasTestController {
    /* HATEOAS를 적용하여 응답에 관련 리소스의 링크 정보를 포함하는 컨트롤러
     * HATEOAS는 RESTful 서비스의 성숙도 모델 중 하나로,
     * 응답에 해당 리소스와 관련된 다른 리소스에 대한 링크를 제공하여 클라이언트가 API 문서를 참조하지 않고도
     * 애플리케이션 상태 전이를 할 수 있게 돕는 원칙
     * 클라이언트가 서버와 상호작용할 때,
     * 서버의 응답에 데이터뿐만 아니라 해당 리소스와 관련하여 다음에 가능한 행동(다음 상태로의 전이)을 나타내는 하이퍼미디어 링크를 포함해야 한다
     * 이는 서버와 클라이언트 간의 종속성을 줄여주며, 시스템의 독립적인 진화를 가능*/

    private List<UserDTO> users;

    public HateoasTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "고릴라", new Date()));
        users.add(new UserDTO(2, "user02", "pass02", "호랑이", new Date()));
        users.add(new UserDTO(3, "user03", "pass03", "원숭이", new Date()));
    }

    // 전체 회원 조회
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        // 응답헤더
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        /* HATEOAS 적용*/
        // 1. EntityModel : 기존 DTO(UserDTO)를 감싸서 링크 정보를 추가할 수 있게 해주는 Spring HATEOAS의 클래스
        List<EntityModel<UserDTO>> userWithRel = users.stream()
                .map(user -> {
                    return EntityModel.of(
                            user, // 실제 데이터
                            // HateoasTestController의 findUserByNo(user.getNo()) 메소드를 가르키는 링크를 만든다.
                            linkTo(methodOn(HateoasTestController.class).findUserByNo(user.getNo())).withSelfRel(),
                            // 현재 리소스(개별 사용자)를 조회하는 링크를 self 관계로 추가
                            linkTo(methodOn(HateoasTestController.class).findAllUsers()).withRel("users")
                            // 전체 사용자 목록을 조회하는 링크를 users 관계로 추가

                    );
                }).toList();

        // 응답 바디(본문)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", userWithRel); // 링크가 포함된 리스트로 교체
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
        // 응답 바디에는 기존 사용자 목록 대신 링크가 포함된 EntityModel 리스트가 담겨 클라이언트에 전송

        // ResponseEntity 객체 생성
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);     // JSON 변환 -> "user": {...}

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // 빌더 패턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }

}
