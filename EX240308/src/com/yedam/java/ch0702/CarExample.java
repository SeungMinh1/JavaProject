package com.yedam.java.ch0702;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		myCar.changedTire(1, new HankookTire("앞왼쪽", 10));
		myCar.changedTire(2, new KumhoTire("앞오른쪽", 10));
		myCar.run();
		myCar.changedTire(4, new HankookTire("뒤오른쪽", 5));
		myCar.run();
	}

}
