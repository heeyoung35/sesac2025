package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /*
        * [ 선택 정렬 ]
        * 비유: 반에서 키가 가장 작은 사람을 찾아 맨 앞으로 보내는 과정을 반복하는 것
        * */

        int[] arr = {2, 5, 4, 6, 1, 3};
        System.out.println("정렬 전" + Arrays.toString(arr));
        // i < arr.length -1 마지막 자리는 자연스럽게 가장 큰 사람이기 때문에 확인하지 않는다.
        for (int i = 0; i < arr.length -1; i++) { // 맨 앞자리를 작은 사람으로 채우는 것처럼 정렬할 자리의 인덱스를
            int minIndex = i; // 일단 현재 자리(i)에 있는 사람이 가장 작다고 가정
            for (int j = i +1; j < arr.length; j++) { // 작은 값을 찾는 로직 i가 작다는 가정하에 두번째 부터 확인
                if(arr[minIndex] > arr[j]) {
                    minIndex = j; // 최소값의 인덱스를 기억하는 것
                }
            }
            // 찾은 최소값( arr[minIndex])과 현재 자리(arr[i]) 값을 교회(swap)
            int temp = arr[minIndex]; //가장 작다고 한 것을 저장해두고
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println((i+1) + "회차 정렬 후: " + Arrays.toString(arr));
        }

        System.out.println("정렬 후: " + Arrays.toString(arr));

        /* 출력 값
        정렬 전[2, 5, 4, 6, 1, 3]
        1회차 정렬 후: [1, 5, 4, 6, 2, 3]
        2회차 정렬 후: [1, 2, 4, 6, 5, 3]
        3회차 정렬 후: [1, 2, 3, 6, 5, 4]
        4회차 정렬 후: [1, 2, 3, 4, 5, 6]
        5회차 정렬 후: [1, 2, 3, 4, 5, 6]
        정렬 후: [1, 2, 3, 4, 5, 6]
        */

    }
}
