package com.ohgiraffers.section02.demensinal;

public class Application2 {
    public static void main(String[] args) {

        /*
         * [ 가변 배열 ]
         * 2차원 배열의 각 행(층)마다 열(방)의 길이가 다른 배열
         * 선언 방법:
         * 1. 층의 수만 먼저 지정하여 배열을 할당 (건물의 층수만 정해서 만들기)
         * 2. 각 층마다 다른 길이의 배열을 개별적으로 할당
         * */

        // 1. 층의 수만 지정하여 배열 할당 뼈대를 만들고
        int[][] iarr = new int[3][];

        // 2. 각 층마다 다른 길이의 배열 각 층에 해당하는 칸을 만든다.
        iarr[0] = new int[3];
        iarr[1] = new int[2];
        iarr[2] = new int[5];

        // 3. 중첩 반복문을 이용한 값 대입
        int value = 1;
        // '층'을 순회(0층, 1층, 2층을 순회)
        for (int i = 0; i < iarr.length; i++) {
            for (int j = 0; j < iarr[i].length; j++) { // 자신의 길이만큼 반복을 하기 때문에
                iarr[i][j] = value++;                 // 동일하게 벨류값 증가하면서 각 층에 해당하는 칸에 값을 넣어준다.
            }
        }
        for (int i = 0; i < iarr.length; i++) {
            for (int j = 0; j < iarr[i].length; j++) {
                System.out.print(iarr[i][j] + "");
            }
            System.out.println();
           /* 출력값
              123
              45
              678910
              */
        }
    }
}