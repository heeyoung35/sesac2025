package com.greedy.lovel01.basic.student.run;

import com.greedy.lovel01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentDTO[] students = new StudentDTO[10];
        int count = 0;

        while (true) {
            if(count == 10) {
                System.out.println("최대 10명의 학생까지 입력할 수 있습니다. 입력을 종료합니다.");
                break;
            }
            System.out.println((count + 1) +"번째 학생 입력");
            System.out.print("학년: ");
            int grad = sc.nextInt();

            System.out.print("반: ");
            int classroom = sc.nextInt();

            sc.nextLine(); // 위의 반을 입력후 남아있는 개행문자를 읽어서 없애버림

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("국어점수: ");
            int kor = sc.nextInt();

            System.out.print("수학점수: ");
            int math = sc.nextInt();

            System.out.print("영어점수: ");
            int eng = sc.nextInt();

            students[count] = new StudentDTO(grad, classroom,name, kor,eng,math);

            count++;

            System.out.println("계속 추가하시겠습니까? (y/n): ");
            String continueInput = sc.next();
            // sc.next() 공백/엔터 전까지 읽기 때문에 엔터를 읽지 않고 버림
            // sc.nextLine() 엔터 전까지 읽기 때문에 엔터까지 읽고 버림

            if (!continueInput.equalsIgnoreCase("y") && !continueInput.equalsIgnoreCase("ㅛ")) {
                break;
            }

        }
        System.out.println();

        for (int i = 0; i < count; i++) {
            StudentDTO student = students[i];

            int sum = student.getKor() + student.getEng() + student.getMath();
            int avg = sum/3;

            System.out.println("학년=" + student.getGrade());
            System.out.println("반=" + student.getClassroom());
            System.out.println("이름=" + student.getName());
            System.out.println("국어점수=" + student.getKor());
            System.out.println("영어점수=" + student.getEng());
            System.out.println("수학점수=" + student.getMath());
            System.out.println("평균" + avg);
        }

    }

}


