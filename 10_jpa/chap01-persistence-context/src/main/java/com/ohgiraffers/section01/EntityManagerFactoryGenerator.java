package com.ohgiraffers.section01;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryGenerator {

    private static EntityManagerFactory factory
            // static으로 클래스가 로드될 때 EntityManagerFactory를 한 번만 생성하고 초기화
            = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerFactoryGenerator() {} // 외부에서 new연산자 사용 방지

    public static EntityManagerFactory getInstance() {

        return factory;  // 생성된 싱글톤 인스턴스 반환
    }
}
