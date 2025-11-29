package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectByInnerJoin() {
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        return menuList;
    }

    public List<Object[]> selectByOuterJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c"
                + " ORDER BY m.category.categoryCode";

        List<Object[]> menuList = entityManager.createQuery(jpql).getResultList();
        return menuList;
    }

    public List<Menu> selectByFetchJoin() {
        // Fetch 성능최적화를 위해서 지원해 주는 것으로 지연로딩일 때 즉시로딩이 가능하다.
        String jpql = "SELECT m FROM Section06Menu m Join FETCH m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        return menuList;
    }
}
