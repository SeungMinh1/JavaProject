package com.yedam.java.exam;

import java.util.Scanner;

public class WorkExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Work[] workList = new Work[10];
		int current = 0;
		
		while(run) {
			System.out.println("================================================");
			System.out.println(" 1.할일추가 | 2.할일확인 | 3.할일완료 |4.전체목록 | 5.종료");
			System.out.println("================================================");
			System.out.print("메뉴선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 1) { //할일추가
				System.out.print("할일추가> ");
				String dowork = sc.nextLine();
				Work work = new Work(dowork);
				workList[current] = work;
				current++;
			}else if(menu ==2) { //할일확인
				for(int i=0; i<current; i++) {
					Work work = workList[i];
					if(work.getCompletion()) continue;
					
					String content = work.getworkContent();
					System.out.printf("%d, %s\n", i, content);
					}
			
			}else if(menu ==3) { //할일완료  
				System.out.print("완료할 일> ");
				int selected = Integer.parseInt(sc.nextLine());
				
				workList[selected].isCompleted();
				workList[selected].printWork();
				
			}else if(menu ==4) { //전체목록
				for(int i=0; i<current; i++) {
					workList[i].printWork();
				}
			}else if(menu ==5) {
				System.out.print("프로그램을 종료합니다.");
				run = false;
			}else {
				System.out.print("메뉴를 잘못 입력했습니다.");
			}
			
		}

	}

}
