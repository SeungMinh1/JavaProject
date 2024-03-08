package com.yedam.java.ch0605;

public class InstanceStaticExample {
	
	//필드
	String msg = "Hello, Java!!"; //인스턴스 필드
	static String week = "Today is Friday"; //정적 필드
	//메소드
	void printMsg() {
		System.out.println("msg : " + this.msg);
		System.out.println("week : " + InstanceStaticExample.week);
	}

	public static void main(String[] args) { //정적메소드
		//정적 메소드     => this 사용안됨
		//System.out.println("msg : " + this.msg);
		InstanceStaticExample ise = new InstanceStaticExample();
		System.out.println("week : " + InstanceStaticExample.week);
		
		//인스턴스 멤버
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
		
		System.out.println("===========================");
		//정적 멤버
		double result = 10*10*Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		System.out.println(result+ " " + result2 +" "+result3);
	}

}
