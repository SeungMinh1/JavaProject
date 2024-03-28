package com.yedam.enrolment;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.center.CenterMember;
import com.yedam.java.common.DAO;

public class EnrolmentDAO extends DAO {
	
	//싱글톤
	private static EnrolmentDAO enrolmentDAO = null;
		
	private EnrolmentDAO() {}
	
	public static EnrolmentDAO getInstance() {
		if(enrolmentDAO == null) {
			enrolmentDAO = new EnrolmentDAO();
		}
		return enrolmentDAO;
	}
	

	//  등록
	public void insertEnrolment(EnrolmentInfo enrol) {
		try {
			// 1. DB와 연결
			connect();
			

			String insert = "INSERT into enrolment (member_id, class_title) "
					+ "VALUES(?,?)";
	
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, enrol.getMemberId());
			pstmt.setString(2, enrol.getClassTitle());
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			//System.out.println("Insert 결과 : " + result);
			System.out.println("신청되었습니다.");
			numberPlus(enrol.getClassTitle());

			
			// 5. 자원해제
			disconnect();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 신청한 과목입니다.");
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("과목을 정확히 입력하세요");
		}
		
	}
	
	
	// 삭제
	public void deleteEnrolment(String id, String title) {
		
		try {
			// 1. DB와 연결
			connect();
			String delete = "DELETE FROM enrolment "
					+ "WHERE member_id = '" + id + "'"
					+ "AND class_title = '" + title + "'";

			stmt = conn.createStatement();
			

			int result = stmt.executeUpdate(delete);

			numberMinus(title);
			if(result == 1) {
				System.out.println("취소되었습니다.");
			}else {
				System.out.println("취소되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
	}
	
	
	// 검색 전체검색
	public List<EnrolmentInfo> selectEnrolmentALL(String id) {
		List<EnrolmentInfo> list = new ArrayList<>();
		try {
			// 1. DB와 연결
			connect();
			
			stmt = conn.createStatement();
			
			String select = "SELECT * "
							+ "FROM enrolment "
							+ "WHERE member_id = '" + id +"'"
							+ "ORDER BY 1 ";
			
			// 4. SQL 실행하기 - SELECT문
			
			rs = stmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			while(rs.next()) {
				EnrolmentInfo enrol = new EnrolmentInfo();
				enrol.setMemberId(rs.getString("member_id"));
				enrol.setClassTitle(rs.getString("class_title"));
				list.add(enrol);
			}

		}catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("정확한 과목명을 입력해주세요");
		}finally {
			//자원해제
			disconnect();
		}
		return list;
	}

	
	public void numberPlus(String title) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String cplus = " UPDATE education_class "
					+ "SET current_num = current_num+1 "
					+ "WHERE title = ? ";
			
			pstmt = conn.prepareStatement(cplus);
			pstmt.setString(1, title);
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			//System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
			
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("왜안되지");
		}
		
	}
	
	public void numberMinus(String title) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String cplus = " UPDATE education_class "
					+ "SET current_num = current_num-1 "
					+ "WHERE title = ? ";
	
			pstmt = conn.prepareStatement(cplus);
			pstmt.setString(1, title);
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			//System.out.println("Insert 결과 : " + result);
			
			// 5. 자원해제
			disconnect();
			
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("왜안되지");
		}
		
	}

	public int countMaxnum(String title) {
		int result = 0;
		try {
			// 1. DB와 연결
			connect();

			String cplus  = " SELECT max_num FROM education_class "
					+ "WHERE title = ? ";
	
			pstmt = conn.prepareStatement(cplus);
			pstmt.setString(1, title);
			
			result = pstmt.executeUpdate();
			
			
			//System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("왜안되지");
		}
		return result;
	}
	
	
	public int countCurrentnum(String title) {
		int result = 0;
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String cplus  = " SELECT current_num FROM education_class "
					+ "WHERE title = ? ";
	
			pstmt = conn.prepareStatement(cplus);
			pstmt.setString(1, title);
			
			result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			//System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("왜안되지");
		}
		return result;
	}
	
	// 검색 전체검색
	public List<EnrolmentInfo> EnrolmentALL() {
		List<EnrolmentInfo> list = new ArrayList<>();
		try {
			// 1. DB와 연결
			connect();
			
			stmt = conn.createStatement();
			
			String select = "SELECT * "
							+ "FROM enrolment "
							+ "ORDER BY 1 ";
			
			// 4. SQL 실행하기 - SELECT문
			
			rs = stmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			while(rs.next()) {
				EnrolmentInfo enrol = new EnrolmentInfo();
				enrol.setMemberId(rs.getString("member_id"));
				enrol.setClassTitle(rs.getString("class_title"));
				list.add(enrol);
			}

		}catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("정확한 과목명을 입력해주세요");
		}finally {
			//자원해제
			disconnect();
		}
		return list;
	}
		
	// 수강 과목수 조회
	public int countClasstitle(String id) {
		int result = 0;
		int a = 0;
		try {
			// 1. DB와 연결
			connect();

			String countt  = " SELECT COUNT(*) as cnt FROM enrolment "
					+ "WHERE member_id = '" + id +"' "
					+ "GROUP BY member_id ";
	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(countt);
			
			if(rs.next()) {
				a = rs.getInt("cnt");
			}
			
			disconnect();
		}
		catch(SQLException e) {
			e.printStackTrace();
//			System.out.println("왜안되지");
		}
		return a;
	}
	
	
//  클래스 타이틀    
	public void updateCountClass(int i, String id) {  // 비밀번호 변경
		try {
			// 1. DB와 연결
			connect();
			
			String update = "UPDATE center_member "
					+ "SET COUNT_CLASS = ? "
					+ "WHERE id = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, i);
			pstmt.setString(2, id);
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("UPDATE결과 : " + result);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//5.자원해제
			disconnect();
		}
	}
	
	public String selectIDtitle(String id) {
		String a = null;
		try {
			// 1. DB와 연결
			connect();
			
			String select = "SELECT class_title "
					+ "FROM enrolment "
					+ "WHERE member_id = ? ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				a = rs.getString("class_title");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return a;
	
	}
	
	
	
	
	
	
	
	
	
	/*
	// 1) 등록
		public void insertEnrolment(EnrolmentInfo enrol) {
			try {
				// 1. DB와 연결
				connect();
				

				String insert = "INSERT into enrolment (member_id, class_title) "
						+ "VALUES(?,?)";
		
				pstmt = conn.prepareStatement(insert);
				pstmt.setString(1, enrol.getMemberId());
				pstmt.setString(2, enrol.getClassTitle());
				
				
				//  => 실제 쿼리문이 완성됨
				
				// 4. SQL 실행하기 - SELECT문
				
				int result = pstmt.executeUpdate();
				
				// 5. 결과값 처리하기
				
				System.out.println("Insert 결과 : " + result);
				if(countMaxnum(enrol.getClassTitle()) >= countCurrentnum(enrol.getClassTitle()) ) {
					String error = "더이상 수강할수 없습니다.";
					System.out.println();
				}else {
					
					
					
					numberPlus(enrol.getClassTitle());
				}
				
				
				// 5. 자원해제
				disconnect();
				
			}catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("이미 신청한 과목입니다.");
			}
			catch(SQLException e) {
				//e.printStackTrace();
				System.out.println("과목을 정확히 입력하세요");
			}
			
		}
		*/


}
