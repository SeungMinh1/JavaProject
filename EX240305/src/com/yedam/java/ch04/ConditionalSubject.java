package com.yedam.java.ch04;

import java.util.Scanner;

public class ConditionalSubject {

	public static void main(String[] args) {

		// 문제1) 책 161페이지 5번, for문을 이용해서 다음과 같이 *를 출력하는 코드를 작성해보세요.
		// *
		// **
		// ***
		// ****
		// *****
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.print("-------- for 1개사용시\n");
		
		String tree = "";
		for(int i = 1; i<=5; i++) {
			tree +="*";
			System.out.println(tree);
		}
		
		
		// 문제2) 책 160페이지 2번, for문을 이용해서 1부터 100까지의 정수 중에서 2의 배수가 아닌 숫자의 개수를 구하세요.
		//		 단, continue 문을 사용한다.
		System.out.print("\n--------문제2번\n");
		int count =0;
		for(int i = 1; i<=100; i++) {  //1~100
			if(i%2 == 0) continue;  //2의 배수이면 count하지않고 다시 반복문으로
			count++;
		}
		System.out.println("문제2번 답 : " +count);
		
		
		// 문제3) 책 161페이지 4번, 중첩 for문을 이용하여 방정식 4x+5y = 60의 모든 해 중 첫번째로 구해지는 값을 (x, y) 형태로 출력해보세요.
		//       단, x와 y는 10이하의 자연수입니다.
		boolean isSolution = false;
		System.out.print("\n--------문제3번\n");
		for(int x=1; x<=10; x++) {  // x범위 1~10까지 실행
			for(int y=1; y<=10; y++) { // y범위 1~10까지 실행
				if(4*x + 5*y != 60)continue; 	
				System.out.println("("+x+" ,"+y+")");// 4x +5y = 60이 아니라면 출력실행아 아니라 다시 반복문으로
				isSolution = true;
			}
			if(isSolution == true)break;
			
		}

		
		// 문제4) do ~ while문과 Math.random()함수를 이용하여 1 ~ 10의 정수 중 7이라는 수가 나올때까지 숫자를 출력하는 코드를 작성해보세요.
		System.out.print("\n--------문제4번\n");
		int num; 
		do {
			num = (int) (Math.random() * 10 + 1); //1~10난수 생성
			System.out.println(num);
		}while(num != 7); // num이 7이아니라면 동작반복
		
		
		// 문제5) 책 161페이지 3번, while문과 Math.random() 함수를 이용해서 2개의 주사위를 던졌을때 나오는 숫자를 (숫자1, 숫자2) 형태로 출력하고,
		//		 숫자의 합이 5가 아니면 계속 주사위를 던지고, 숫자의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
		//		 또한 주사위를 몇번 던졌는지. 횟수를 출력하세요.
		//		 숫자의 합이 5가 되는 조합은 (1,4), (4,1), (2,3),(3,2)
		System.out.print("\n--------문제5번\n");
		int trytime = 1;
		while(true) {
			int num1 = (int) (Math.random() * 6 + 1); //1~6난수 생성 주사위1
			int num2 = (int) (Math.random() * 6 + 1); //1~6난수 생성 주사위2
			System.out.println("("+num1+", "+ num2+")");
			System.out.println("주사위 "+trytime + "회차"); //주사위를 몇번 던졌는지 휫수
			trytime++;
			if(num1 + num2 ==5) break;
		}
		
		//// 161페이지 문제 7번
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");
			
			int c = Integer.parseInt(sc.nextLine());
			
			if(c == 1) {
				System.out.print("예금액> ");
				balance += Integer.parseInt(sc.nextLine());
			}else if(c == 2) {
				System.out.print("출금액> ");
				int minus = Integer.parseInt(sc.nextLine());
				if(minus>balance) {
					System.out.println("잔액이 부족합니다.");
				}else balance -= minus;
				
			}else if(c== 3) {
				System.out.println("잔고액> " + balance);
			}else if(c== 4) {
				System.out.println("종료합니다");
				break;
			}else System.out.println("잘못된 번호입니다.");
			
		}
	}
}

