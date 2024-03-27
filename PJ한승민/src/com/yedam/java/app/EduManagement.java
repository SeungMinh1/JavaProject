package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.education.EduClass;
import com.yedam.education.EduClassDAO;
import com.yedam.enrolment.EnrolmentDAO;
import com.yedam.enrolment.EnrolmentInfo;

public class EduManagement {
	
	
	
	private Scanner sc = new Scanner(System.in);
	private EduClassDAO educlassDAO= EduClassDAO.getInstance();
	private EnrolmentDAO enrolmentDAO = EnrolmentDAO.getInstance();
	
	public void run() {
			
			while(true) {
				menuPrint();
				
				int menuNo = menuSelect();
				
				if(menuNo == 1) {
					insertEClass();
				}if(menuNo == 2) {
					updateEClass();
				}if(menuNo == 3) {
					deleteEClass();
				}if(menuNo == 4) {
					selectEClassNum();
				}if(menuNo == 5) {
					selectEClassAll();
				}if(menuNo == 6) {
					selectEnrolALL();
				}if(menuNo == 7) {
					deleteEnrolment();
				}
		
				if(menuNo == 9) {
					break;
				}
			}
			end();
		}
	
	// 메소드
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.강의등록 ";
		menu += "2.강의수정 ";
		menu += "3.강의삭제 ";
		menu += "4.강의조회 ";
		menu += "5.강의전체조회 ";
		menu += "6.수강신청전체조회 ";
		menu += "7. 수강신청 삭제 ";
		menu += "9.종료 ";
		System.out.println("====================================================================");
		System.out.println(menu);
		System.out.println("====================================================================");
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
		EduClass eclass = inputAll();
		educlassDAO.insertClass(eclass);
	}
	
	private void updateEClass() {       
		
		int menu =selectUpdate();
		if(menu == 1) {
			updatePrint1();//강의 title 변경
		}
		else if(menu == 2) {
			updatePrint2();//강의교수 변경
		}

		else {
			System.out.println("잘못된 메뉴선택입니다.");
		}
	}
	private void updatePrint1() {  //강의 title 변경
		selectEClassAll();
		
		int num = inputNum();
		EduClass elcass = null;
		elcass = educlassDAO.selectClassNum(num);    
		
		if(elcass == null) {
			System.out.println("없는 강의입니다.");
		}else {
			System.out.println(elcass);  
			
			String changetitle = inputTitle();
			elcass.setTitle(changetitle);
			educlassDAO.updateMemberTitle(elcass);
			System.out.println("수정되었습니다.");
		}
		
	}
	private void updatePrint2() {  //강의교수 변경
		selectEClassAll();
		
		int num = inputNum();
		EduClass elcass = null;
		elcass = educlassDAO.selectClassNum(num);    
		
		if(elcass == null) {
			System.out.println("없는 강의입니다.");
		}else {
			System.out.println(elcass);  
			
			String changepro = inputprofesser();
			elcass.setProfessor(changepro);
			educlassDAO.updateMemberProfessor(elcass);
			System.out.println("수정되었습니다.");
		}
		
	}
	
	private int selectUpdate() {
		int menu = 0;
		System.out.println("===================================");
		System.out.println("1.강의제목 변경 | 2.담당 교수 변경 |");
		System.out.println("===================================");
		System.out.print("메뉴를 선택하시오 : ");
		menu = sc.nextInt();
		return menu;
	}
	
	
	
	
	private EduClass inputAll() { // 강의등록에 사용
		EduClass eclass = new EduClass();
		System.out.print("강의번호>> ");
		eclass.setClassnum(sc.nextInt());
		System.out.print("강의제목 >> ");
		eclass.setTitle(sc.next());
		System.out.print("강의 교수>>");
		eclass.setProfessor(sc.next());
		System.out.print("최대 인원수>> ");
		eclass.setMaxNum(sc.nextInt());
		return eclass;
	}
	
	private int inputNum() {
		System.out.print("강의번호>> ");
		int id = sc.nextInt(); 
		return id;
	}
	
	
	private String inputTitle() {
		System.out.print("변경할 강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	private String inputprofesser() {
		System.out.print("변경할 교수이름을 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	
	
	private void deleteEClass() {
		int num = inputNum();
		educlassDAO.deleteEclass(num);
	}
	
	private void selectEClassNum() { // 강의조회
		
		int num = inputNum();
		EduClass eclass = educlassDAO.selectClassNum(num);
		if(eclass == null) {
			System.out.println("없는 강의번호 입니다.");
		}else {
			System.out.println(eclass);
		}
		
	}

	private void selectEClassAll() { //전체조회
		List<EduClass> list = educlassDAO.selectClassALL();
		for(EduClass data : list) {
			System.out.println(data);
		}
	}
	private void selectEnrolALL() {
		List<EnrolmentInfo> list = enrolmentDAO.EnrolmentALL();
		for(EnrolmentInfo data : list) {
			System.out.println(data);
		}

	}
	private void deleteEnrolment() {
		String title = inputTitle2();
		String id = inputId();
		enrolmentDAO.deleteEnrolment(id,title);
	}
	
	private String inputTitle2() {
		System.out.print("강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	private String inputId() {
		System.out.print("ID 입력 : ");
		String ID = sc.next();
		return ID;
	}
	
	/*
	private void selectEClassTitle() {
		
		String title = inputTitle2();
		List<EduClass> list = educlassDAO.selectClassTitle(title);
		if(list == null) {
			System.out.println("없는 강의 입니다.");
		}else {
			for(EduClass data : list) {
				System.out.println(data);
			}
		}
	}
	
	private String inputTitle2() {
		System.out.print("강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	*/
	
	
	
	

	
	
	
	
	
	

}
