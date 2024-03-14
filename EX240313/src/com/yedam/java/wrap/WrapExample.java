package com.yedam.java.wrap;

import java.util.ArrayList;
import java.util.List;

public class WrapExample {

	public static void main(String[] args) {
		int i = 1000;
		//boxing : 전통적인 포장
		Integer a = Integer.parseInt("1234");
		//unboxing : 자동
		int j = a;
		//boxing : 자동
		Integer b = j;
		
		List<Integer> list = new ArrayList<>();
		list.add(1000);
		list.add(1234); //자동 박싱
		int result = list.get(0); //자동 언박싱
		
	}

}
