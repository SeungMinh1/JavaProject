package com.yedam.java.date;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("%d년 %2d월 %2d일 ", year, month, day);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String strweek = null;
		
		switch(week) {
		case Calendar.MONDAY:
			strweek = "월";
			break;
		case Calendar.TUESDAY:
			strweek = "화";
			break;
		case Calendar.WEDNESDAY:
			strweek = "수";
			break;
		case Calendar.THURSDAY:
			strweek = "목";
			break;
		case Calendar.FRIDAY:
			strweek = "금";
			break;
					
		}
		
	
		
		
		
	}

}
