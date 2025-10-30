package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /*
        * 사용자는 카레이서랑만 통신을 한다.  */
        // 카레이서(운전자) 객체 생성
        CarRacer racer = new CarRacer(); // 대리인 객체 생성

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("========카레이싱 프로그램==========");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 엑셀 밟기");
            System.out.println("3. 브레이크 밟기");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴 선택");
            int no = sc.nextInt();

            switch (no) {
                // 사용자는 카레이서 요청 한다.
                case 1:
                    racer.startUp();
                    break;
                case 2:
                    racer.stepAccelator();
                    break;
                case  3:
                    racer.stepBreak();
                    break;
                case 4:
                    racer.turnOff();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
                    break;
            }
        }
    }
}
