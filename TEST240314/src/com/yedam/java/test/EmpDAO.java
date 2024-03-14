package com.yedam.java.test;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	//필드
	private List<Employee> list;
	
	//생성자
	public EmpDAO() {
		this.list = new ArrayList<>();
	}
	
	//메소드
	
	public void addEmpInfo(Employee employee) {  //추가
		list.add(employee);
	}
	
	public void updateSalary(int id, int salary) { //수정
		for(int i=0; i<list.size(); i++) {
			Employee selectEmp = list.get(i);
			if(id == selectEmp.getId()) {
				selectEmp.setSalary(salary);
			}
		}
	}
	
	public void delEmpInfo(int id) {  //삭제
		for(int i=0; i<list.size(); i++) {
			Employee selectEmp = list.get(i);
			if(id == selectEmp.getId()) {
				list.remove(i);
			}
		}
	}
	
	public void searchHireDate(String hireDate) {  //조회
		Employee selected = null;
		for(Employee employee : list) {
			if(hireDate.equals(employee.getHireDate())) {
				selected = new Employee();
				selected.setId(employee.getId());
				selected.setName(employee.getName());
				selected.setPhone(employee.getPhone());
				selected.setHireDate(employee.getHireDate());
				selected.setSalary(employee.getSalary());
				System.out.println(employee.getId() + " "+ employee.getName() + " " +employee.getPhone()+" "+employee.getHireDate()+" "+employee.getSalary());
			}
		}
		
	}
	
	public void printEmpAll() { //전체출력
		for(Employee employee : list) {
			System.out.println(employee.getId() + " "+ employee.getName() + " " +employee.getPhone()+" "+employee.getHireDate()+" "+employee.getSalary());
		}
		
	}
	
	
	
	
	
	
	

}
