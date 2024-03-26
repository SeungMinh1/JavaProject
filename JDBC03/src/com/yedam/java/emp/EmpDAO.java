package com.yedam.java.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yedam.java.common.DAO;

public class EmpDAO extends DAO {
	
	//싱글톤
	private static EmpDAO empDAO = null;  //밖에서 못쓰고 나만
	
	private EmpDAO() {}
	
	public static EmpDAO getInstance() {
		if(empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
		
	
	// 3) 전체조회 
	public List<Employee> selectEmpALL() {
			List<Employee> list = new ArrayList<>();
			try {
				// 1. DB와 연결
				connect();
				
				stmt = conn.createStatement();
				
				String select = "SELECT * "
								+ "FROM employees "
								+ "ORDER BY employee_id" ;
				
				// 4. SQL 실행하기 - SELECT문
				
				rs = stmt.executeQuery(select);
				
				// 5. 결과값 처리하기
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeid(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setHireDate(rs.getDate("hire_date"));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setCommissionPct(rs.getDouble("commission_pct"));
					emp.setManagerId(rs.getInt("manager_id"));
					emp.setDepartmentId(rs.getInt("department_id"));
					
					list.add(emp);
				}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//자원해제
				disconnect();
			}
			return list;
		}

		
		
	// 4) 단건조회 
	public Employee slectEmpInfo(int employeeID) {
			Employee emp = null;
			
			try {
				// 1. DB와 연결
				connect();
				
				String select = "SELECT * "
						+ "FROM employees "
						+ "WHERE employee_id = ? ";
				
				pstmt = conn.prepareStatement(select);
				pstmt.setInt(1, employeeID);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					emp = new Employee();
					emp.setEmployeeid(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setHireDate(rs.getDate("hire_date"));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setCommissionPct(rs.getDouble("commission_pct"));
					emp.setManagerId(rs.getInt("manager_id"));
					emp.setDepartmentId(rs.getInt("department_id"));
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//자원해제
				disconnect();
			}
			return emp;
		}
	
	
	// 5) 등록
	public void insertEmpInfo(Employee emp) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String insert = "INSERT INTO employees "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeid());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());
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
	
	// 6) 수정
	public void updateEmpInfo(Employee emp) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String update = "UPDATE employees "
					+ "SET salary = ? "
					+ "WHERE employee_id = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeid());
			
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
	// 7) 삭제
	public void deleteEmpInfo(int employeeID) {
		
		try {
			// 1. DB와 연결
			connect();
			String delete = "DELETE FROM employees "
					+ "WHERE employee_id = " + employeeID;

			stmt = conn.createStatement();
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = stmt.executeUpdate(delete);
			
			// 5. 결과값 처리하기
			
			System.out.println("Delete 결과 : " + result);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
	}
	
	
	

}
