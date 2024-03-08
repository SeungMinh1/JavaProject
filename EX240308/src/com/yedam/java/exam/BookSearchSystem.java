package com.yedam.java.exam;

import java.util.Scanner;

public class BookSearchSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Book[] bookList = new Book[10];
		int current = 0;
		while(run) {
			System.out.println("================================================");
			System.out.println(" 1.도서등록 | 2.도서검색| 3.전체출력 | 5.종료");
			System.out.println("================================================");
			System.out.print("메뉴선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu ==1) {
				System.out.print("도서제목 > ");
				String name = sc.nextLine();
				System.out.print("작가 > ");
				String author = sc.nextLine();
				System.out.print("메모 > ");
				String memo = sc.nextLine();
				
				Book book = new Book(name, author, memo);
				bookList[current++] = book;
				
			}else if(menu == 2) {
				System.out.print("검색할 도서제목 > ");
				String name = sc.nextLine();
				for(int i=0; i<current; i++) {
					if(bookList[i].name.equals(name)) {
						System.out.println(bookList[i].name +" "+bookList[i].author+" "+bookList[i].memo);
					}
				}
			}else if(menu == 3) {
				for(int i=0; i<current; i++) {
					Book book = bookList[i];
					System.out.println(book.name +" "+book.author+" "+book.memo);
				}
			}else if(menu == 5) {
				System.out.print("시스템 종료");
				run = false;
			}
		}

	}

}
