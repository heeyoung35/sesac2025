package com.ohgiraffers.practice;

public class Application1 {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;

        int result = a + b;
        System.out.println("더하기결과:"+ result);
        int result2 = a - b;
        System.out.println("빼기결과:"+ result2);
        int result3 = a * b;
        System.out.println("곱하기결과:" + result3);
        int result4 = a / b;
        System.out.println("나누기한 몫:" + result4);
        int result5 = a % b;
        System.out.println("나누기한 나머지:" + result5);


        double area = 12.5;
        double high = 36.4;

        double area1 = area * high;
        System.out.println("면적:" + area1);
        double grid = ((area + high) * 2);
        System.out.println("둘레:" + grid);

        char unicode = 'a';
        System.out.println("문자a의 unicode:" + (int)unicode ); // 문자형으로 변수를 선언해 주었기 때문에 강제로 형변환을 하지 않으면 문자출력

        double kor = 80.5;
        double met = 50.6;
        double eng = 70.8;

        double sum = (kor + met + eng);
        System.out.println("총점:" + (int)sum);
        double average = ((kor + met + eng) / 3);
        System.out.println("평균:" + (int)average);






    }
}
