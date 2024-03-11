package com.yedam.java.extend;

public class SmartPhone extends CellPhone{
	
	boolean isConnected;
	String application;
	
	//생성자
	SmartPhone(String model, String color, boolean isConnected){
		super();//부모클래스 연산자 호출코드
		this.model = model;
		this.color = color;
		this.isConnected = isConnected;
	}
	
	void connectOn() {
		this.isConnected = true;
		System.out.println("인터넷이 연결되었습니다.");
	}
	void connectOff() {
		this.isConnected = false;
		System.out.println("인터넷의 연결이 종료되었습니다.");
	}
	void exeucteApp(String appName) {
		this.application = appName;
		System.out.printf("%s을 실행합니다.\n", this.application);
	}

}
