package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCycleTests {

    private EntityLifeCycle lifeCycle;

    @BeforeEach
    void setUp() {
        this.lifeCycle = new EntityLifeCycle();

    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testTransient(int menuCode) {
        // when
         /* 영속성 컨텍스트에서 관린되는 영속 상태의 객체(entityManager가 find로 찾아온 객체)
         *  객체만 생성하고 아직 저장하지 않은 상태*/
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);

        // 별개의 객체 영속성 컨테스트에서 관리되지 않는다.
        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus());

        EntityManager entityManager = lifeCycle.getManagerInstance();

        // then
        assertNotEquals(foundMenu, newMenu);
        assertTrue(entityManager.contains(foundMenu));
        assertFalse(entityManager.contains(newMenu));
        /* foundMenu는 영속상태로 1차 캐시에 저장된 상태,
         * newMenu는 new 연산자를 사용해 직접 생성한 일반 객체로 내부의 데이터는 같지만
         * 메모리 상에 할당된 전혀 다른 객체로
         * 즉, 비영속 상태로 필드에 들어있는 값은 같지만 서로 다른 주소값을 가지게 된다. */
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedOtherEntityManager(int menuCode) {

        // when
       /* findMenuByMenuCode 메소드를 호출 했을 때
        * entity매니저가 새로 만들어지기 때문에 영속성 컨텍스트가 두개 만들어 진것 과 같다.
        * 즉, 객체의 동일성이 보장되지 않는다.
        * JPA가 말하는 객체 동일성 보장은 하나의 영속성 컨텍스트(하나의 트랜잭션 범위)
        * 안에서만 유효하다.
        * */

        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);

        // then
        assertNotEquals(menu1, menu2);

    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedSameEntityManager(int menuCode) {
        /* 같은 엔티티 매니저에서 같은 ID로 두 번 find를 하면,
        *  DB를 두변 조회하는 것이 아니라 1차 캐시에서 저장된 같은
        *  객체를 참조해서 반환한다. */

        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);


        // then
        assertEquals(menu1, menu2);

    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // detach : 특정 엔티티만 준영송 상태(영속성 켄텍스트가 관리하지 않는 상태)로 만든다.
        // 영속성 컨택스트가 관리하다가 분리된 상태로 데이터가 수정되어도 DB에 반영되지 않는다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        // 영속성 컨텍스트의 상태를 DB로 내보낸다. commit하지 않는 상태이므로 rollback 가능한다.
        // commit에는 내부적으로 내보내고(flush) 최종 반영하는 것이기 때문에 rollback이 불가능하다.
        entityManager.flush();

        // then
        assertNotEquals(menuPrice, entityManager.find(Menu.class,menuCode).getMenuPrice());

    }

}
