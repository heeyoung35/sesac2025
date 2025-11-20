package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;

public class EntityLifeCycle {
    /* 엔티티는 비영속, 영속, 준영속, 삭제 4가지의 상태를 가진다.*/

    private EntityManager entityManager;

    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        return entityManager.find(Menu.class, menuCode);

    }

    public EntityManager getManagerInstance() {
        return entityManager;
    }
}
