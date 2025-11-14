package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매 여부를 입력 받기 (Scanner 이용) */

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴의 이름을 입력하세요 :");
        String menuName = sc.nextLine();
        System.out.println("메뉴의 가격을 입력하세요 :");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드를 입력해주세요 :");
        int categoryCode = sc.nextInt();

        sc.nextLine();
        System.out.println("판매 여부를 입력해주세요 : ");
        String orderableStatus = sc.nextLine();


        /* 2. menuDTO 객체를 생성하여 입력받는 값으로setting*/
        MenuDTO newMenu = new MenuDTO();

        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderableStatus(orderableStatus);

        /* 3. InsertController의 insertMenu() 메소드 호출*/
        InsertController controller = new InsertController();
        int result = controller.insertMenu(newMenu);

        /* 4. insert 결과에 따라 성공이면 '메뉴등록 성공!' 출력 실패이면 '메뉴 등록 실패' 출력*/
        if (result > 0) {
            System.out.println(" 메뉴등록 성공");
        } else {
            System.out.println("메뉴 등록 실패");
        }
    }
}
