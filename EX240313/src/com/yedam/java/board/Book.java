package com.yedam.java.board;

public class Book {
	
	private String bookNum;
	private String bookName;
	private String bookAuthor;
	private String bookDate;
	
	public Book() {}
	
	public Book(String bookNum, String bookName, String bookAuthor, String bookDate) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDate = bookDate;
	}
	
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	private String bookIntro;
	
	
	

}
