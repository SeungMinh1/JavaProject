package com.yedam.java.ch0703;

public abstract class Phone {
	//필드
	protected String owner;
	
	//생성자
	public Phone(String owner) {
		this.owner = owner;
	}
	//매소드
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	//추상메소드
	public abstract void execute();
	
}
