package com.ohgiraffers.section01.init;

import javax.swing.text.html.CSS;

public class Application {
    public static void main(String[] args) {

        // 자동차 객체 생성 매개변수 있는 생성자만 있으면 기본생성자 호출 불가
        // 생성자가 하나도 없으면 기본 생성자를 컴파일러가 만들어 주지만 생성자를 하나라도 만들면
        // 컴파일러가 기본 생성자를 만들어 주지 않는다. 지금은 매개변수 있는 생성자가 있기 때문에 기본생성자를 만들어주지 않음
        // new Car 객체를 생성해서 heap영역에 새로운 객체 생성 static에 주소값 참조
        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 350);
        Car car3 = new Car("롤스로이스", 250);
        Car car4 = new Car("부가티베이론", 400);
        Car car5 = new Car("포터", 200);

        // 래퍼선스 변수로 호출
        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();
        car4.driveMaxSpeed();
        car5.driveMaxSpeed();
        // 위에처럼 반복적이고 비효울적 작업을 위해서 레퍼런스 변수를 배열에 담아볼 예정이다.


        /* 객체배열은 레퍼런스 변수들을 보관하는 배열이다.
        *  동일한 타입의 여러 객체들을 하난의 묶음으로 관리하여 연속적으로 처리할 때 유용하다.
        * */
        Car[] carArray = new Car[5];  // 5칸의 배열만 만든상태

        /* 배열을 선언만 하면 기본값으로 초기화된다.
        *  기본자료형(int, double 등)은 0, 0.0으로 초기화 되지만,
        *  참조자료형(Car, String 등)의 기본값은 null 이다.
        * */
        System.out.println(carArray[0]); // 출력값 null
        // 위에처럼 배열만 생성하고 참조하지 않은 배열에 무엇을 하겠다고 하면 NullPointerException발생하고
        // 프로그램이 종료된다. 그래서 아래처럼 try catch문을 이용해서 Exception발생시 실행하는 코드 작성으로 프로그램종료 예방

        try {
            carArray[0].driveMaxSpeed();
        } catch (NullPointerException e) { // NullPointerException도 자료형이기 때문에 e를 넣어준다.
            System.out.println("!!! NullPointerException발생!!");
        }

        carArray[0] = new Car("페라리", 300);
        carArray[1] = new Car("람보르기니", 350);
        carArray[2] = new Car("롤스로이스", 250);
        carArray[3] = new Car("부가티베이론", 400);
        carArray[4] = new Car("포터", 200);

        carArray[0].driveMaxSpeed();

        for (int i = 0; i < carArray.length; i++ ) {
            carArray[i].driveMaxSpeed();
        }
        System.out.println();

        // 객체배열 선언과 동시에 리터럴({})로 초기화 할 수 있다.
        Car[] carArray2 = {
                new Car("페라리", 300),
                new Car("람보르기니", 350),
                new Car("롤스로이스", 250),
        };

        // 향상된 for문 사용
        // carArray2 객체 배열에서 객체를 하나씩 꺼내 'car' 라는 이름의 임시 변수에 '복사' 해주는 방식
        // 주의: 실제 car가 복사되는 것은 아니고 car를 가리키는 '주소값'만 복사된다.
        for(Car car : carArray2) {
            car.driveMaxSpeed();
        }

        /* 가장 빠른 차를 찾아라!!! */
        /* 1. 가장 빠르다고 '가정'할 차를 담을 변수 선언 (첫 번째 차로 초기화) */
        Car fastestCar = carArray[0];

        /* 2. 반복문을 돌며 현재까지 가장 빨랐던 차(fastestCar)와 다음차를 비교 */
        for(int i = 1; i < carArray.length; i++) {
            if(carArray[i].getMaxSpeed() > fastestCar.getMaxSpeed()) {
                // 만약 다음 차가 더 빠르다면, '가장 빠른 차' 변수를 그 차로 교체!!
                fastestCar = carArray[i];
            }
        }
        System.out.println("가장 빠른 자동차는 " + fastestCar.getMaxSpeed() + "이며 시속은" + fastestCar.getMaxSpeed() + "입니다. ");
    }
}
