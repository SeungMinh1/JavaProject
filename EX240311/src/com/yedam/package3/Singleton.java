package com.yedam.package3;

public class Singleton {

	private static Singleton instance = null;
	
	private Singleton(){
		System.out.println("인스턴스를 생성하였습니다.");
	}
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
