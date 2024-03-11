package com.yedam.package1;

public class B {
	A a = new A();
	
	B(){  //같은 패키지 다른 클래스
		a.field1 = 100;
		a.field2 = 200;
		a.field3 = 3000;
		
		a.method1();
		a.method2();
		a.method3();
		
		A a1 = new A(true);	
		A a2 = new A(100);	
		A a3 = new A("문자열");	
	}
	

}
