package com.yedam.java.ch0502;
import java.util.Scanner;

public class BankExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		//프로그램에서 사용할 공용 변수
		int[] accountList = new int[20]; // 보유 계좌 목록
		int currentMax = 0; //현재 보유한 계좌 개수
		
		
			while(run) {
				//메뉴출력
				System.out.println("------------------------------------------------------");
				System.out.println("1.계좌개설 | 2.예금 | 3.출금 | 4.계촤이체 | 5.잔액조회 | 9.종료");
				System.out.println("------------------------------------------------------");
				System.out.print("선택> ");
				int menu = Integer.parseInt(sc.nextLine());  //sc.nextInt();
				if(menu ==1) { //계좌개설
					if(currentMax == accountList.length) { //accountList.lengt의 최대값은 20
						System.out.println("계좌를 생성할수 없습니다.");
						System.out.println("은행이 보유할 수 있는 계좌는 20개입니다.");
						continue;
					}else {
						currentMax++; //현재보유중인 계좌개수 증가
						int account = currentMax-1; //계좌번호 생성
						System.out.println("계좌를 개설했습니다.");
						System.out.println("계좌번호는 " +account +"입니다."); 
						accountList[account] = 0; //생성한 계촤 0으로 초기화
						}
					}else if(menu == 2){ //예금
						System.out.print("계좌번호를 입력하시오 :");
						int account = Integer.parseInt(sc.nextLine());  //계좌번호
						if(account>=currentMax) {  //생성한 계좌인지 확인
							System.out.println("없는 계좌입니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.print("입금할 금액을 입력하시오 : ");
						accountList[account] += Integer.parseInt(sc.nextLine());  //입금
						System.out.println("계좌 잔액은 : "+accountList[account]);
						
					}else if(menu == 3){ //출금
						System.out.print("계좌번호를 입력하시오 :");
						int account = Integer.parseInt(sc.nextLine()); //계좌번호
						if(account>=currentMax) { //생성한 계좌인지 확인
							System.out.println("없는 계좌입니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.print("출금할 금액을 입력하시오 : ");
						int money = Integer.parseInt(sc.nextLine()); //출금할돈
						accountList[account] -= money;  //출금
						if(money>accountList[account]) { //잔액확인
							System.out.println("잔액이 부족합니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.println("계좌 잔액은 : "+accountList[account]);
						
					}else if(menu == 4){ //계좌이체
						System.out.print("계좌번호를 입력하시오 :");
						int account = Integer.parseInt(sc.nextLine()); //계좌번호
						if(account>=currentMax) { //생성한 계좌인지 확인
							System.out.println("없는 계좌입니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.println("계좌 잔액은 : "+accountList[account]);
						System.out.print("이체할 계좌의 계좌번호를 입력하시오 :");
						int move = Integer.parseInt(sc.nextLine()); // 계좌이체할 계좌번호
						if(account>=currentMax) { //생성한 계좌인지 확인
							System.out.println("없는 계좌입니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.print("이체할 금액을 입력하시오 : ");
						int money = Integer.parseInt(sc.nextLine());  // 이체할 돈
						if(money>accountList[account]) { //잔액 확인
							System.out.println("잔액이 부족합니다. 메뉴로 돌아갑니다.");
							continue;
						}
						accountList[account] -= money; //출금
						accountList[move] += money;  //입금
					
					}else if(menu == 5){ //잔액조회
						System.out.print("계좌번호를 입력하시오 :");
						int account = Integer.parseInt(sc.nextLine()); //계좌번호
						if(account>=currentMax) { //생성한 계좌인지 확인
							System.out.println("없는 계좌입니다. 메뉴로 돌아갑니다.");
							continue;
						}
						System.out.println("계좌잔액은 : "+accountList[account]+"입니다."); //계좌 잔액
						
					}else if(menu == 9){ //종료
						System.out.println("종료합니다.");
						run = false;
					}else {
						System.out.println("잘못된 메뉴선택입니다.");
					}
				
		}
			/*
			다음 메뉴를 가지는 프로그램을 작성하세요.
			1) 메뉴는 다음과 같이 구성하세요.
			 1.계좌개설 | 2.예금 | 3.출금 | 4.계좌이체 | 5.잔액조회 | 9.종료
			2) 각 메뉴별 기능은 다음 요구사항을 만족하세요.
			[메뉴1] 계좌개설
			- 사용자가 새로운 계좌를 요청할 경우 
			  은행이 보유한 계좌를 추가하고 생성된 계좌번호를 안내합니다.
			- 해당 은행의 경우 최대 보유 계좌 수는 20입니다.(배열 사용)
			- 배열의 인덱스가 고유 계좌번호가 됩니다.
		    [메뉴2] 예금
			- 사용자가 본인 계좌번호를 입력한 후
			  입금할 금액을 입력하면 해당 계좌번호에 입금합니다.
			[메뉴3] 출금
			- 사용자가 본인 계좌번호를 입력한 후
			  출금할 금액을 입력하면 해당 계좌번호에 출금합니다.
			- 이때 해당 계좌번호의 잔액보다 출금할 금액이 크면
			  "요청한 출금 금액이 계좌잔액보다 큽니다."라고 안내합니다.
			[메뉴4] 계좌이체
			- 사용자가 본인 계좌번호를 입력하면 잔액을 안내합니다.
			- 이체할 계좌번호를 입력한 후 
			  이체할 금액을 입력하면 계좌이체를 진행합니다.
			- 이때,
		      1)이체할 계좌번호가 존재하지 않을 경우
			  "없는 계좌번호입니다. 계좌번호를 확인해주세요."라고 안내합니다.
			  2)해당 계좌번호의 잔액보다 출금할 금액이 크면
			  "요청한 출금 금액이 계좌잔액보다 큽니다."라고 안내합니다.  
			[메뉴5] 잔액조회
			- 사용자가 본인 계좌번호를 입력하면 잔액을 안내합니다.
			[메뉴6] 종료
			- 해당 프로그램을 종료합니다.
		*/
		
		
		
	}

}
