package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /*
        * 숫자 입력 후 문자열 입력시 발생하는 문제점
        *  nextInt(), nextDouble(), next()등은 입력된 값에서 해당 부분문 가져가고
        *  마지막에 입력된 '개행문자(\n)는 입력 버퍼에 그대로 남겨둔다.
        *
        * 이 상태에서 nextLine()을 호출하면, 버퍼에 남아있는 개행문자를 읽고 즉시 종료해버려
        *  우리가 원하는 문자열을 입력할 수 없게 된다.
        * */

        Scanner sc = new Scanner(System.in);

        System.out.println("나이를 입력하세요 :");
        int age = sc.nextInt();
        System.out.println("나이는" + age + "세 입니다.");
        // 나이를 입력하고 엔터를 치면 이후 입력이 되지 않고 종료된다.
        // 임시공간에 숫자를 입력하면 5\n(엔터)  숫자5만 가져가서 임시공간에 \n(엔터)만 남아서 개행문자만 보고 입력을 받지 않고 종료시킨다.
        // 이러한 문제를 해결하기 위해서 한번 더 호출해서 남아있는 개행문자를 이 호출이 가져갈 수 있도록 한다.
        sc.nextLine(); // 버퍼에 남아있는 개행 문자를 제거하기 위해서 작성

        System.out.println("사는 곳을 입력하세요:");
        String address = sc.nextLine();
        System.out.println("사는 곳은" +address +"입니다.");

        // 안정적인 입력받기(nextLine()으로 통일)
        System.out.println("나이를 입력하세요.");
        String ageInput = sc.nextLine();  // "5"라는 문자열로 입력받음
        int age1 = Integer.parseInt(ageInput); // 입력받은 문자를 parseInt를 사용해서 정수로 형변환을 시켜주는 것이다.
        System.out.println("입력한 나이는 " + age + "세 입니다.");

        System.out.println("사는 곳을 입력하세요:");
        String address1 = sc.nextLine();
        System.out.println("사는 곳은" +address1 +"입니다.");

        sc.close(); // 스캐너 사용이 끝나면 닫아주는 것이 좋다.
    }
}
