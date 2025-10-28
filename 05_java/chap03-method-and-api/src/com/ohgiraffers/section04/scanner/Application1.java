package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /*
        * java.util.Scanner를 이용해 다양한 자료형 겂 입력 받기
        * */

        // 1. Scammer 객체 생성
        // 자동으로 import가 되며 사용자에게 입렵을 받을 수 있다.
        Scanner sc = new Scanner(System.in);  // java.lang을 사용하지 않아도 된다.

        // nextLine(): 엔터 키 이전까지의 한 줄 전체를 문자열로 읽음
        System.out.print("이름을 입력하세요: ");  // println은 줄바꿈이 된다
        // Scanner객체 활용해서 입력받기
        String name = sc.nextLine();
        System.out.println("입력하신 이름은" + name + "입니다.");

        // next(): 공백문자나 개행문자(엔터) 전 까지를 문자열로 읽음
        System.out.println("인사말을 입력해주세요: ");
        String greeting = sc.next();
        System.out.println(greeting);

        // nextInt(): 공백 이전까지의 정수 값을 읽음
        System.out.println("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("입력하신 나이는 " + age + "세 입니다.");

        // nextDouble(): 공백 이전까지의 실수 값을 읽음
        System.out.println("키를 입력해주세요");
        double height = sc.nextDouble();
        System.out.println("입력하신 키는 " +height +"cm 입니다.");

        /*
        * 문자를 직접 입력 받는 기능을 제공하지 않는다.
        * 따라서 문자열로 입력을 받고, 원하는 순번째 문자를 분리해서 사용해야 한다.
        * java.lang.String에 charAt(int index)를 사용한다.
        * */

        sc.nextLine(); // 엔터 전까지 모든 공백을 포함한 문자열을 읽어온다.
        System.out.println("아무 문자나 입력 해주세요~ :");
        char ch = sc.nextLine().charAt(0);
        System.out.println("입력하신 문자는" + ch + "입니다.");


    }
}
