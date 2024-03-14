package com.yedam.java.book;

import java.util.ArrayList;
import java.util.List;

//DAO (Data Access Object) : 자료에 접근하는 클래스
public class BookDAO {
	//필드 
	private List<Book> bookList;
	
	//생성자
	public BookDAO() {
		this.bookList = new ArrayList<>();
	}	
	
	//메소드
	// 등록 
	public void addBook(String no, String title, String writer, 
			String publicateDate, String info) {
		
		Book book = new Book(no, title, writer, publicateDate, info);
		bookList.add(book);
	}
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	// 수정
	public void updateBook(String no, String info) {
		for(int i=0; i<= bookList.size()-1; i++) {
			Book selBook = bookList.get(i);
			if(no.equals(selBook.getNo())) {
				selBook.setInfo(info);
			}
		}
	}
	
	// 삭제
	public void delBook(String no) {
		for(int i=0; i<= bookList.size()-1; i++) {
			Book selBook = bookList.get(i);
			
			if(no.equals(selBook.getNo())) {
				bookList.remove(i);
			}
		}
	}
	
	// 조회
	// 1) 단건조회
	public Book getBook(String no) {
		Book selected = null;
		
		for(Book book : bookList) {
			if(no.equals(book.getNo())) {
				//selected = book;
				selected = new Book();
				selected.setNo(book.getNo());
				selected.setTitle(book.getTitle());
				selected.setWriter(book.getWriter());
				selected.setPublicateDate(book.getPublicateDate());
				selected.setInfo(book.getInfo());
			}
		}
		
		return selected;
	}
	
	// 2) 전체조회
	public void printAllBook() {
		for(Book book : bookList) {			
			System.out.println(book.getBookInfo());
		}
	}
	
	public void search(String keyword) {
		for(Book book : bookList) {
			if(keyword.equals(book.getTitle())) {
				System.out.println(book.getBookInfo());
			}
			
			if(keyword.equals(book.getWriter())) {
				System.out.println(book.getBookInfo());
			}
		}
	}
}
