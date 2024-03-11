package com.yedam.java.extend;

public class ParentClass {
	private String name = "Kang";
	protected int age = 45; // protected 랑 default가 사실상 같음
	String job = "교사";
	
	ParentClass(){
		System.out.println("부모 클래스 생성");
		System.out.printf("%s, %d, %s\n", name, age, job);
	}
}
