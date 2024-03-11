package com.yedam.package2;

import com.yedam.package1.*;

public class C {
	A a;
	B b;

	public C() {
		a.field1 = 100;
		a.field2 = 100; // 다른 패키지 다른클래스
		a.field3 = 100;

		a.method1();
		a.method2();
		a.method3();

		A a1 = new A(true);
		A a2 = new A(100);
		A a3 = new A("문자열");
	}

}
