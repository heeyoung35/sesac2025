package com.ohgiraffers.section05.overloading.problem;

public class Problem {
    public static void main(String[] args) {

        BadCalculator bc = new BadCalculator();
        // 데이터 종류에 따라서 골라서 사용해야 하는 불편함을 해결하고자 오버로딩이라는 기능을 제공
        bc.addTwoInts(10, 20);
        bc.addTwoDoubles(10.5, 20.5);
        bc.addThreeInts(10,20,30);


    }
}
