package com.ohgiraffers.section01.list.run;

import java.util.EmptyStackException;
import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* Stack vector를 상속받았다.
        *  list -> vector -> stack으로 연결되어서 다형성 적용가능
        * - 후입선출(LIFO) 방식의 자료구조이다.
        * - List는 push와 pop를 사용할 수 없다. 그래서 다형성 적용을 하지 않는다.
        *
        * - 웹 브라우저의 뒤로 가기 기능
        * - 프로그래밍 실행 취소 기능
        * - 재귀 알고리즘ㅇ르 반복문으로 구현할 때
        * */

        Stack<Integer> integerStack = new Stack<>();

        // stack에 값을 넣을때는 push() 사용
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);  // 가장 마지막에 들어간 데이터

        System.out.println(integerStack);

        /*
        * peek() : 가장 꼭대기 요소를 '확인만' 하고 제거하지는 않는다
        * pop() : 가장 꼭대기 요소를 '꺼내고' 제거한다.
        * */

        System.out.println("peek() : " + integerStack.peek()); // peek() : 4
        System.out.println(integerStack);  // [1, 2, 3, 4]

        System.out.println("pop() : " + integerStack.pop());  // pop() : 4
        System.out.println(integerStack);   // [1, 2, 3]

        // 에러가 발생했을 때 예외처리 프로그램이 종료되지 않고 안내문구 출력
        try{
            integerStack.pop();
            integerStack.pop();
            integerStack.pop();  // 이미 여기에서 stack이 다 비워짐
            integerStack.pop();  // .EmptyStackException 에러 발생
        } catch (EmptyStackException e){
            System.out.println("스택이 비어있습니다!!");
        }
    }

}
