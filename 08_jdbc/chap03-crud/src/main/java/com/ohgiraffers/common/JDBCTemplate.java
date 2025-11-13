package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 객체를 만들지 않고 공용으로 사용하기 위해서 static으로 만들면 가능하다.
// 싱글톤으로 만들면 커넥션 객체를 바로 얻을 수 있다.
public class JDBCTemplate {

    public static  Connection getConnection() {

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            // 드라이버를 로드하는 코드
            Class.forName(driver);

            // url과 properties 객체를 통째로 넘길 수도 있다.
            // "user"와 "password" 키를 찾아서 사용하기 때문에 키이름이 동일해야 한다.
            con = DriverManager.getConnection(url,prop);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 성공적으로 생성된 Connection 반환
        // 커넥션을 만들어 주는 메서드이기 때문에 만들어서 반환해준다 그래서 만들자마자 닫을 수 없기 때문에 클로즈를 사용하지 않는다.
        return con;
    }
    // 자원반납 메서드 만들기

    public static void close(Connection con) {

        try {
            // 커텍션이 널이 아니고 커넥션이 닫아있지 않다면 닫아주겠는 클로즈를 호출
            // cpn.isClised() 닫혀있으면 true를 반환하므로, !를 붙여 "닫혀있지 않으면" 조건으로 만든다.
            if(con !=null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 오버로딩 : 같은 이름의 메소드가 매재변수의 타입이나 개수가 다르면 오버로딩이다.
    public static void close(Statement stmt) {
        try {
            // 스테이트먼트를 받아와서 stmt가 닫혀있지 않으면 닫아 주겠다.
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rset) {

        try {
            if(rset != null && !rset.isClosed()) {
                rset.isClosed();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
