package com.yedam.java.generic;

import com.yedam.java.ch0802.Phone;
import com.yedam.java.ch0802.SmartPhone;

public class BoxExample {
	
	public static void main(String[] args) {
		Box<String, Integer> sBox = new Box<>();
		
		sBox.setProduct("커피");
		sBox.setCount(10);
		
		String prd = sBox.getProduct();
		Integer count = sBox.getCount();
		
		Box<Phone, Integer> pBox = new Box<>();
		sBox.setProduct(new SmartPhone("Hong"));
		Phone p = sBox.getProduct();
	}

}
