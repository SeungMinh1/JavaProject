package com.yedam.package3;

public class Car {
	
	//필드
	private int speed;
	private boolean stop;
	
	
	//생성자
	
	//메소드 - getter/setter
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int speed) {
		if(speed>0) {
			this.speed = speed;
		}else {
			this.speed = 0;
		}
		
	}
	
	public boolean isstop() {
		return this.stop;
	}
	public void setstop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}

}
