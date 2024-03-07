package com.yedam.java.ch0601;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int studentNum = 0;
		ScoreManagement sm = null;
		
		while(run) {
			System.out.println("================================");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트");
			System.out.println(" 4.분석         | 5.종료");
			System.out.println("================================");
			
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) { //학생수
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(sc.nextLine());
				sm = new ScoreManagement(studentNum);
				
			}else if(selectNo == 2) { //점수입력
				for(int i=0; i<studentNum; i++) {
					System.out.printf("scores[%d]> ",i);
					int score = Integer.parseInt(sc.nextLine());
					sm.addScore(score);
				}
				
			}else if(selectNo == 3) { //점수리스트
				sm.printScoreList();
				
			}else if(selectNo == 4) { //분석 - 최대값, 평균값(=총합계/총갯수)
				int max = sm.calcMaxScore();			
				System.out.println("최고 점수 : " + max);
				
				double avg = sm.calcAvgScore();
				System.out.printf("평균 점수 : %.3f\n", avg);
				
			}else if(selectNo == 5) { //종료
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
