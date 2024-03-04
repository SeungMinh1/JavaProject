package com.yedam.java.ch03;

import java.util.Scanner;

public class OperatorExample {

	public static void main(String[] args) {
		//부호연산자
		int a = -100;
		int result1 = -a;
		int result2 = +a;
		System.out.println("res1 : " + result1);
		System.out.println("res2 : " + result2);
		
		byte b =-100;
		int result3 = -b;
		System.out.println("res3 : " + result3);
		
		//증감연산자
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("------------");
		x++;
		System.out.println("x : " + x);
		++x;
		System.out.println("x : " + x);
		
		z = x++;
		System.out.println("z : " + z + " x : " + x);
		z = ++x;
		System.out.println("z : " + z + " x : " + x);
		System.out.println("------------");
		x = 5;
		y = 5;
		z = ++x + y--;  //6+5=11  --5  4
		System.out.println("z : " + z + " x : " + x + " y : " + y);
		System.out.println("------------");
		int e = 10;
		int f = 3;
		int g;
		g = e/f;
		System.out.println("g : " + g);
		g = e%f;
		System.out.println("g : " + g);
		
		//비교연산자 & 논리연산자
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하시오 : ");
		String value  = sc.nextLine();
		char charVal = value.charAt(0);
		System.out.println(charVal);
		//대문자  유니코드 65~90
		if(65<=charVal && charVal<=90) {
			System.out.println("대문자입니다.");
		}else if(97<=charVal && charVal<=122) { //소문자 유니코드 97~122
			System.out.println("소문자입니다.");
		}else if(47<charVal & charVal<58) { //숫자 0~9 유니코드 48~57
			System.out.println("숫자입니다.");
		}
		sc.close();
		System.out.println("------------");
		
		// 복합 대입연산자
		int res=10;
		System.out.println("res = " + res);
		res +=10;
		System.out.println("res = " + res);
		res *=2;
		System.out.println("res = " + res);
		res /=3;
		System.out.println("res = " + res);
		res %=4;
		System.out.println("res = " + res);
		
		//삼항연산자
		String result22 = (res>10) ? "A" : "B";
		System.out.println("res = " + result22);
		

	}

}
