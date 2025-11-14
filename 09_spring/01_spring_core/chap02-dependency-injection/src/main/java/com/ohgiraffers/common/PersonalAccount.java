package com.ohgiraffers.common;

public class PersonalAccount implements Account{

    private final int bankCode;
    private final String accNo;
    private int balance;

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String str;

        if(money >= 0 ) {
            this.balance += money;
            str = money + "원이 입금되었다.";
        }else {
            str = "금액을 잘못 입력하였습니다.";
        }
        return str;
    }

    @Override
    public String withDraw(int money) {

        String str = "";

        if(this.balance >= money) {
            this.balance -= money;
        } else {
            str ="진액이 부족합니다";
        }
        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
