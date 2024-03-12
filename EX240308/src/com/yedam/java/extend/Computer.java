package com.yedam.java.extend;

public class Computer extends Calculator{
	
	@Override //메소드 어버라이딩 대상
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle()실행");
		return Math.PI *r *r;
	}
	
	double selectParentMethod(double r) {
		this.areaCircle(r);
		return super.areaCircle(r);
	}
	/*
	@Override
	void print() {
		System.out.println("자식 메소드입니다.");
	}
	*/
	

}
