package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

//    @Query("SELECT c FROM Category c ORDER BY c.categoryCode")
//    @Query( value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code",
//                     nativeQuery = true)
    @NativeQuery("SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code")
    // 쿼리 어노테이션을 달면 제이피큐엘을 사용한다고 생각하기 때문에 네이티브 에스큐엘은 속성을 추가해주어야 한다.
    List<Category> findAllCategory();
}
