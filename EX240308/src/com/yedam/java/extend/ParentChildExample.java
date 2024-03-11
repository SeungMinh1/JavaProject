package com.yedam.java.extend;

public class ParentChildExample {
	public static void main(String[] args) {
		
		ChildClass first = new ChildClass();
		System.out.println("부모 이름 : " + first.name);
		System.out.println("부모 나이 : " + first.age);
		System.out.println("부모 직업 : " + first.job);
		System.out.println("자식 회사 : " + first.company);
	}
}
