package com.ohgiraffers.section03.interfaceimplements;

public class Computer {

    // 이컴퓨터의 usb포트는 상관없이 규격을 맞추었느냐만 중요하다.
    public void connectDevice(IConnectable device) {
        System.out.println("컴퓨터의 USB 포트에 장치를 연결합니다.");
        device.connect();
    }
}
