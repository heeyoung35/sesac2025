package com.ohgiraffers.section03.math;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        /*
        * java.lang.Math
        *  수학에서 자주 사용하는 상수들과 함수들을 미리 구현해놓은 클래스로, 모든 메소드는 static(기능적으로 사용) 메소드이다.
        *  java.lang 패키지에 속해 있어 별도의 import가 필요 없다.
        * */

        // 절대값 구하기 : abs()
        System.out.println("절대값: " + Math.abs(-7));

        // 최소값, 최대값 구하기 min(), max()
        System.out.println("최소값: " + Math.max(10,20));
        System.out.println("최대값: " + Math.max(10,20));

        // 원주율 PI(미리 정의된 상수)
        System.out.println("원주율: " + Math.PI);

        System.out.println("기본 난수 발생: " + Math.random()); // 0.0이상 1.0 미만의 실 수 반환
        // 위의 실수를 정수상태로 바꾸는 공식
        // 공식: (int) (Math.random() * (구하려는 난수의개수) +(구라혀는 나수의 최소값)
        // 0~9 까지의 난수 발생
        int random1 = (int)(Math.random() * 10); // 0.0 ~ 9.99...를 int로 바꾸면 0~9 출력
        System.out.println(random1);

        // 1~10까지 난수 발생
        int random2 = (int)(Math.random() * 10) + 1;  // 0에서부터가 아니라 1에서부터 이기 때문에 +1
        System.out.println(random2);

        // 10 ~ 15까지의 난수 발생
        // 10~15이기 때문에 구하려는 난수 개수가 6개이고 10에서부터 시작이기 때문에 +10
        int random3 = (int)(Math.random() * 6) + 10;
        System.out.println(random3);

        /* java.util.Random 클래스를 활용한 난수 발생 */

        // 1. Random 객체 생성 (사용할 클래스명 객체명 = new 클래스명)
        Random random = new Random();

        // 0~9까지의 난수 발생
        // nextInt(int bound): 0부터 bound-1 까지의 정수 난수를 반환
        int randomNumber1 = random.nextInt(10);
        System.out.println(randomNumber1);

        // 20 ~ 45 까지의 난수 발생 (개수는 45-20+1 = 26개)
        int randomNumber2 = random.nextInt(26) + 20;
        System.out.println(randomNumber2);

    }
}
