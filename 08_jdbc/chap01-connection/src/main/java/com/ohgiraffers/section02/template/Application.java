package com.ohgiraffers.section02.template;

import java.sql.Connection;

import static com.ohgiraffers.section02.template.JDBCTemplate.*;

public class Application {
    public static void main(String[] args) {

        // 임포트 되어서 가지고 온다.
        Connection con = getConnection();
        System.out.println("con :" + con);

        close(con);
    }
}
