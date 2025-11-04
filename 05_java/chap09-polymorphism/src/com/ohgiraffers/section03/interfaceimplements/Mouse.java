package com.ohgiraffers.section03.interfaceimplements;

public class Mouse implements IConnectable{

    @Override
    public void connect() {
        System.out.println("마우스가 USB 포트에 연결되었습니다. ");
    }

    @Override
    public void disconnect() {
        System.out.println("마우스가 연결해제 되었습니다. ");
    }
}
