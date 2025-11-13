package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
// 커넥션을 열고 스테이트먼트 생성 커넥션에게 스테이트먼트를 생성해줘하고 리절트셋에 담아서 반환하고 스트링 자료형 값으로 반환받아 올께요
// 그리고 마지막에 자원을 반납한다.
public class Application1 {
    public static void main(String[] args) {

        // 통로를 열고 sql쿼리를 통로를 통해 나를 것과 담을 것이 필요하다.
        Connection con = getConnection();

        // 쿼리를 운반하고 결과를 반환하는 객체
        Statement stmt = null;
        // select 조회쿼리를 날리면 조회해서 결과 집합을 받아올 인터페이스
        ResultSet rset = null;
        try {
            // 쿼리를 전달하면서 데이터 베이스에 가서 실행해오라고 명령해야 한다.
            stmt = con.createStatement();
            // 그래서 .executeQuery() 결과 집합을 반환받아 온다.
            // stmt,rset 자원이기 때문에 닫아줘야 한다.
            rset =  stmt.executeQuery("select emp_id, emp_name from employee");

            while (rset.next()) {
                /* next() : ResultSet 커서 위치를 내리면서 다음 행이 존재하면 true, 존재하지 않으면 false 반환
                *  getXXX(컬럼명) : 커서가 가리키는 행의 컬럼을 XXX 자료형 데이터 타입으로 반환한다. */
                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 맨 마지막에 열렸던 것부터 순서대로 닫아준다.
            // jdbcTemplate에 커넥션외에 rset과 stmt에 대한 클로즈 메소드도 작성해서 호출한다.
            close(rset);
            close(stmt);
            close(con);

        }
    }
}
