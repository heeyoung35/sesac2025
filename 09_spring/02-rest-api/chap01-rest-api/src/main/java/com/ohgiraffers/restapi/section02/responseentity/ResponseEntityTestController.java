package com.ohgiraffers.restapi.section02.responseentity;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {
    // ResponseEntity객체를 사용하여 CRUD 작업을 처리하는 컨트롤러

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "고릴라", new Date(), "active"));
        users.add(new UserDTO(2, "user02", "pass02", "호랑이", new Date(), "active"));
        users.add(new UserDTO(3, "user03", "pass03", "원숭이", new Date(), "inactive"));
    }

    // 전체 회원 조회
//    @GetMapping("/users")
//    public ResponseEntity<ResponseMessage> findAllUsers() {
//        // 응답헤더
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
//        // 응답 바디(본문)
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("users", users);
//        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
//
//        // ResponseEntity 객체 생성
//        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
//    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findUserByConditions(@RequestParam String name, @RequestParam String status) {
    /* findUserByConditions : @RequestParam을 이용해 name과 status 조건에 따라 필터링된 사용자 목록 조회 후
     * 결과를 ResponseMessage 객체에 담아 ResponseEntity.ok().headers(headers).body(responseMessage) 반환을 하는데
     * 반환 형태가 빌더패턴으로 메소드 체이닝으로 객체 생성 단계를 여러 메소드 호출로 분리하고,
     * 각 메소드가 객체 자신 또는 다음 단계의 빌더 객체를 반환하여 연속적으로 메소들 호출하도록 함  */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<UserDTO> foundUsers = users.stream()
                .filter(user -> {
                    if(status != null && !user.getStatus().equals(status)){
                        return false;
                    }
                    if (name !=null && !user.getName().contains(name)){
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());

                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("user", foundUsers);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }

    // 특정 번호의 회원 조회
    // {}들어오는 숫자를 변수로 받겠다는 뜻
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
    /* @PathVariable을 사용해 URL 경로의 변소(userNo)를 받고 조회된
     * 사용자 정보를 ResponseMessage에 담아 ResponseEntity  반환*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO founUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", founUser);    // JSON 변환 -> "user": {...}

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // 빌더 패턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }

    @PostMapping("/users")
    // T가 Void라는 것은 응답 body가 없다는 의미이다.
    // @RequestBody : 클라이언트가 보낸 JSON 데이터를 USerDTO 객체로 변환한다.
    // {"name":"홍길동", "age":30} -> newUSer.name = "홍길동", nseUser.age = 30
    public ResponseEntity<Void> registUser(@RequestBody UserDTO newUser) {
    /* @RequestBody로 클라이언트가 보낸 JSON 데이터를 UserDTO 객체로 변환 후
     * ResponseEntity.created(URI.create(...)).build()를 사용하여
     * 201 Created 상태 코드와 함께 새로 생성된 리소스의 URI를 반환합니다. Void 타입은 응답 body가 없음을 의미
     * .created(URI) 빌더 메소드는 내부적으로 HTTP 상태 코드를 201 CREATED로 설정*/

        // users 리스트의 마지막 사용자의 번호를 가져온다.
        int lastUserNo = users.get(users.size() -1).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
                .created(URI.create("/entity/users/" + newUser.getNo()))
                .build();  // 바디가 없는 응답을 만들 때 사용
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO modifyInfo) {
    /* @PutMapping을 사용하며, 수정 후 ResponseEntity.created(...)로 응답 */

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

    @DeleteMapping("users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo) {
    /* @DeleteMapping을 사용하며, 삭제 후 ResponseEntity.noContent().build()를 사용하여
     * 204 No Content 상태 코드를 반환 (성공했지만 컨텐츠가 없음을 의미) */

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()  // 성공했지만 컨텐츠 없음을 의미하는 HTTP 상태코드 204 No Content 반환
                .build();
    }

}
