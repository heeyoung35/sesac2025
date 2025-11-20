package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/* 엔티티 매저의 생성 구조, CRUD 동작원리, 엔티티 생명주기*/
/* 1. JPA 영송성 컨텍스트 기초이론
*  - 영속성 컨텍스트: 엔티티를 영구 저장하는 환경을 의미. 엔티티 매니저를 통해 엔티티를 저장하거나
*    조회하면서 영속성 컴텍스트가 이를 보관하고 관리. 1차 캐시 역할로 key-value방식으로 엔티티를 관리
*  - 엔티티 매니저: 영속성 컨텍스트에 접근하여 엔티티의 저장, 조회, 수정, 삭제를 수행하는 관리자
*    웹 요청마다 하나씩 생성해서 사용
*  - 엔티티 매니저 팩토리: 엔티티 매니저를 생성하는 공장. 생성비용이 크기 때문에 애플리케이션 전체에서
*    하나만 생성(싱글톤)하여 공유*/

public class EntityManagerGenerator {

    public static EntityManager getInstance() {
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        return factory.createEntityManager();
        // EntityManagerFactoryGenerator.getInstance() 호출해서 싱글톤 EMF를 얻고
        // createEntityManager() 메소드를 호출해서 새로운 EntityManager 인스턴스를 생성해서 반환
        // 호출 될 때마다 새로운 인스턴스를 생성해서 독립적으로 사용되도록 보장
    }
}
