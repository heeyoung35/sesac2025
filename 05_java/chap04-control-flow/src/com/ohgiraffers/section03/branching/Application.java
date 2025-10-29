package com.ohgiraffers.section03.branching;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//      app.simpleBreak();
        app.nestedBreak();
        app.simpleContinue();
        app.nestedContinue();
        app.handleNestedBreak();

    }

    public void simpleBreak() {

        int sum = 0;
        int i = 1;

        while(true) {
            sum += i;
            System.out.println(i + "를 더했다. 현재 합게 : " + sum);

            // 만약 i가 10이 되면 이라는 탈출 조건을 만든다.
            if (i == 10) {
                System.out.println("i가 10이 되어 break로 반복문을 탈출한다.");
                break;  // 가장 가까운 반복문(while)을 즉시 중단하고 탈출하게 된다.
            }
            i++;  // break 조건이 아니면 i를 증가시키고 다시 반복
        }
        System.out.println("최종 합은 " + sum + "입니다.");
    }
    // 구구단인데 break를 만나서 5까지만 출력되는 예문
    // break는 자신을 감싸고 있는 '가장 가까운' 반복문 하난만 탈출한다.
    public void nestedBreak() {
        for(int dan =2; dan <= 10; dan++) {
            System.out.println("---" +dan + "단 시작 ---");
            for (int su = 1; su < 10; su++) {
                if(su > 5) {
                    break;  // break를 만나면 가장 가까운 반복문인 안쪽 for문 만 탈출하게 된다.
                }
                System.out.println(dan + "*" + su + "=" + dan * su);
            }
        }
    }
    // 1부터 100사이의 4와 5의 공배수만 출력하는 예문
    public void simpleContinue() {
        System.out.println("1부터 100사이의 4와 5의 공배수(20의 배수)만 출력합니다.");

        for (int i = 1; i <= 100; i++) {
            // 4의 배수이면서 동시에 5의 배수가 아니라면
            // 예외조건을 먼저 처리한다.
            if(!(i % 4 == 0 && i % 5 == 0)) {
                continue;  // 이번 반복 회차를 건너뛰고 증감식으로 이동한다.
            }
            System.out.println(i);
        }
    }
    // 구구단을 출력하되, 각 단에서 '홀수' 곱만 출력하는 continue 예제
    public void nestedContinue() {
        for(int dan =2; dan <= 10; dan++) {
            System.out.println("---" +dan + "단 시작 ---");
            for (int su = 1; su < 10; su++) {
                // 만약에 곱하는 수가 짝수라면, 건너뛰고 바로 증감식으로 간다.
                if(su % 2 == 0) {
                    // continue는 안쪽 for문에서 해당 회차만 건너뛴다.
                    continue; // 이번 회차(su)는 건너뛰고, 바로 다음 숫자인 su++로 이동한다.
                }
                System.out.println(dan + "*" + su + "=" + dan * su);
            }
        }
    }
    // 구구단에서 3단의 5까지만 출력하는 예문
    public void handleNestedBreak() {
        // 코드의 흐름을 예측하기 어려워 거의 사용하지 않는 '안티 패턴'이다.
        ohgiraffers: // 바깥쪽 for문에 이름표를 붙임 라벨이 많아지면 코드의 흐름을 예측할 수 없다.
        for(int dan =2; dan <= 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {
                   // break  // 안쪽 for문은 탈출하지만 바깥 for문으로 돌아간다. 3단만 5까지 출력되고 다른 단은 모두 출력
                    break ohgiraffers; // 이름표가 붙은 반목문 전체를 탈출 4단부터 출력되지 않음
                }
                System.out.println(dan + "*" + su + "=" + dan * su);
            }
        }
        // 실무에서 많이 사용하며 코드의 흐름대로 예측가능
        System.out.println("Flag 변수 사용");

        // 코드가 순차적으로 흘러가서 직관적이고 안정적이다.
        boolean isBreak = false;    // 탈출 실호를 보낼 Flag변수(깃발)

        for(int dan =2; dan <= 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {
                    isBreak = true; // 탈출 신호를 보낸다
                    break;  // 우선 가장 가까운 반복문 탈출
                }
                System.out.println(dan + "*" + su + "=" + dan * su);
            }
            // 안쪽 반복문이 끝난 직후, Flag 변수를 확인한다.
            // 바깥쪽 for문에 해당하는 것이기 때문에 안쪽 for문 이후에 코드의 흐름대로 진행중에 Flag변수를 만나서 탈출하게 된다.
            if (isBreak) {
                break;  // 탈출신호가 있다면 바깥쪽 반복문도 탈출한다.
            }
        }
        System.out.println();
    }
}
