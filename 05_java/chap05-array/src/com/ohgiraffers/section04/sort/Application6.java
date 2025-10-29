package com.ohgiraffers.section04.sort;

import java.util.Scanner;

public class Application6 {
    public static void main(String[] args) {

        /* 홀수인 양의 정수를 입력 받아 입력 받은 크기 만큼의 정수형 배열을 할당하고
		 * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력하세요
		 *
		 * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "양수 혹은 홀수만 입력해야 합니다."를 출력하세요
		 * scanner 필요
		 * 출력문
		 * 입력 받을 변수
		 * 정수 검사
		 * 정수가 아니면 양수나 홀수만 입력해야 한다고 출력문 나가 프로그램 종료
		 * 배열생성
		 * 값을 배열에 담고
		 * 출력
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("홀수인 양의 정수를 입력하세요: ");
        int num = sc.nextInt();

        if (num <= 0 || num % 2 == 0) {
            System.out.println("양수 혹은 홀수만 입력해주세요!");
            return;
        }
        int[] arr = new  int[num];

        int middleIndex = num / 2;
        int value = 1;

        for(int i = 0; i < num; i++) {
            arr[i] = value;

            if(i < middleIndex) {
                value++;
            }else {
                value--;
            }
        }
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
