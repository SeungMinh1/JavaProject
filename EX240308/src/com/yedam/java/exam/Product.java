package com.yedam.java.exam;

public class Product {
	
	//필드
	private String name;
	private int price;
	
	//생성자
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	//메서드
	public String getproductN() {
		return this.name;
	}
	public int getproductP() {
		return this.price;
	}
	public void setproduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public void setproduct(String name) {
		this.name = name;
	}
	public void setproduct(int price) {
		this.price = price;
	}

}
