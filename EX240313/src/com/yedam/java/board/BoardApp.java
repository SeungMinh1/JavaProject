package com.yedam.java.board;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		BoardDAO dao = new BoardDAO();
		while(run) {
			System.out.println("======================================");
			System.out.println(" 1.등록 | 2.목록 | 3.수정 | 4.삭제 | 5.종료");
			System.out.println("======================================");
			
			System.out.print("메뉴선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu ==1) {  //등록
				System.out.println("====게시글 등록 ====");
				System.out.print("제목 > ");
				String title = sc.nextLine();
				System.out.print("작성자 > ");
				String writer = sc.nextLine();
				System.out.print("작성일자 > ");
				String createDate = sc.nextLine();
				System.out.print("내용 > ");
				String content = sc.nextLine();
				// 1)
				//dao.addBoard(title, writer, createDate, content);
				// 2)
				Board board = new Board(title, writer, createDate, content);
				dao.addBoard(board);
			}else if(menu ==2) { //목록
				System.out.println("====익명 게시판 ====");
				dao.printAllBoard();
			}else if(menu ==3) { //수정
				System.out.println("====수정 정보 입력 ====");
				System.out.print("수정할 게시글 제목 > ");
				String title = sc.nextLine();
				
				Board board = dao.getBoard(title);
				System.out.println(board.getBoardInfo());
				System.out.print("수정할 내용 > ");
				String content = sc.nextLine();
				dao.updateBoard(title, content);
				
			}else if(menu ==4) { //삭제
				System.out.println("====삭제 정보 입력 ====");
				System.out.print("삭제할 게시글 제목 > ");
				String title = sc.nextLine();
				dao.delBoard(title);
			}else if(menu ==5) {
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}
