package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    /* 일단 변수만 만들어두고, 처음에는 비워둔다(null) */
    private static LazySingleton lazy;   // 필드만 선언

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(lazy == null) {
            lazy = new LazySingleton(); // 필요할 때 생성한다.
        }
        return lazy;
    }
}
