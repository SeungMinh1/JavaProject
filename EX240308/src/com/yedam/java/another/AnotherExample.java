package com.yedam.java.another;

import com.yedam.java.extend.ChildClass;

public class AnotherExample {

	public static void main(String[] args) {
		AnotherChildClass second = new AnotherChildClass();
		//System.out.println("부모 이름 : " + second.name);
		//System.out.println("부모 나이 : " + second.age);
		//System.out.println("부모 직업 : " + second.job);
		System.out.println("자식 집 : " + second.home);
	}

}
