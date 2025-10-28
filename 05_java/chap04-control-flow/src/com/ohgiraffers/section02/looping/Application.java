package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

    Application app  = new Application();
//  app.whyNeedLoops();
//  app.forLoopSum();
//  app.nestedForLoop();
//  app.nestedForLoop2();
//  app.whileLoop();
    app.whileLoop2();
    }

    public void whyNeedLoops() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1번째 학생의 이름을 입력해주세요 :");
        String student1 = sc.nextLine();
        System.out.println("1번째 학생의 이름은 " + student1 + "입니다.");

        System.out.println("2번째 학생의 이름을 입력해주세요 : ");
        String student2 = sc.nextLine();
        System.out.println("2번째 학생의 이름은 " + student2 + "입니다.");

        for (int i = 1; i <= 5; i++) { // i가 1부터 10까지 1씩 증가하는 동안 반복!
            System.out.println(i +"번째 학생의 이름을 입력해 주세요 : "); // i가 반복하는 동안 i가 바뀌면서 출력문이 반복
            String student = sc.nextLine();
            System.out.println(i + "번째 학생의 이름은" + student + "입니다.");

        }
    }

    // for문 - 누적 합계 구하기
    public void forLoopSum() {
        // 1부터 사용자가 입력한 숫자까지의 합계 구하기
        Scanner sc = new Scanner(System.in);
        System.out.println("합계를 구할 양의 정수를 입력하세요.");
        int num = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;  // sum = sum + i; 1이 반복했을 때 0에 1이 들어갔을 때 누적해서 합계를 구함
        }
        System.out.println("1부터" +num + "까지의 합은: " + sum);
    }

    // 중첩 for문 - 구구단
    public void nestedForLoop(){
        // 바깥쪽 for문: 단(2~9)을 제어
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("---" + dan + "단 ---");
            // 안쪽 for문 : 곱하는 수(1~9)를 제어 안쪽 for문의 조건이 끝나야 바깥 for문으로 빠져나간다.
            for (int su = 1; su <= 9; su++) {
                System.out.println(dan + "*" + su + "=" + dan * su);
            }
            System.out.println();
        }
    }
    // 중첩 for문 - 별 찍기
    public void nestedForLoop2(){
       Scanner sc = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력하세요");
        int rows = sc.nextInt();

        // 입력받은 줄(rows) 수만큼 반복하기(행)
        // for문은 반복하는 조건의 규칙을 먼저 찾아서 구조를 만든다.
        for (int i = 1; i <= rows; i++) { // 행을 제어
            // i번째 줄에서 별을 i번 찍는다.
            // i가 1인 상태로 j로 들어오면 i와 같기 때문에 종료되고 바깥for문으로 나간다. 각 행에 찍을 별의 개수 제어
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // 옆으로 찍어야하기 때문에 print 사용!!!
            }
            System.out.println(); // 한 줄 출력이 끝나면 줄바꿈
        }
    }

    // 5. while문 - 반복 횟수가 불명확할 때
    public void whileLoop(){
        Scanner sc = new Scanner(System.in);
        String str = "";

        // equals(): 문자열의 내용이 같은지 비교하는 메소드
        while (!str.equals("exit")) {
            System.out.println("문자열을 입력하세요 ('exit' 입력 시 종료) : ");
            str = sc.nextLine();
            System.out.println("입력한 문자열: " + str);
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 6. do-while문 - 최소 한 번은 실행해야 할 때
    public void whileLoop2(){
        Scanner sc = new Scanner(System.in);
        String str;

        //do 블럭의 코드를 ㅁ너저 실행한 후, while 조건을 검사한다.
        do{
            System.out.println("문자열을 입력하세요 ('exit' 입력 시 종룍) : ");
            str = sc.nextLine();
            System.out.println("입력한 문자열: " + str);
        } while (!str.equals("exit"));

        System.out.println("프로그램을 종료합니다.");
    }
}


