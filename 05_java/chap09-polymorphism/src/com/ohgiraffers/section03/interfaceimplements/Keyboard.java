package com.ohgiraffers.section03.interfaceimplements;
//클래스 'Keyboard' 은(는) abstract로 선언되거나 'IConnectable' 에서 추상 메서드 'connect()'을(를) 구현해야 합니다
// 규격한 내용을 만들어야 한다는 에러발생
// 인터페이스는 쉼표로 여러 개를 implements 할 수 있다. 상속과는 다른 특징
// 자바의 단일 상속 한계 극복, 다중 상속의 효과를 내는 방법
// public class Keyboard implements IConnectable, Iterable{
public class Keyboard implements IConnectable{

    @Override
    public void connect() {
        System.out.println("키보드가 USB 포트에 연결되었습니다. ");
    }

    @Override
    public void disconnect() {
        System.out.println("키보드가 연결해제 했습니다. ");
    }
}
