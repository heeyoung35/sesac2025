package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {

        /* XML 파엘에 별도로 입력 한 sql문을 통해 처리 */
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 한 행의 정보를 담을 DTO*/
        EmployeeDTO row = null;

        /* 여러 DTO 타입의 객체를 담을 List */
        List<EmployeeDTO> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 사원의 성을 입력하세요 :");
        String empName = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/ohgiraffers/section2/preparedstatement/employee-query.xml"));

            String query = prop.getProperty("selectEmpByFamilyName");
            System.out.println("query : " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empName);

            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while (rset.next()) {
                // 기본 생성자로 각 행의 데이터를 담을 빈 EmployeeDTO 만들기
                row = new EmployeeDTO();
                // resultSet에서 컬럼 값을 꺼내 DTO 각 필드에 채워넣는다.
                row.setEmpId(rset.getString("emp_id"));
                row.setEmpName(rset.getString("emp_name"));
                row.setEmpNo(rset.getString("emp_no"));
                row.setPhone(rset.getString("phone"));
                row.setDeptCode(rset.getString("dept_code"));
                row.setJobCode(rset.getString("job_code"));
                row.setSalLevel(rset.getString("sal_level"));
                row.setSalary(rset.getInt("salary"));
                row.setBonus(rset.getDouble("bonus"));
                row.setManagerId(rset.getString("manager_id"));
                row.setHireDate(rset.getDate("hire_date"));
                row.setEntDate(rset.getDate("ent_date"));

                // 정보가 채워진 DTO를 List에 추가
                empList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        for(EmployeeDTO emp : empList) {
            System.out.println(emp);
        }
    }
}
