package com.yedam.java.ch0603;

public class Car {
	//필드
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	//생성자
	Car(){
		this("현대자동차", "그랜져", "검정");
		//this.company = "현대자동차";
		//this.model = "그랜져";
		//this.color = "검정";
		//this.maxSpeed = 300;
	}
	
	Car(String company){
		this("현대자동차", "그랜져", "검정");
	}
	
	Car(String company, String model){
		this(company, model, "검정");
		
	}
	
	Car(String company, String model, String color){
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = 300;
	}
}
