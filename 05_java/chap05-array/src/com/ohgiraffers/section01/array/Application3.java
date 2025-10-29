package com.ohgiraffers.section01.array;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        /* 5명의 자바 점수를 정수로 입력 받아 합계와 평균을 실수로 구하는 프로그램을 만들어보자 */
        // 1차원 배열 이용

        // 1. 5명의 자바 점수를 저장할 배열을 할당한다.
        int[] scores = new int[5];

        // 2. 키보드로 점수를 입력받는다.
        Scanner sc = new Scanner(System.in); // 키보드로 점수를 입력
        for (int i =0; i < scores.length; i++){
            System.out.println((i+1) + "번 째 학생의 자바점수를 입력해 주세요 : ");
            scores[i] = sc.nextInt(); // 만들어준 배열에 i번째 해당하는 값을 배열에 할당
        }

        // 3. 합계와 평균을 계산한다.
        double sum = 0.0;
        for (int i = 0; i<scores.length; i++) {
            sum += scores[i];
        }

        double avg = sum/ scores.length;

        // 4. 햡게와 평균 출력하기
        System.out.println("합계 :" + sum);
        System.out.println("평균 :" + avg);
    }
}
