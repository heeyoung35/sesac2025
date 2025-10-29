package com.ohgiraffers.section04.sort;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Application5 {
    public static void main(String[] args) {

        /* 배열과 정렬을 응용하녀 중복 없는 로또 번호를 생성해보자! */

        // 1. 6개 숫자를 담을 배열 생성
        int[] lottoNumber = new int[6];
        int count = 0;

        // 2. 중복되지 않는 난수를 생성하여 배열에 담기
        while (count < 6) {
            int num = (int)(Math.random() * 45) +1;
            boolean isDuplicate = false;

            for (int i = 0; i < count; i++) {
                if (lottoNumber[i] == num) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                lottoNumber[count] = num;
                 count++;
            }
        }
        // 3. 정열하여 출력
        Arrays.sort(lottoNumber);
        System.out.println("로또번호: " + Arrays.toString(lottoNumber));
    }
}

