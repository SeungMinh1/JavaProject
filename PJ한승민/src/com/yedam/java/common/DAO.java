package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	//Oracle(DB) 연결정보
		protected String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		protected String oracleUrl = "jdbc:oracle:thin:@192.168.0.14:1521:xe";
		protected String connectedId = "hr";
		protected String connectedPwd = "hr";
		
		//각 메소드에서 공통적으로 사용하는 전역 필드
		protected Connection conn = null;
		protected PreparedStatement pstmt = null;
		protected Statement stmt = null;
		protected ResultSet rs = null;
		
		//생성자       
		protected DAO() {}
		
		//메소드
		//DB연결
		protected void connect() {
			try {
				//1.JDBC Driver 로딩하기
				Class.forName(jdbc_driver);
				//2. DB 서버 접속하기
				conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver Loading Fail");
			}catch(SQLException e) {
				System.out.println("DB Connect Fail");
				System.out.println(e.getMessage());
			}
			
		}
		
		// 2) DB와 해제 
		protected void disconnect() {
			try {
				//자원해제
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
