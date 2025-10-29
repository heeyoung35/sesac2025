package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {
        /* 향상된 for문
        *  배열의 내용을 처음부터 끝까지 훑어보는 '읽기 전용 뷰어'
        * */

        int[] arr = {1, 2, 3, 4, 5};

        // 향상된 포문으로 왼쪽은 배열에서 가져온 값을 임시로 담을 변수 : 오른쪽에 배열
        // value는 임시 변수이기 때문에 원본 배열에는 영향이 없다.
        // :오른쪽으 배열을, :왼쪽의 임시 변수에 '복사'해서 사용
        for (int value : arr) {
            value +=10; //
            System.out.println("임시 변수 value의 값: " + value);
        }

        System.out.println(Arrays.toString(arr));
        /* 출력값
          임시 변수 value의 값: 11
          임시 변수 value의 값: 12
          임시 변수 value의 값: 13
          임시 변수 value의 값: 14
          임시 변수 value의 값: 15
          [1, 2, 3, 4, 5]
          */

        // 배열의 값을 수정하려면 '일반for문'을 사용해야 한다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] +=10;
        }
        System.out.println(Arrays.toString(arr));
        // 출력값 [11, 12, 13, 14, 15]

        /*
        * - 값을 읽을 목적일 때: 향샹된 for문(코드가 간결)
        * - 값을 수정할 목적일 때는 : 일반 for문(인덱스로 직접 접근)
        * */
    }
}
