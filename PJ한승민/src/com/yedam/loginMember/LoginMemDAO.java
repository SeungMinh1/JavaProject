package com.yedam.loginMember;

import java.sql.SQLException;


import com.yedam.java.common.DAO;

public class LoginMemDAO extends DAO {
	
	//싱글톤
	private static LoginMemDAO loginmemDAO = null;
	private LoginMemDAO() {}
	public static LoginMemDAO getInstance() {
		if(loginmemDAO == null) {
			loginmemDAO = new LoginMemDAO();
		}
		return loginmemDAO;
	}
	
	//CRUD
	public LoginMem selectOne(LoginMem members) {
		LoginMem loginInfo = null;
		
		try {
			//DB연결
			connect();
			//SQL문
			String sql = "SELECT * "
					   + "FROM member "
					   + "WHERE id = '" + members.getId() +"'"; 
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				//아이디 존재
				if(rs.getString("pwd").equals(members.getPwd())){
					//비밀번호 일치 -> 로그인 성공
					loginInfo = new LoginMem();
					loginInfo.setId(rs.getString("id"));
					loginInfo.setPwd(rs.getString("pwd"));
					loginInfo.setMemberRole(rs.getInt("member_role"));
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}	
		return loginInfo;
	}
	
	// 등록
	public void insertLoginMember(LoginMem members) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String insert = "INSERT into center_member (id, pwd, member_role)  "
					+ "VALUES(?,?,?)";
	
			pstmt = conn.prepareStatement(insert);
			
			pstmt.setString(1, members.getId());
			pstmt.setString(2, members.getPwd());
			pstmt.setInt(3, members.getMemberRole());

			
			//  => 실제 쿼리문이 완성됨
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
