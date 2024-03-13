package com.yedam.java.board;

//VO(Value Object) => 자료를 저장하는 클래스
public class Board {
	//필드 => prrivate
	private String title;		//제목
	private String writer;		//작성자
	private String createDate;	//작성일자
	private String content;		//작성내용
	
	//생성자 =>기본생성자, 초기화하는 생성자
	public Board() {}
	
	public Board(String title, String writer, String createDate, String content) {
		this.title =title;
		this.writer = writer;
		this.createDate = createDate;
		this.content = content;
	}
	//메소드 > getter/setter
	//getter => 필드에서 외부  매개변수없고  return 필수
	public String getTitle() {
		return this.title;
	}
	//setter => 매개변수에서 필드  매개변수 있고  return 불가
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return this.writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoardInfo() {
		return title + " " + writer + " "+ createDate +" "+content;
	}
	
	
	
}
	
