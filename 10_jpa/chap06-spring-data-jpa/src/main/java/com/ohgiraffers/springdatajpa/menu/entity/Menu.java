package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
// setter의 경우는 모두 열어두는 것이 아니라 필요한 부분만 메서드만 따로 만들어서 사용해야 한다.
@Getter
// 기본 생성자를 만들어 줘야 하는데 밖에서 빈객체를 만들 수 있기 때문에 접근제한자를 속성으로 작성해 준다.
// JPA 스펙상 기본생성자가 꼭 있어야 하지만 아무나 빈 객체를 만들 수 ㅇ벗도록 엑세스 레벨 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder // 어떻게 사용하는지 확인하기
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

    public void modify(String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    // 다른 로직을 추가해서 확인하고 수정할 수도 있다. 의미있는 메소드 작성으로 메뉴를 업데이트 할 수 있다.
    public void modifyMenuPrice(int menuPrice){
        this.menuPrice = menuPrice;
    }

    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }

}
