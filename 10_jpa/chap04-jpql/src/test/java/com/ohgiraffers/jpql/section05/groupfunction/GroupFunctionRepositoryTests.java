package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@SpringBootTest
public class GroupFunctionRepositoryTests {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 등록 된 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        int categoryCode = 4;
        long countOfMenu = groupFunctionRepository.countMenuOfCategory(categoryCode);
        assertTrue(countOfMenu >= 0);
        System.out.println("countOfMenu :" + countOfMenu);
    }

    @DisplayName("COUNT외 다른 그룹함수 조회 결과가 없는 경우")
    @Test
    void testOtherWithNoResult() {
        int categoryCode = 777;
        // 그룹함수 유의점.
        // 결과값이 없을 때 count 함수는 는0, sum, ava는 .NullPointerException으로 프로그램이 종료된다.
        // 기본자료형에는 null값을 취급할 수 없기 때문에 래퍼자료형으로 사용하기 때문에 동일하게 적용할 수 있다.

        assertDoesNotThrow(
                () -> {
                    Long sumOfMenu = groupFunctionRepository.otherWithNoResult(categoryCode);
                    System.out.println(sumOfMenu);
                }
        );
    }

    @DisplayName("HAVING절 조회 테스트")
    @Test
    void testSelectByHaving() {
        /*그룹 함수의 반환 자료형은 Long 또는 Double 형이기 때문에 Having 절에서 그룹 함수 결과값과 비교하기 위
        한 파라미터 타입은 Long or Double로 해야했는데 개선이 되었다. */
//      int minPrice = 50000;
        Long minPrice = 50000L;
        List<Object[]> sumPriceOfCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);
        assertNotNull(sumPriceOfCategoryList);
    }
}
