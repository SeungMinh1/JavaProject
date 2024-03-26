package com.yedam.java.app;

import java.util.Scanner;


import com.yedam.loginMember.LoginMem;
import com.yedam.loginMember.LoginMemDAO;

public class LoginControl {
	
	Scanner sc = new Scanner(System.in);
	
	//싱글톤
	private static LoginMem loginInfo = null;
	public static LoginMem getLoginInfo() {
		return loginInfo;
	}
		
	public void run() {
		
		while(true) {
			menuPrint(); //메뉴출력			
			int menuNo = menuSelect();	//메뉴선택
			if(menuNo == 1) {
				//로그인
				login();
			}else if(menuNo == 2) {
				
			}else if(menuNo == 3) {
				//종료
				end();
				break;
			}else {
				showError();
			}
		}
	}
	
	
	private void menuPrint() {
		System.out.println("========================");
		System.out.println("1.로그인 2.회원가입 3.종료");
		System.out.println("=========================");
	}
	
	private void login() {
		//아이디와 비밀번호 입력
		LoginMem inputInfo = inputMember();
		//로그인 시도
		loginInfo = LoginMemDAO.getInstance().selectOne(inputInfo);
		
		//실패할 경우 그대로 메소드 종료
		if(loginInfo == null) return;
		
		//성공할 경우 프로그램을 실행
		new HumanResourceMMng().run();
	}
	private LoginMem inputMember() {
		LoginMem info = new LoginMem();
		System.out.print("아이디 > ");
		info.setId(sc.nextLine());
		System.out.print("비밀번호 > ");
		info.setPwd(sc.nextLine());
		return info;
	}
	
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	//////////////수정중

	
	
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void showError() {
		System.out.println("메뉴에서 선택하세요.");
	}
	
	//권한체크
	public static boolean selectLoginRole() {
		int memberRole = loginInfo.getMemberRole();
		if(memberRole == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
