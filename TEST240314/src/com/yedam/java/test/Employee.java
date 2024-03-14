package com.yedam.java.test;

public class Employee {
	//필드
	private int id; //사원번호
	private String name; //사원이름
	private String phone; //연락처
	private String hireDate; //입사일
	private int salary; //급여
	
	//생성자
	public Employee() {};
	public Employee(int id, String name, String phone, String hireDate, int salary) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	
	//메소드  getter / setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
