package com.greedy.level01.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Application2 app2 = new Application2();
        app2.testGrade();
        app2.payCalculator();
        app2.suBak();


    }

    public void testGrade() {

        Scanner sc = new Scanner(System.in);
        System.out.println("국어 점수를 입력하세요 : ");
        int kor = sc.nextInt();
        System.out.println("영어 점수를 입력하세요 : ");
        int eng = sc.nextInt();
        System.out.println("수학 점수를 입력하세요 : ");
        int mat = sc.nextInt();
        int grade = (kor + eng + mat) / 3;

        if (grade >= 60 && kor >= 40 && eng >= 40 && mat >= 40) {
            System.out.println("합격입니다!");
        }
        if (grade < 60) {
            System.out.println("평균점수 미달로 불합격입니다.");
        }
        if (kor < 40) {
            System.out.println("국어 과목의 점수 미달로 불합격 입니다.");
        }
        if (eng < 40) {
            System.out.println("영어 과목의 점수 미달로 불합격 입니다.");
        }
        if (mat < 40) {
            System.out.println("수학 과목의 점수 미달로 불합격 입니다.");
        } else {
            System.out.println("불합격입니다.");
        }

    }

        public void payCalculator() {
            Scanner sc = new Scanner(System.in);
            System.out.println("월 급여액을 입력해주세요 :");
            int pay = sc.nextInt();
            System.out.println("월 매출액을 입력해주세요 : ");
            int salse = sc.nextInt();
            double bonus = 0.0;


            if (salse >= 50000000) {
                bonus = 0.05;
            } else if (salse >= 30000000) {
                bonus = 0.03;
            } else if (salse >= 10000000) {
                bonus = 0.01;
            } else {
                bonus = 0;
            }
            int bonusResult = (int) (bonus * salse);

            System.out.println("매출액 :" + salse);
            System.out.println("보너스율 :" + bonus + "%");
            System.out.println("월급여 :" + pay);
            System.out.println("보너스 금액 :" + bonusResult);
            System.out.println("===============");
            System.out.println("총급여액 :" + (pay + bonusResult));
        }

        public void suBak() {
            Scanner sc = new Scanner(System.in);
            System.out.println("정수를 입력해 주세요: ");
            int su = sc.nextInt();

            for (int i = 1; i <= su; i++) {
                if (i % 2 != 0) {
                    System.out.print("수");
                } else {
                    System.out.print("박");
                }
            }
        }
    /* 1부터 100 사이의 난수를 발생시키고
     * 정수를 입력 받아서 입력받은 정수가 발생한 난수보다 큰 경우 "입력하신 정수보다 큽니다." 출력,
     * 입력받은 정수보다 난수가 작은 경우 "입력하신 정수보다 작습니다." 를 출력하며
     * 입력한 정수와 난수와 같은 경우까지 난수 맞추기를 반복하는 프로그램을 만드세요.
     *
     * 단, 입력한 정수와 난수가 같은 경우   "정답입니다. 4회 만에 정답을 맞추셨습니다." 하고
     * 정답을 입력한 횟수도 함께 출력되도록 해야 합니다.
     * 처음부터 바로 난수를 맞추는 경우는 1회만에 정답을 맞춘 것입니다.
     *
     * 정답을 맞추는 경우 위 내용을 출력하고 프로그램이 종료되도록 작성하면 됩니다.
     *
     * -- 프로그램 예시 --
     * 정수를 입력하세요 : 5
     * 입력하신 정수보다 작습니다.
     * 정수를 입력하세요 : 3
     * 입력하신 정수보다 큽니다.
     * 정수를 입력하세요 : 4
     * 정답입니다. 3회만에 정답을 맞추셨습니다.
     * */


    }





