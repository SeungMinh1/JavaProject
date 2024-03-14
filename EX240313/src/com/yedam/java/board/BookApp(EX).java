package com.yedam.java.book;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		BookDAO dao = new BookDAO();

		while (run) {
			System.out.println("================================================");
			System.out.println(" 1.등록 | 2.목록 | 3.수정 | 4.삭제 | 5.검색 | 6.종료");
			System.out.println("================================================");

			System.out.print("메뉴 선택 > ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) { // 등록
				System.out.println("==== 도서 등록 ====");
				System.out.print("도서번호 > ");
				String no = sc.nextLine();
				System.out.print("도서제목 > ");
				String title = sc.nextLine();
				System.out.print("도서저자 > ");
				String writer = sc.nextLine();
				System.out.print("출판일자 > ");
				String publicateDate = sc.nextLine();
				System.out.print("도서소개 > ");
				String info = sc.nextLine();

				// 1)
				dao.addBook(no, title, writer, publicateDate, info);

				// 2)
				//Book book = new Book(no, title, writer, publicateDate, info);
				//dao.addBook(book);

			} else if (menu == 2) { // 목록
				System.out.println("==== 도서 목록 ====");
				dao.printAllBook();
			} else if (menu == 3) { // 수정
				System.out.println("==== 도서 정보 입력 ====");
				System.out.print("수정할 도서번호 > ");
				String no = sc.nextLine();

				Book book = dao.getBook(no);
				System.out.println(book.getBookInfo());

				System.out.print("수정할 소개내용 > ");
				String info = sc.nextLine();
				dao.updateBook(no, info);
			} else if (menu == 4) { // 삭제
				System.out.println("==== 삭제 도서 입력 ====");
				System.out.print("삭제할 도서번호 > ");
				String no = sc.nextLine();

				dao.delBook(no);
			} else if (menu == 5) {
				System.out.println("==== 도서 검색 ====");
				System.out.print("검색어 > ");
				String keyword = sc.nextLine();

				dao.search(keyword);
			} else if (menu == 6) {
				run = false;
			} else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
