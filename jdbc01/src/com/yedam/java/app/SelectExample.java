package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.JDBC Driver 로딩하기
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 서버 접속하기
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//conn.setAutoCommit(false);
		//conn.commit();
		//conn.rollback();
		
		// 3. Statement or PreparedStatment 객체 생성하기 
		String sql = "SELECT * "           //sql 에서 실행해보고 세미콜록 제외하고 복사
				+ "FROM employees";
		
		Statement stmt = conn.createStatement();
		
		// 4. SQL 실행하기 - SELECT문
		
		ResultSet rs = stmt.executeQuery(sql);    // ResultSet은 
		
		// 5. 결과값 처리하기
		
		while(rs.next()) {
			String name = "이름 : " + rs.getString("first_name") //컬럼 위치 숫자도 가능, 별칭도가능
						+	","	  + rs.getString("last_name");
			System.out.println(name);
		}
		
		// 6. 자원 해제하기
		
		if(rs != null)rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		
		
		
		
		
		
	}

}
