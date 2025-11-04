package com.ohgiraffers.section03.interfaceimplements;
// interfaceimplements도 미완성 클래스
// 클래스들이 지켜야할 공식적인 약속서
public class Application {
    public static void main(String[] args) {

    Keyboard keyboard = new Keyboard();

    Mouse mouse = new Mouse();

    Computer computer = new Computer();

    computer.connectDevice(keyboard);
//  출력값    컴퓨터의 USB 포트에 장치를 연결합니다.
//  출력값    키보드가 USB 포트에 연결되었습니다.
    computer.connectDevice(mouse);

    }
}
