package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.dept.Department;
import com.yedam.java.dept.DeptDAO;

public class Deptmanagement {
	//필드
	private Scanner sc = null;
	private DeptDAO deptDAO = null;
	
	//생성자
	public Deptmanagement() {
		sc = new Scanner(System.in);
		deptDAO = DeptDAO.getInstance();
	}
	//메소드
	public void run() {
		while(true) {
			//메뉴출력
			menuPrint();
			//메뉴선택
			int menu = selectMenu();
			
			//각 메뉴별 실제 실행
			if(menu == 1) { //부서등록
				insertDept();
			}else if(menu == 2) { //부서수정
				updateDept();
			}else if(menu == 3) { //부서삭제
				deleteDept();
			}else if(menu == 4) { //부서정보조회
				selectDeptOne();
			}else if(menu == 5) { //부서전체조회
				selectDeptAll();
			}else if(menu == 9){
				end();
				break;
			}else {
				showError();
			}
		}
	}
	
	private void showError() {
		System.out.println("메뉴에서 선택하세요.");
	}
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void menuPrint() {
		String menu = "";
		menu += "1.부서등록 ";
		menu += "2.부서수정 ";
		menu += "3.부서삭제 ";
		menu += "4.부서조회 ";
		menu += "5.전체조회 ";
		menu += "9.종료";
		
		System.out.println("=========================");
		System.out.println(menu);
		System.out.println("=========================");
		
	}
	
	private int selectMenu() {
		System.out.print("선택 > ");
		return inputNumber();
	}
	
	private int inputNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하시오");
		}
		return num;
	}
	

	private void selectDeptAll() {
		//1.부서정보 전체조회
		List<Department> list= deptDAO.selectDeptAll();
		
		//2.결과처리
		//2-1 Success : 전체출력
		//2-2 Fail : 별도 메시지 출력
		if(list.isEmpty()) {
			System.out.println("데이터가 존재하지 않음");
		}else {
			System.out.println("부서번호 | 부서이름 | 부서장 | 위치번호");
			for(Department dept : list) {
				System.out.println(dept);
			}
		}
		
	}
	private void selectDeptOne() {
		// 1.보고자하는 부서번호 입력
		int deptId = inputDeptId();
		
		// 2. 해당 부서번호로 단건조회
		Department dept = deptDAO.selectDeptInfo(deptId);
		
		//2.결과처리
		//2-1 Success : 출력
		//2-2 Fail : 별도 메시지 출력
		if(dept == null) {
			System.out.println("해당 부서는 존재하지 않습니다.");
		}else {
			System.out.println("부서번호 | 부서이름 | 부서장 | 위치번호");
			System.out.println(dept);
		}
	}
	
	private int inputDeptId() {
		System.out.print("부서번호 > ");
		return inputNumber();
	}
	
	private void deleteDept() {
		// 1.보고자하는 부서번호 입력
		int deptId = inputDeptId();
		// 2. 해당 부서번호로 삭제진행
		int result = deptDAO.deleteDeptInfo(deptId);
		
		//추가 프로세스 - 삭제할껀지 다시 확인받는 과정
		boolean isDeleted = checkDeptDelete(deptId);
		if(!isDeleted) return;
		

		//2.결과처리
		//2-1 Success : 성공메세지 출력
		//2-2 Fail : 실패 메시지 출력
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다.");
			System.out.println("부서번호 : " + deptId);
		}else {
			System.out.println("정상적으로 삭제되지 않았습니다.");
			System.out.println("정보를 확인해 주세요.");
		}
	}
	
	private boolean checkDeptDelete(int deptId) {
		//추가 삭제하고자 하는 부서정보 출력
		Department dept = deptDAO.selectDeptInfo(deptId);
		System.out.println("부서번호 | 부서이름 | 부서장 | 위치번호");
		System.out.println(dept);
		//추가 다시한번 삭제여부를 확인
		boolean isSelected = false;
		System.out.println("삭제를 진행하시겠습니까? ");
		System.out.print("Y/N > ");
		String result = sc.nextLine();
		if(result.equals("Y")) {
			isSelected = true;
		}
		return isSelected;
	}
	
	
	
	private void updateDept() {
		// 1.수정하고자 하는 정보입력 : 부서번호, 부서이름
		Department dept = inputDeptInfo();
		// 2. 해당 정보로 업데이트 진행
		int result = deptDAO.updateDeptInfo(dept);
		// 3. 결과처리(sucess/fail 구분)
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("정상적으로 수정되지 않았습니다.");
			System.out.println("정보를 확인해 주세요.");
		}
		
	}
	
	private Department inputDeptInfo() {
		System.out.print("부서번호 > ");
		int deptId = Integer.parseInt(sc.nextLine());
		System.out.println("부서이름 > ");
		String deptName = sc.nextLine();
		
		Department dept = new Department();
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(deptName);
		
		return dept;
	}
	
	private Department inputDeptAll() {
		Department dept = new Department();
		System.out.print("부서번호 > ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서이름 > ");
		dept.setDepartmentName(sc.nextLine());
		System.out.print("부서장 > ");
		dept.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("위치번호 > ");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));
		
		return dept;
	}
	
	
	private void insertDept() {
		// 1. 부서정보 전체 입력
		Department dept = inputDeptAll();
		// 2. 해당 정보를 등록
		int result = deptDAO.insertDeptInfo(dept);
		// 3. 결과 처리
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("정상적으로 수정되지 않았습니다.");
			System.out.println("정보를 확인해 주세요.");
		}

	}
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
