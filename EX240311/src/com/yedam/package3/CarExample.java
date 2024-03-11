package com.yedam.package3;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(-50);
		
		System.out.println("현재속도 "+ myCar.getSpeed());
		
		myCar.setSpeed(60);
		if(!myCar.isstop()) {
			myCar.setstop(true);
		}
		
		System.out.println("현재속도 "+ myCar.getSpeed());
	}

}
