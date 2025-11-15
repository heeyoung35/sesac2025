package com.greedy.level01.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        int answer = (int) (Math.random() * 100) + 1;

        Scanner sc = new Scanner(System.in);

        int input;
        int count = 0;

        while (true) {
            System.out.printf("정수를 입력하세요 : ");
            input = sc.nextInt();

            count++;

            if( input > answer) {
                System.out.printf("입력하신 정수보다 작습니다.");
            } else if ( input < answer) {
                System.out.printf("입력하신 정수보다 큽니다.");
            } else {
                System.out.printf("정답입니다." + count + "회에 정답을 맞추셨습니다.");
                break;
            }
        }
    }
}
