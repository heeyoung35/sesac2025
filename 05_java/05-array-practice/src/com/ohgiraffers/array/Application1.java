package com.ohgiraffers.array;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("홀수를 입력해주세요 : ");
        int size = sc.nextInt();

        if( size <=0 || size % 2 == 0) {
            System.out.println("정수 혹은 홀수를 입력해야 합니다.");
        } else {
            int[] arr = new int[size];

            int midIndex = size / 2;
            int value = 0;

            for (int i = 0; i < size; i++) {
                if (i <= midIndex) {
                    value++;
                }else {
                    value--;
                }
                arr[i] = value;
            }
           for (int i = 0; i < arr.length; i++) {
               System.out.print(arr[i] + "");
           }
            System.out.println();
        }
    }
}
