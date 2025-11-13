package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 사번을 입력하세여 :");
        String empId = sc.nextLine();
        /* ? : 위치홀더 */
        String Query = "select emp_id, emp_name from employee where emp_id = ?";

        try {
            // 확정된 상태로 pstmt를 생성
            pstmt = con.prepareStatement(Query);

            // 첫 번째 '?' 자리에 empId로 값을 채운다.
            // 사용자 값과 완전히 분리해서 데이터베이스로 보내기 때문에 문자열데이터로 받기 때문에 Sql 주입공격을 원천적으로 막는다.
            pstmt.setString(1, empId);

            rset = pstmt.executeQuery();

            if(rset.next()) {
                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));
            }else {
                System.out.println("해당 사원의 조회 결과가 없습니다. ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
