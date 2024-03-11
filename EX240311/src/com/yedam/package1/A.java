package com.yedam.package1;

public class A {
	B b;
	
	//필드
	public int field1;  //다되고
	int field2;  //default 는 같은 패키지에서
	private int field3; // 여기만 이 클래스만
	
	//생성자
	public A() {
		this.field1 = 100;
		this.field2 = 200;
		this.field3 = 3000;
		
		this.method1();
		this.method2();
		this.method3();
	}
	
	public A(boolean t) {}
	A(int b){}
	private A(String s) {}
	
	A a1 = new A(true);	
	A a2 = new A(100);	
	A a3 = new A("문자열");	
	//메소드
	public void method1() {}
	void method2() {}
	private void method3() {}
	

}
