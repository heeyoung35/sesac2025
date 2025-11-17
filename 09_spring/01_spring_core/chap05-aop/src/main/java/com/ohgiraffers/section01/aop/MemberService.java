package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service   // DAO를 호출해서 사용할 비지니스로직을 작성할 클래스
// 핵심 비지니스 로직으로 AOP가 적용될 대상
public class MemberService {

    private final MemberDAO memberDAO;

    @Autowired // new로 객체를 생성하지 않아도 생성자 주입방식으로 메서드를 호출할 수 있다.
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(Long id) {
        System.out.println(" selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
