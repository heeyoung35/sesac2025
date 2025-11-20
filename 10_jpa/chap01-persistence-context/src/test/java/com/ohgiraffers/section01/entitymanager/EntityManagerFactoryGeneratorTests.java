package com.ohgiraffers.section01.entitymanager;

import com.ohgiraffers.section01.EntityManagerFactoryGenerator;
import com.ohgiraffers.section01.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFactoryGeneratorTests {

    @Test
    @DisplayName("엔티티 매지저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory(){
        // given
        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        // then
        assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance() {
        //giver
        //when
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        //then
        assertEquals(factory1, factory2);
        /* 팩토리 인스턴스를 두 번 호출했을 때 assertEquals가 통과하기 때문에
        *  같은 객체임을 확인*/


    }

    @Test
    @DisplayName("엔티티 매니저 생성확인")
    void testGeneratorEntityManager(){
        // given

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        // then
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("엔티티 매니저 스코프확인")
    void testEntityManagerLifeCycle(){
        // given

        // when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();

        // then
        assertNotEquals(entityManager1, entityManager2);
        /* 엔티티 매니저를 두 번 생성했을 때 assertNotEquals가 통과 하기 때문에
        *  서로 다른 객체임이 확인, 요청마다 새로운 매니저를 사용해야 한다는 원틱을 준수*/
    }
}
