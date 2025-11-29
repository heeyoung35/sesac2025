package com.ohgiraffers.jpql.section06.join;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JoinRepositoryTests {

    @Autowired
    private JoinRepository joinRepository;

    @DisplayName("내부 조인 테스트")
    // jpql에서 내부조인을 사용하면 지연로딩 현상이 나타난다. 메뉴를 조회하고 거기에 필요한 카테고리 코드가 필요할 때 다시 조회해온 것이다.
    // M+1문제라고 부른다. 쿼리가 한번에 조회가 되지 않고 메뉴 테이블 조회하고 행하나 조회하고 다음에 행 조회하고 조회할 셀렉트 구문이
    // 계속해서 날리고 있는 것이다. 이너는 메뉴도 있고 카테고리도 있는 것만 조회한다면 아웃터조인은 메인이 메뉴이면 카테고리가 없어도
    // 메뉴는 모두 조회가 되는 것이다.
    @Test
    void testSelectByInnerJoin() {
        List<Menu> menuList = joinRepository.selectByInnerJoin();
        assertNotNull(menuList);
    }

    @DisplayName("외부 조인 테스트")
    @Test
    void testSelectByOuterJoin() {
        List<Object[]> menuList = joinRepository.selectByOuterJoin();
        assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("페치 조인 테스트")
    @Test
    void testSelectByFetchJoin() {
        List<Menu> menuList = joinRepository.selectByFetchJoin();
        assertNotNull(menuList);
    }
}
