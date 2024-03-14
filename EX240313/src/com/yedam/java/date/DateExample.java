package com.yedam.java.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		
		Date joinDate = new Date("2024/03/10");
		System.out.println(joinDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String result = sdf.format(joinDate);
		System.out.println(result);
		
		Date today = new Date();
		result = sdf.format(today);
		System.out.println(result);
		
		
		
		
	}

}
