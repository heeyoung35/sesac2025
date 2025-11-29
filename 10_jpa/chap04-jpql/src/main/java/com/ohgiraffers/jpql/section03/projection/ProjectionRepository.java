package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> singleEntityProjection() {
        String jpql = "SELECT m FROM Section03Menu m";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    public List<Object[]> scalarTypeProjection() {
        String jpql = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    public List<CategoryInfo> newCommandProjection() {
        /* JPA에서는 JPQL의 new 명령어를 사용하여 쿼리 겨로가를 특정 클래스(DTO)의 생성자로 바로
        *  매핑할 수 있다. 이 방색을 생성자 표현식 이라고 한다. */

        String jpql = "SELECT new com.ohgiraffers.jpql.section03.projection.CategoryInfo(c.categoryCode, c.categoryName) "
                + "FROM Section03Category c";   // 일반클래스 타입에다 매핑해주고 있다.
        return entityManager.createQuery(jpql, CategoryInfo.class).getResultList();
    }

}
