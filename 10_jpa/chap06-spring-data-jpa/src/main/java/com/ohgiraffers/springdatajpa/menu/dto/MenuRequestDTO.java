package com.ohgiraffers.springdatajpa.menu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 요청과 응답이 다를 수 있기 때문에 따로 만들 수 있다.
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuRequestDTO {

    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
