package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*JpaRepository: 상속구조에 의해서 Repository를 상속받아서 인터페이스를 통해서 메소드가 정의되어 있어서
* 간편하게 많은 기능을 사용할 수 있다. 제네릭으로 <엔티티 클래스, PK의 타입> 작성해준다. */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* 파라미터로 전달 받은 가격을 초과 하는 메뉴 목록 조회 */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    /* 가격 기준 내림차순 정렬까지 포함*/
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPriceDesc(Integer menuPrice);

    /* 전달 받은 정렬 기준으로 조회 */
     Page<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Pageable pageable);
}
