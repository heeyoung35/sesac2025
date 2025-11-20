package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴 조회*/
    /* PK를 이용해 단건 조회를 수행. 영속성 컨텍스트(1차캐시)에 없으면 DB애
    *  select 쿼리를 날리고 결과를 영속성 컨텍스트에 저장한 뒤 반환 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        // 엔티티매니저야 메뉴에서 피케이가 메뉴코드인 것을 찾아줘!
        // sql구문으로 꺼내와서 매핑해야 하는 것을 엔티티매니저가 다 해주는 것이다.
        return entityManager.find(Menu.class, menuCode);
    }

    /* 새로운 메뉴 저장하는 기능*/
    public Long saveAndReturnAllCount(Menu newMenu) {
        entityManager = EntityManagerGenerator.getInstance();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        // persist(): 엔티티를 영속성 컨텍스트에 저장
        entityManager.persist(newMenu);
        // commit(): 트렌젝션이 커밋되는 순간 영속성 컨텍스트에 쌓인 쿼리가 DB로 전송(flush)되어 실제 저장
        entityTransaction.commit();

        return getCount(entityManager);

    }
    /* 메뉴 개수 조회하는 기능*/
    private Long getCount(EntityManager entityManager) {
        // JPQL 문법을 이용 테이블명 대신에 엔티티 이름을 넣어준다.
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 메뉴 이름 수정하는 기능 */
    /* Dirty Checking: 별도의 update()메소드가 없음. 영속 상태의 엔티티 값을 변경(setter)하면,
    *  트랜잭션 커밋 시점에 JPA가 변경 사항을 감지하여 자동으로 update쿼리를 실행 */
    public Menu modifyMenuName(int menuCode, String menuName) {

        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(menuName); // setter로 값 변경

        transaction.commit();

        return foundMenu;
    }

    /* 특정 메뉴 코드로 메뉴 삭제 하는 기능*/
    public Long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(foundMenu);

        entityTransaction.commit();
        // 커밋 시점에 delete 쿼리가 나간다.

        return getCount(entityManager);
    }

}
