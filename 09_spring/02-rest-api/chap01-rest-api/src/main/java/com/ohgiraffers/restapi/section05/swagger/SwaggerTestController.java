package com.ohgiraffers.restapi.section05.swagger;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
@Tag(name = "user 관련 api")
// 컨트롤러를 하나의 API 그룹으로 묶어 문서화
@RestController
@RequestMapping("/swagger")
public class SwaggerTestController {
    private List<UserDTO> users;

    public SwaggerTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "고릴라", new Date()));
        users.add(new UserDTO(2, "user02", "pass02", "호랑이", new Date()));
        users.add(new UserDTO(3, "user03", "pass03", "원숭이", new Date()));
    }

    // 전체 회원 조회
    @Operation(summary = "전체회원조회", description = "전체 회원을 조회한다.")
    // 각 HTTP 메소드에 대한 간략한 요약과 자세한 설명을 추가하여 API 문서에 표시되도록 한다.
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        // 응답헤더
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        // 응답 바디(본문)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // ResponseEntity 객체 생성
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

//    @GetMapping("/users")
//    public ResponseEntity<ResponseMessage> findUserByConditions(@RequestParam String name, @RequestParam String status) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
//
//        List<UserDTO> foundUsers = users.stream()
//                .filter(user -> {
//                    if(status != null && !user.getStatus().equals(status)){
//                        return false;
//                    }
//                    if (name !=null && !user.getName().contains(name)){
//                        return false;
//                    }
//                    return true;
//                }).collect(Collectors.toList());
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("user", foundUsers);
//        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .body(responseMessage);
//    }

    /* 특정 번호의 회원 조회 */
    @Operation(summary = "회원 번호로 회원 조회", description = "회원 번호를 통해 해당하는 회원 정보를 조회한다.")
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

    @Operation(summary = "신규 회원 등록")
    @PostMapping("/users")
    // T가 Void라는 것은 응답 body가 없다는 의미이다.
    // @RequestBody : 클라이언트가 보낸 JSON 데이터를 UserDTO 객체로 변환한다.
    // {"name":"홍길동", "age":30} -> newUser.name = "홍길동, newUser.age=30
    public ResponseEntity<Void> registUser(@RequestBody UserDTO newUser) {

        // users 리스트의 마지막 사용자의 번호를 가져온다.
        int lastUserNo = users.get(users.size() - 1).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
                .created(URI.create("/entity/users/" + newUser.getNo()))
                .build();   // 바디가 없는 응답을 만들 때 사용
    }
    @Operation(summary = "회원 정보 수정")
    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO modifyInfo) {

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }

    @Operation(summary = "회원 정보 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "회원 정보 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
    })
    @DeleteMapping("users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo) {

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()    // 성공했지만 컨텐츠 없음을 의미하는 HTTP 상태코드 204 No Content 반환
                .build();
    }
}
