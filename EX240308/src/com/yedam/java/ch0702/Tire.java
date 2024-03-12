package com.yedam.java.ch0702;

public class Tire {
	//필드
	public int maxRotation; //최대회전수
	public int accumulatiedRotation; //누적 회전수
	public String location; //타이어 위치
	
	//생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		accumulatiedRotation++;
		if(accumulatiedRotation < maxRotation) {
			System.out.printf("%s Tire 수명 : %d회\n", location, (maxRotation - accumulatiedRotation));
			return true;
		}else {
			System.out.printf("****%s Tire 펑크\n", location);
			return false;
		}
	}

}
