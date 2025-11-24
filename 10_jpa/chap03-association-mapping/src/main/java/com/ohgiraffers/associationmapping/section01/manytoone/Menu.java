package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;

/* 다대일 연관관계
* @ManyToOne 다대일 관계를 정의하는 어노테이션
* @JoinColumn(name = "categoryCode") 외래키를 매핑할 때 사용하며, Menu 테이블이 category테이블 참조
* 외래 키를 가지고 있는 Menu 엔티티가 연관관계의 주인 */
@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    /* cascade(영속성 전이)
    *  특정 엔티티를 영속화 할 때 영관 된 엔티티도 함께 영송화 한다(PERSIST)
    *
    *  fetch(즉시로딩 or 지연로딩)
    *  ManyToOne의 경우 기본적으로 즉시로딩(EAGER)되지만 필요에 따라 지연로딩(LAZY)으로 변경할 수 있다. */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    /* fetch = FetchType.LAZY 지연로딩 설정은 Menu를 조회할 때 Category정보를 당장 가져오지 않고 실제로 Category객체를 사용할 때
     * 쿼리를 날려 가져오겠다는 뜻
     * cascade = CascadeType.PERSIST 영속성 전이 설정은 Menu를 저장할 때 연결된 Category 객체도 함께 저장하겠다는 의미
     * */
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
