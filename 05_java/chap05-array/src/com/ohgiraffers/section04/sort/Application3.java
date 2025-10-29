package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {

        /*
        * [버블 정렬]
        * 가장 인접한 짝궁과만 비교해서 정렬한다.
        * 인접한 두 원소를 배교하여, 큰 값을 오른쪽으로 계속해서 이동시킨다.
        * 한 회차가 끝나면 가장 큰 값이 배열의 맨 뒤에 위치하게 된다.
        * */

        int[] arr = {2, 7, 3, 6, 1, 5, 4};

        // ㅑ: 정렬이 확정된 영역의 시작 인덱스 (뒤에서부터)
        for (int i = arr.length -1; i >= 0; i--) { // i가 어디가지 비교해줄 것인지 경계 안쪽 for문을 한 개씩 줄여주는 역활
            // j: 비교한 대상의 인덱스 (앞에서부터)
            for(int j = 0; j < i; j++) {  // 앞에서부터 두 원소를 비교
                if(arr[j] > arr[j + 1]) { // 두 값을 비교해서 왼쪽의 원소가 크면
                    int temp = arr[j];   // swap해주는 과정
                    arr[j] = arr[j +1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println((arr.length - i ) + "회차 정렬 후 : " + Arrays.toString(arr));
        }
        System.out.println("정렬 후 : " + Arrays.toString(arr));

       /* 출력 값
        1회차 정렬 후 : [2, 3, 6, 1, 5, 4, 7]
        2회차 정렬 후 : [2, 3, 1, 5, 4, 6, 7]
        3회차 정렬 후 : [2, 1, 3, 4, 5, 6, 7]
        4회차 정렬 후 : [1, 2, 3, 4, 5, 6, 7]
        5회차 정렬 후 : [1, 2, 3, 4, 5, 6, 7]
        6회차 정렬 후 : [1, 2, 3, 4, 5, 6, 7]
        7회차 정렬 후 : [1, 2, 3, 4, 5, 6, 7]
        정렬 후 : [1, 2, 3, 4, 5, 6, 7]
        */
    }
}
