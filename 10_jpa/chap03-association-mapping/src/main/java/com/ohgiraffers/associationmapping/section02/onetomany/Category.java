package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "category_and_menu")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
    /* 즉시 로딩 or 지연 로딩
    *  OneToMany의 경우 기본적으로 지연로딩이지만 필요에 따라 즉시로딩으로 변경 가능하다.*/
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryCode")
   /* FK 컬럼 기재 카테고리에서 메뉴를 참조할 수 있도록 만드는 것인데
      다중성으로 조인 기준 컬럼을 작성하는데 연관관계에서 PK를 FK로 참조한다. 경우에 따라서 두개의 컬럼명이 같을 때도 있지만
      다르게 사용할 때도 있다. 같은 값이지만 의미적으로 다른 이름을 사용할 때 FK명을 사용해야 한다. */
    private List<Menu> menuList;

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}

