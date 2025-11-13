package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        /* 1. Connection 생성*/
        Connection con = getConnection();

        /* 2. Statement 선언 트라이문 밖에서 */
        Statement stmt = null;
        /* 3. ResultSet 선건*/
        ResultSet rest= null;

        /* 4. Connection의 creatStatement()를 이용한 Statement 인스턴스 생성 */
        try {
            stmt = con.createStatement();

            // Scanner로 사번 입력받아 해당하는 사원의 아이디와 이름 조회 쿼리 작성
            Scanner sc = new Scanner(System.in);
            System.out.println("사번을 입력하세요 : ");
            String empid = sc.nextLine();
            // 사용자가 입력받은 이엠피 아이디를 쿼리문으로 작성
            // 쿼리 문을 직접 작성하면 심각한 오류가 발생할 수 있다. 스테이트먼트는 입력을 받아서 쿼리문을 작성하는데
            // 보안공격에 취약할 수 있다. 쿼리문에 맞게 조작해서 if가 아닌 while로 사용자 입력란을
            // 조작해서 모든 직원의 정보가 유출될 수 있다.
            String query = "select emp_id, emp_name from employee where emp_id = '" + empid + "'";
            /* SQL Injection(SQL 주입) 공격 : 사용자가 입력 필드를 통해 데이터베이스에 임의의 SQL 코드를 삽임하여 실행하는 공격 기범
            * 200' or '1'='1을 입력하면 조건절이 무조건 true가 되어 모든 직원의 정보를 반환 받을 수 있다. */

            System.out.println(query); // 출력값 select emp_id, emp_name from employee where emp_id = '200'

            /* 5. executeQuery()로 쿼리 실행하고 ResultSet으로 반환 받음 */
            rest = stmt.executeQuery(query); // 쿼리문에 전달해줬기 때문에 쿼리를 담아준다.


            /* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내어 출력 */
            while (rest.next()) {
                System.out.println(rest.getString("emp_id") + ", " + rest.getString("emp_name"));
            }/*else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 7. 사용한 자원 반납*/
            close(rest);
            close(stmt);
            close(con);
        }
    }
}
