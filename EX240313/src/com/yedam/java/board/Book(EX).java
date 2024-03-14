package com.yedam.java.book;

//VO(Value Object) => 자료를 저장하는 클래스
public class Book {
	//필드
	private String no;	//도서번호
	private String title; //도서제목
	private String writer; //도서저자
	private String publicateDate; //출판일자
	private String info;  //도서소개
	//생성자
	public Book() {}
	
	public Book(String no, String title, String writer, 
						String publicateDate, String info) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publicateDate = publicateDate;
		this.info = info;
	}
	
	//메소드
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublicateDate() {
		return publicateDate;
	}

	public void setPublicateDate(String publicateDate) {
		this.publicateDate = publicateDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getBookInfo() {
		return no + " " 
			 + title + " "
			 + writer + " "
			 + publicateDate + " "
			 + info;				
	}
	
}
