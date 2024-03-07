package com.yedam.java.ch01;

import java.util.Scanner;

public class Backtry7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		//String num2 = sc.next();
		//char[] num = new char[num1.length()];
		String num11 = "";
		for(int i=num1.length(); i>=0; i--) {
			num11 += num1.charAt(i);
		}
		System.out.println(num11);
		/*
		char temp = num1.charAt(0);
		num[0] = num[num1.length()-1];
		num[num1.length()-1] = temp;
		
		int num1to2 = num[0]+ num[1] + num[2]; 
		System.out.println(num1to2);
		//num1.charAt(0) = num1.charAt(num1.length);
		*/
	}

}
