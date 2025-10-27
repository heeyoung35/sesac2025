package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {

        /* 변수의 명명 규칙*/
        /* 1. 컴파일 에러를 발생시키는 규칙*/
        /* 동일한 범위 내에서 동일한 변수명을 가질 수 없다. */
        int age = 20;
//      int age = 20;      // age 변수명에 대해서 에러발생

        /* 예약어는 사용이 불가하다. (예약어: 자바에서 미리 사용하겠다고 compiler와 약속한 키워드) */
//        int true = 1;
//        int for = 20;

        /* 변수명은 대/소문자를 구분한다. */
        int Age = 20;   // 위에 만든 age와 다른 것을 취급
        int True = 10;  // 예약어 true와 다른 것으로 취급

        /* 변수명은 숫자로 시작할 수 없다. */
//      int 1age = 20;   // 숫자로 시작해서 에러 발생
        int age1 = 20;   // 중간이나 뒤에 오는 숫자는 사용가능하다.

        /* 특수기호는 '-' 와 '$'만 사용 가능하다. */
//        int sh@rp = 10;
//        int -age = 20;
        int _age = 20;    // 언더 스토어는 사용가능하다.
        int $anda = 20;

        /* 컴파일 에러를 발생시키지는 않지만 개발자들끼리의 암묵적 규칙 */
        /* 변수명의 길이 제한은 없지만 적당히 해야겠죠? */
        int agkdjadishkdjlfdlhekdkjkehlskdlwejkdk;

        /* 합성어로 이루어진 경우 첫 단어는 소문자, 두 번째 시작 단어는 대문자로 시작한다. */
        int maxAge = 20;
        int max_age = 20; // 단어와 단어 사이의 연결을 언더스토어(_)로 하지 않고 카멜케이스를 사용한다.

        /* 한글로 변수명을 짓는 것이 가능하지만, 권장하지 않는다. */
        int 나이;

        /* 변수안에 저장된 값이 어떤 의미를 가지는지 명확하게 표현하도록 한다. */
        String s;  // 변수가 어떤 의미인지 파악하기 힘들다.
        String name;   // 문자열 형태의 이름이 저장되겠구나 의도 파악 가능

        /* 전형적 변수 이름이 있다면 가급적 사용*/
        int sum = 0;
        int max = 10;
        int min = 0;
        int count = 1;

        /* boolean형은 의문문으로 가급적 긍정형태로 네이밍 */
        boolean isAlive = true;
        boolean isDead = false; // 부정형 보다는 긍정형이 더 나은 방식


    }
}
