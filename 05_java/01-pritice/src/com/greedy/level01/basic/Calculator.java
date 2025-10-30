package com.greedy.level01.basic;

import java.util.Scanner;

public class Calculator {

    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return (sum);
    }

    public static void checkMaxNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요 :");
        int first = sc.nextInt();
        System.out.println("두 번째 숫자를 입력하세요 :");
        int second = sc.nextInt();
        System.out.println("두 수중의 큰수는" +Math.max(first,second) + "이다");
    }

    public int sumTwoNumber(int a, int b) {
        int sum1 = a + b;
        return sum1;
    }

    public int minusTwoNumber(int a, int b) {
        int minus1 = a - b;
        return minus1;
    }
}
