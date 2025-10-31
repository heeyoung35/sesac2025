package com.ohgiraffers.section07.kindsofvariable;

public class KindsOfVariable {

    /*
    * 클래스 영역에 작성하는 변수를 필드라고 한다.
    * */

    // non-static field를 인스턴스변수라고 한다.
    // 가비지컬렉터라고 해서 참조하지 않는 것에 대해서 없앤다. 선언만 해도 기본값으로 초기화를 해준다.
    private int globalNum;

    // static field를 정적필드(클래스변수)라고 한다.
    // 프로그램이 로드될 때 스태틱이라는 정적 메모리 영역에 단 하나 넣어준다. 프로그램이 끝나기 전까지 살아있다.
    private static int staticNum;

    /* 메소드 영역헤서 작성하는 변수를 지역변수라고 한다. */
    // 메소드 안에 선언하는 것은 매개변수인데 매소드를 호출할 때 스택이라는 공간에 생성된다. 메소드가 종료될 때 매개변수는 종료
    public void method(int num) {
        // 지역변수와 매개변수 모두 메소드 호출 시 stack 메모리에 생성된다.
        int localNum; // 메소드가 종료되면 사라진다.
        System.out.println(num);   // 매개변수는 호출 시 값이 넘어오기 때문에 초기화가 필요 없다.
        // 지역변수는 선언 외에 다시 사용(호출)하기 위해서는 반드시 초기화가 되어야 한다.
//      System.out.println(localNum); 초기화되지 않았다는 에러발생 지역변수는 반드시 초기화를 해주어야 한다. 자동으로 초기화 X

        System.out.println(globalNum); // 전역 변수는 클래스 전역에서 사용 가능하다.
        System.out.println(staticNum);
    }
    public void method2() {
        System.out.println(globalNum);
        System.out.println(staticNum);
//        System.out.println(localNum);
// localNum을 찾지 못한다. 왜냐하면 해당 지역(블럭 내) 안에서만 존재하기 때문에 지역내에서만 사용가능.
// 메소드가 끝나면서 종료되기 때문에 메소드2는 localNum존재를 알지 못한다.
    }

}
