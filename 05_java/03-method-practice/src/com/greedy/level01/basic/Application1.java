package com.greedy.level01.basic;

public class Application1 {

    public static void main(String[] args) {

        System.out.println();
        Calculator calc =  new Calculator();
        Calculator.checkMaxNumber();
        calc.checkMethod();
        int sumResult = calc.sum1to10();
        System.out.println("1부터 10까지의 합은: " + sumResult);
        int addResult = calc.sumTwoNumber(10,20);
        System.out.println("10과 20의 합은: " + addResult);
        int minusResult = calc.minusTwoNumber(10,5);
        System.out.println("10과 5의 차는: " + minusResult);
    }
}
