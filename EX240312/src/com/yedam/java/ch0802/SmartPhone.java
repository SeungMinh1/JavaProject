package com.yedam.java.ch0802;

public class SmartPhone implements Phone{

	public String owner;
	SmartPhone(String owenr){
		this.owner = owenr;
	}
	public void exeutedApp(String appName) {
		System.out.println(appName + "를 실행합니다.");
	}
	public void search(String keyword) {
		System.out.println(keyword + "를 실행합니다.");
	}
	@Override
	public void turnOn() {
		System.out.println("스마트폰을 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("스마트폰을 끕니다.");
		
	}

	@Override
	public void callTo(String name) {
		System.out.println(name +"에게 전화를 겁니다.");
		
	}
	@Override
	public void callFrom(String name) {
		System.out.println(name +"으로부터 전화가 옵니다.");
		
	}

}
