package com.yedam.java.ch0502;

import java.util.Scanner;

public class AccountExample {

	public static void main(String[] args) {
		
		//// 161페이지 문제 7번
		boolean run = true; //프로그램 실행여부
		int account = 0; //프로그램이 가지는 값
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			if(choice == 1) {
				System.out.print("예금액> ");
				account += Integer.parseInt(sc.nextLine());
			}else if(choice == 2) {
				System.out.print("출금액> ");
				int minus = Integer.parseInt(sc.nextLine());
				if(minus>account) {
					System.out.println("잔액이 부족합니다.");
				}else account -= minus;
				
			}else if(choice== 3) {
				System.out.println("잔고액> " + account);
			}else if(choice== 4) {
				System.out.println("종료합니다");
				run = false;
			}else System.out.println("잘못된 번호입니다.");
			
		}

	}

}
