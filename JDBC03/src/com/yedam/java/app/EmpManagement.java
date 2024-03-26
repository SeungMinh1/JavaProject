package com.yedam.java.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp.EmpDAO;
import com.yedam.java.emp.Employee;

public class EmpManagement {
	
	private Scanner sc = new Scanner(System.in);
	private EmpDAO empDAO = EmpDAO.getInstance();
	
	public void run() {
		
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			
			if(menuNo == 1) {
				insertEmp();
			}if(menuNo == 2) {
				 updateEmp();
			}if(menuNo == 3) {
				deleteEmp();
			}if(menuNo == 4) {
				selectEmpInfo();
			}if(menuNo == 5) {
				selectEmpAll();
			}if(menuNo == 9) {
				break;
			}
		}
		end();
	}
	
	// 메소드
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void menuPrint() {
		System.out.println("");
		System.out.println("====================================================");
		System.out.println("1.등록   2.수정  3.삭제  4.사원조회  5.사원전체조회  9.종료");
		System.out.println("====================================================");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			System.out.print("선택>> ");
			menuNo = sc.nextInt();
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	
	private void insertEmp() {
		Employee emp = inputAll();
		empDAO.insertEmpInfo(emp);
	}
	
	private void updateEmp() {
		Employee emp = inputInfo();
		empDAO.updateEmpInfo(emp);
	}
	
	private void deleteEmp() {
		int employeeId = inputEmpId();
		empDAO.deleteEmpInfo(employeeId);
	}
	
	private void selectEmpInfo() {
		int employeeId = inputEmpId();
		Employee emp = empDAO.slectEmpInfo(employeeId);
		System.out.println(emp);
	}
	
	private void selectEmpAll() {
		List<Employee> list = empDAO.selectEmpALL();
		for(Employee data : list) {
			System.out.println(data);
		}
	}
	
	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사번>>");
		emp.setEmployeeid(sc.nextInt());
		System.out.print("이름>>");
		emp.setFirstName(sc.next());
		System.out.print("성>>");
		emp.setLastName(sc.next());
		System.out.print("이메일>>");
		emp.setEmail(sc.next());
		System.out.print("전화번호>>");
		emp.setPhoneNumber(sc.next());
		// 입력형식 : YYYY-MM-DD
		System.out.print("입사일>>");
		emp.setHireDate(Date.valueOf(sc.next()));
		System.out.print("직급>>");
		emp.setJobId(sc.next());
		System.out.print("연봉>>");
		emp.setSalary(sc.nextInt());
		System.out.print("상여>>");
		emp.setCommissionPct(sc.nextDouble());
		System.out.print("상사>>");
		emp.setManagerId(sc.nextInt());
		System.out.print("부서>>");
		emp.setDepartmentId(sc.nextInt());
		
		return emp;
	}
	
	private int inputEmpId() {
		System.out.println("사번>>");
		int employeeId = sc.nextInt(); 
		return employeeId;
	}
	
	
	private Employee inputInfo() {
		Employee emp = new Employee();
		System.out.println("사번>>");
		emp.setEmployeeid(sc.nextInt());
		System.out.println("연봉>>");
		emp.setSalary(sc.nextInt());
		
		return emp;
		
	}
	
	
	

}
