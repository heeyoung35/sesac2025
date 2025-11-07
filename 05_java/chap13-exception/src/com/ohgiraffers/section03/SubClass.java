package com.ohgiraffers.section03;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass{
    // 오버라이딩 성립조건 메소드 이름, 매개변수, 반환 타입이 같아야 한다.
    // 자식의 접근 제한자는 부모보다 넓어야 한다.

    /*  오버라이딩 시 예외 처리 규칙
    * 1. 부모와 동일한 예외를 던지는 것은 가능하다.
    * 2. 부모가 던지는 예외의 자식타입(더 구체적인 예외)을 던지는 것은 가능하다.
    * 3. 예외를 던지지 않는 것도 가능하다.
    * 4. 하지만, 부모가 던지는 예외의 부모 타입(더 포괄적인 예외)이나,
    *   전혀 상관 없는 새로운 예외를 던지는 것은 불가능하다.
    * */
    // 부모의 메서드를 예외 없이 오버라이딩 가능
//    @Override
//    public void method() {}

    // 같은 예외 던지는 것 오버라이딩 가능
//    @Override
//    public void method() throws IOException {}

    // 부모의 예외처러 클래스보다 더 구체적인 경우 오버라이딩 가능
    @Override
    public void method() throws FileNotFoundException {}

    // 부모의 예외처리 클래스보다 상위의 예외로는 오버라이딩 불가능
//    @Override
//    public void method() throws Exception {}  // 컴파일 에러
}
