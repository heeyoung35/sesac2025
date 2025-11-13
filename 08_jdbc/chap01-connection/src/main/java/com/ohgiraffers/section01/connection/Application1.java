package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {

        // finally 블럭에서 상요하기 위해 try 블럭 밖으로 꺼냄
        Connection con = null;
        /* 라이브러리에 있는 클래스를 활용하여 드라이버를 로드하고
         *  어떤 드라이버를 사용할지 인식시킨다. */
        // 자바.랭스의 클래스에 있는 .forName()를 사용
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // java랑 muSql데이터베이스랑 연결할 통로를 만든다.
            // getConnection 스택틱 메소드를 이용해서 Connection(통로)생성
            // 데이터베이스 url주소(사용할 dbms,사용할 데이터명), 데이터베이스에 접속하기 위한 유저정보와 패스워드
            // 설정에 대한 부분은 따로 밖으로 빼서 설정파일로 별도로 관리한다. 설정값이 바뀌어도 재빌드되지 않게 하기 위해서이다.
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "ohgiraffers","ohgiraffers");

            System.out.println("con :" + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            // 닫아주지 않으면 메모리 누수 가능으로 닫아주기
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        }
    }
}
