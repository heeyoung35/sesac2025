package com.greedy.level01.basic;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Application1 app = new Application1();
       // app.payCalculator();
        app.suBak();

    }
    // chap04 - control-flow 과제 영업사원의 월급계산
    public void payCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("월 급여액을 입력해주세요 :");
        int pay = sc.nextInt();
        System.out.println("월 매출액을 입력해주세요 : ");
        int salse = sc.nextInt();
        double bonus = 0.0;


        if (salse >= 50000000) {
            bonus = 0.05;
        }else if (salse >= 30000000) {
            bonus = 0.03;
        }else if (salse >= 10000000) {
            bonus = 0.01;
        }else {
            bonus = 0;
        }
        int bonusResult = (int)(bonus * salse );

        System.out.println("매출액 :" + salse);
        System.out.println("보너스율 :" + bonus + "%");
        System.out.println("월급여 :" + pay);
        System.out.println("보너스 금액 :" + bonusResult);
        System.out.println("===============");
        System.out.println("총급여액 :" + (pay + bonusResult));
    }

    // chap04 - control-flow 정수를 입력받아 1부터 입력받은 정수까지
    //		 * 홀수이면 "수", 짝수이면 "박"이 정수만큼 누적되어 출력되게 작성하시오.
    public void suBak() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력해 주세요: ");
        int su = sc.nextInt();

        for (int i = 1; i <= su; i++) {
           if (i % 2 != 0) {
               System.out.print("수");
           }else {
               System.out.print("박");
            }
        }
    }

    // chap04 - control-flow 1부터 100 사이의 난수를 발생시키고


}
