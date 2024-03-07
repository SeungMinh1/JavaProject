package com.yedam.java.ch0502;

import java.util.Scanner;

public class Homework0306 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int studentNum = 0;  //학생수
		int[] scores = null;
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(sc.nextLine()); //메뉴선택받기
			
			if(selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(sc.nextLine());  //학생수
				scores = new int[studentNum]; //입력받은 학생수만큼의 크기를 가진 배열생성
			}else if(selectNo == 2) {
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(sc.nextLine()); // 배열의 순서대로 점수 입력받음
				}
			}else if(selectNo == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i,scores[i]); // 배열을 순서대로 출력
				}
			}else if(selectNo == 4) {
				int max = 0; //최대값
				int sum = 0; //총합
				for(int i=0; i<scores.length; i++) {  //최대값 구하기
					if(max<scores[i]) {
						max = scores[i];
					}
					sum += scores[i]; // 총합
				}
				System.out.println("최고 점수> " + max); 
				
				double avg = (double)sum / scores.length; //평균(double형 출력을 위한 강제 타입변환)
				System.out.printf("평균 점수> %.3f\n", avg); 
			}else if(selectNo == 5) { // 프로그램 종료
				run = false;
			}else {
				System.out.println("잘못된 메뉴선택입니다."); 
			}
		}
		System.out.println("프로그램 종료");
	}
	

}
