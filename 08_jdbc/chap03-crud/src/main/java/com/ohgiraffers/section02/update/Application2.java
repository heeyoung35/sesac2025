package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴 번호: ");
        int menuCode = sc.nextInt();
        System.out.println("변경할 메뉴의 이름: ");
        sc.nextLine(); // 자료형을 받아서 파싱하는 방법도 있다.
        String menuName = sc.nextLine();
        System.out.println("변경할 메뉴의 가격: ");
        int menuPrice = sc.nextInt();

        MenuDTO changedMenu = new MenuDTO();
        changedMenu.setMenuCode(menuCode);
        changedMenu.setMenuName(menuName);
        changedMenu.setMenuPrice(menuPrice);

        UpdateController controller = new UpdateController();
        // setting된 DTO 전달하며 호출
        int result = controller.updateMenu(changedMenu);

        if( result > 0) {
            System.out.println("메뉴 변경 성공");
        }else {
            System.out.println("메뉴 변경 실패!");
        }
    }
}
