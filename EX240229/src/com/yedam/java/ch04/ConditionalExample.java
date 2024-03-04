package com.yedam.java.ch04;

public class ConditionalExample {

	public static void main(String[] args) {
		
		int score = 93;
		
		//90점이상 등급 A로 할당
		if(score >=90) {
			System.out.println("A등급 입니다.");
		}else {
			System.out.println("90점미만임.");
		}
		
		if(score >=90) {
			System.out.println("90점 이상 A등급 입니다.");
		}else if(score >=80) {
			System.out.println("80점 이상 B등급 입니다.");
		}else if(score >=70) {
			System.out.println("70점 이상 C등급 입니다.");
		}else if(score >=60) {
			System.out.println("60점 이상 D등급 입니다.");
		}else {
			System.out.println("F등급 입니다.");
		}
		
		// 0~10까지 랜덤수 (Math.random()*10)  1~11 은 +!
		int num = (int) (Math.random() * 6) + 1;  // 0~1 사이의 랜덤한수생성
		
		if(num ==1) {
			System.out.println("현재값은 1입니다.");
		}else if(num ==2) {
			System.out.println("현재값은 2입니다.");
		}
		else if(num ==3) {
			System.out.println("현재값은 3입니다.");
		}
		else if(num ==4) {
			System.out.println("현재값은 4입니다.");
		}
		else if(num ==5) {
			System.out.println("현재값은 5입니다.");
		}else {
			System.out.println("현재값은 6입니다.");
		}
		
		switch(num) {
		case 1: System.out.println("현재값은 1입니다."); break;
		case 2: System.out.println("현재값은 2입니다."); break;
		case 3: System.out.println("현재값은 3입니다."); break;
		case 4: System.out.println("현재값은 4입니다."); break;
		case 5: System.out.println("현재값은 5입니다."); break;
		case 6: System.out.println("현재값은 6입니다."); 
		}
		
		char grade = 'a';
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("우수 회원입니다."); break;
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다."); break;
		default:
			System.out.println("손님입니다.");
		}
		
		
		

	}

}
