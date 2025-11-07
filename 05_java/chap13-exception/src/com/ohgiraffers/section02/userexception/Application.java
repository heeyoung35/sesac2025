package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application {
    public static void main(String[] args) {
        /*구체적으로 예외를 처리할 수 있다. */

        ExceptionTest et = new ExceptionTest();

        try {
            //  et.checkEnoughMoney(30000, 50000);
            //  et.checkEnoughMoney(-30000, 50000);
            //  et.checkEnoughMoney(30000, -50000);
            et.checkEnoughMoney(50000, 30000);

        } catch (PriceNegativeException | MoneyNegativeException e) {
            // 가격 음수 또는 가진 돈 음수 이면 모두 여기서 처리
            System.out.println("진단명 : " + e.getClass() +"발생!!" + e. getMessage());

//        } catch (MoneyNegativeException e) { // 가격와 돈이 음수일 수 없음을 위헤서 같이 예외처리
//            System.out.println("진단명 : " + e.getClass() +"발생!!" + e. getMessage());

         // catch 블록은 항상 '구체적인 자식 타입 -> 포괄적인 부모 타입' 순서로 작성해야 한다!!
         // 예외도 계층적으로 나누어져 있기 때문에 좁은 것부터 포괄적인 것으로 해야 한다.
        } catch (NegativeException e) {
            // 다른 음수의 익셉션의 발생하는 경우 위에서 잡기 때문에 여기까지 오지 않음으로 에러발생

            System.out.println("음수 익셉션 발생!!!");

        } catch (NotEnoughMoneyException e) {
            System.out.println("진단명 : " + e.getClass() + "발생!!" + e.getMessage());

        } catch (Exception e) {
            // 혹시 모를 모든 예외를 잡는 최종 안전망
            e.printStackTrace();

        } finally {
            // try 블록에서 예외가 발생하든, 발생하지 않든 '반드시' 실행되는 코드 블럭
            // 주로 자원 반납(예: db 연결 종료, 파일 닫기)과 같이 항상 수행되어야 하는 코드를 작성
            System.out.println("계산이 끝나 영수증을 출력합니다.");
        }
        System.out.println("프로그램을 정상적으로 종료합니다.");
    }
}
