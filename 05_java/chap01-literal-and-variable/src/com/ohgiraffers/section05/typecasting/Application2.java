package com.ohgiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {

        /* 강제형변환
        *  바꾸려는 자료형으로 캐스트 연산자를 이용하여 형변환한다.
        *  (바꿀자료형) 값;
        * */
        /*
        * 큰 자료형에서 작은 자료형으로 변경 시 강제 형변환이 필요하다.
        *  */
        long lunm = 8;
//      int inum = lunm;   // 데이터 손실 가능성을 컴파일러가 알려준다. (컴파일에러 발생)
        int inum = (int)lunm; // 변경하려는 자료형을 명시하여 강제 형변환을 해야한다.

        short snum = (short)inum;

        /*
        * 실수를 정수로 변경 시 강제 형변환이 필요하다.
        * */
        float fnum2 = 4.0f;   // 실수의 대표 자료형은 duble이기 때문에 float를 사용할 때는 실수 뒤에 f를 붙인다.
//      long lnum2 = fnum2;   // long이 더 큰 자료형이지만 실수를 정수로 변경하는 것이기 때문에 손실 가능성을 알려준다.
        long lnum2 = (long)fnum2; // 데이터 손실을 감안할테니 형변환 해줘!



    }
}
