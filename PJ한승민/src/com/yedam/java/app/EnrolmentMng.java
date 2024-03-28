package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.education.EduClass;
import com.yedam.education.EduClassDAO;
import com.yedam.enrolment.EnrolmentDAO;
import com.yedam.enrolment.EnrolmentInfo;

public class EnrolmentMng {
	
	private Scanner sc = new Scanner(System.in);
	private EduClassDAO educlassDAO= EduClassDAO.getInstance();
	private EnrolmentDAO enrolmentDAO = EnrolmentDAO.getInstance();
	
	public void run() {
		while(true) {
			//System.out.println(enrolmentDAO.countClasstitle( (LoginControl.getLoginInfo().getId()) ));
			//updateCountclassTitle();
			//System.out.println(enrolmentDAO.countClasstitle( (LoginControl.getLoginInfo().getId()) ));
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				System.out.println("현재 개설딘 강좌");
				selectClassALL();
				
			}else if(menuNo == 2) {
				System.out.println("----------------------------------------------------------------------------");
				selectClassALL();
				insertEClass();
				updateCountclassTitle();
				
			}else if(menuNo == 3) {
				selectEnrolALL();
			}else if(menuNo == 4) {
				System.out.println("강의신청을 취소한다");;
				deleteEnrolment();
			}else if(menuNo == 9) {
				break;
			}else {
				System.out.println("메뉴에서 선택하세요");
				
			}
		}
		end();
			
	}
	
	//		System.out.println(enrolmentDAO.countClasstitle((LoginControl.getLoginInfo().getId())));
	
	private void selectClassALL(){
		List<EduClass> list = educlassDAO.selectClassALL();
		for(EduClass data : list) {
			System.out.println(data);
		}
	}

	private String inputTitle2() {
		System.out.print("강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	
	// 메소드
	private void end() {
		System.out.println("이전메뉴로 돌아갑니다.");
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.개설된 강좌보기 ";
		menu += "2.강의신청하기 ";
		menu += "3.강의신청 목록 ";
		menu += "4.강의신청 취소 ";
		menu += "9.종료 ";
		System.out.println("===========================================================");
		System.out.println(menu);
		System.out.println("===========================================================");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			System.out.print("선택>> ");
			menuNo = sc.nextInt();
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	
	private void insertEClass() {
		EnrolmentInfo enrol = inputAll();
		if(enrolmentDAO.countMaxnum(enrol.getClassTitle()) >= enrolmentDAO.countCurrentnum(enrol.getClassTitle())) {
			
			if(enrol.getClassTitle().equals(enrolmentDAO.selectIDtitle(LoginControl.getLoginInfo().getId()) ) ){
				System.out.println("이미 신청한 과목입니다.");
			}else {
				enrolmentDAO.insertEnrolment(enrol);
			}
			
		}else {
			System.out.println("더 이상 해당 강의를 신청할수 없습니다.");
		}
		
	}
	
	private EnrolmentInfo inputAll() {
		EnrolmentInfo enrol = new EnrolmentInfo();
		//enrol.setNum(0);
		enrol.setMemberId(LoginControl.getLoginInfo().getId());
		System.out.print("어떤강의를 수강하겠습니까? >> ");
		enrol.setClassTitle(sc.next());
		
		return enrol;
	}
	
	
	private void selectEnrolALL() {
		List<EnrolmentInfo> list = enrolmentDAO.selectEnrolmentALL(LoginControl.getLoginInfo().getId());
		for(EnrolmentInfo data : list) {
			System.out.println(data);
		}

	}
	/////////////////////////////////
	private void selectEnrolTitle(String id) {
		enrolmentDAO.selectIDtitle(id);
	}
	
	private void deleteEnrolment() {
		String title = inputTitle2();
		enrolmentDAO.deleteEnrolment((LoginControl.getLoginInfo().getId()),title);
	}
	
	private void updateCountclassTitle() {
		String b = (LoginControl.getLoginInfo().getId() );
		int a = enrolmentDAO.countClasstitle(b);
		enrolmentDAO.updateCountClass(a, b);;
	}
	
	
	
	/*
	private void printCount() {
		EnrolmentInfo enrol = new EnrolmentInfo();
		enrol.setMemberId(LoginControl.getLoginInfo().getId());
		System.out.println(enrolmentDAO.countClasstitle(enrol.getMemberId()));
	}
	*/
	
	
/*
	private EduClass selectEClassNum() {

		int num = menuSelect();
		EduClass eclass = educlassDAO.selectClassNum(num);
		//System.out.println(eclass);
		return eclass;
		
	}
	
	private void selectEClassTitle() {
		
		String title = inputTitle2();	
		List<EduClass> list = educlassDAO.selectClassTitle(title);
		for(EduClass data : list) {
			System.out.println(data);
		}
		
	}
*/
	
	
}
