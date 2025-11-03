package com.ohgiraffers.section01.init;

public class Car {
    // 필드를 private으로 캡슐화를 해주고 있다. 외부에서 이필드에 직접 접근 불가
    // 필드 (자동차의 속성) 모델 이름과 최대 스피드의 속성
    private String modelName;
    private int maxSpeed;

    // 생섲자 (자동차를 처음 만들 때 필요한 값을 받아 초기화)
    // 매개변수 있는 생성자로 클래스 자료형, 이름과 동일하게 해야 생성자 형태
    public Car(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    // 메소드 (자동차가 수행할 수 있는 동작)
    public void driveMaxSpeed() {
        System.out.println(this.modelName + "이(가) 최고시속" + this.maxSpeed + "km/h로 달려갑니다.");
    }

    // 캡슐화로 인해 접근할 수 있도록 값을 읽어오는 getter
    public String getModelName() {
        return modelName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
