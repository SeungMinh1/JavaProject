package com.yedam.java.ch0602;

public class MainExample {
	public static void main(String[] args) {
		//클래스 => 하나의 데이터 타입
		String str = null;
		
		Car myCar = new Car();  //인스턴스
		myCar.color = "grey";
		System.out.println(myCar.company);
		System.out.println(myCar.color);
		System.out.println(myCar.model);
		System.out.println(myCar.maxSpeed);
		
		
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.color);
		System.out.println(yourCar.model);
		System.out.println(yourCar.maxSpeed);
		
		//필드가 배열일경우
		yourCar.record = new String[5];
		yourCar.record[0] = "출고일자 : 2024-03-27";
		
		for(int i=0; i<yourCar.record.length; i++) {
			System.out.println(yourCar.record[i]);
		}
		int[][] intList = { {1,2,3}, {5,6,7}};
		System.out.println(intList[1][1]);
		
		
	}

}
