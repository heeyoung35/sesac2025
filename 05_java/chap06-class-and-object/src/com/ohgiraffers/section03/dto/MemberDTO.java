package com.ohgiraffers.section03.dto;

public class MemberDTO {

    // 필드를 다 private으로 설정한다. 정해진 입구를 통해서만 데이터를 다룰 수 있도록 한다.
    private int number;
    private String name;
    private int age;
    private char gender;
    private double weight;
    private double height;
    private boolean isActivated;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    // boolean 타입의 Getter는 is...()로 작성하는 것이 자바 개발의 표준이자 실무적인 약속
    public boolean isActivated() {
        return isActivated;
    }
}
