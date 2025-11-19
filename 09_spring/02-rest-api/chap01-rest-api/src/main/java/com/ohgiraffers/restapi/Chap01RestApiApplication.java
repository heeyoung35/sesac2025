package com.ohgiraffers.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// componentScan, EnableAutoConfiguration등 클래스 자체가 프로젝트의 설정정보를 담고 있는 것이 합쳐져 있는 어노테이션
// 필요한 컴포넌트를 찾아서 조립도 해주고 API 요청을 다 받을 준비를 한다.
@SpringBootApplication
public class Chap01RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap01RestApiApplication.class, args);
    }

    /* 브라우저(React 앱): 데이터를 요청하는 클라이언트
    *  서버: 데이터를 가지고 있고, 요청을 처리하는 곳
    *  HTTP: 브라우저와 서버 사이를 오가면 요청을 받고 데이터를 전달하는 규칙(통신규약)
    *  - 요청(Request)과 응답(Response)을 한다.
    *  - GET: 데이터 요청
    *  - POST: 데이터 생성
    *  - PUT/ PATCH: 데이터 수정
    *  - DELETE: 데이터 삭제
    *  JSON: 브라우저와 서버가 서로 알아볼 수 있도록 약속된 언어/데이터 형식 */
    /* React가 화면을 그리기 위해서는 데이터가 필요
    *  1. React는 fetch나 Axios를 사용해 HTTP GET 요청을 서버에 보낸다
    *  2. 서버는 요청을 받고, 데이터베이스에서 데이터를 꺼내 JSON형식으로 포장
    *  3, 서버는 HTTP응답에 JSON 데이터를 담아 React에게 돌려준다.
    *  4, React는 JSON데이터를 JavaScript 객체로 변환하여 useState에 저장
    *  5, State가 변경되면 React가 자동으로 화면을 다시 렌더링하여 사용자에게 최신 데이터를 보여준다.*/




}
