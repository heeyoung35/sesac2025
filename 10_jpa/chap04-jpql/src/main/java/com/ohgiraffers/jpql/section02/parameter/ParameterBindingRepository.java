package com.ohgiraffers.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBindingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectMenuByBindingName(String menuName) {
        // :menuName 매뉴 네임을 지어준 것이지 menuName을 넣어준 것은 아니다.
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                                                  .setParameter("menuName", menuName)
                                                    // setParameter에
                                                  .getResultList();
        return resultMenuList;
    }
    public List<Menu> selectMenuByBindingPosition(String menuName) {
        // 포지션(위치홀더)으로 물음표와 숫자 파라미터가 늘었을 때는 숫자를 늘려준다.
        String jpql ="SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                                                 .setParameter(1, menuName)
                                                 .getResultList();
        return resultMenuList;
    }
}
