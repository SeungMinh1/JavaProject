package com.yedam.java.exam;

public class Work {
	//필드
	String content;
	boolean isCompleted;
	
	//생성자
	Work(String content){
		this.content = content;
		this.isCompleted = false;
	}
	//매서드
	//완료여부 수정 => 완료함
	void isCompleted() {
		this.isCompleted = true;
	}
	//현재 해당 완료상태
	boolean getCompletion() {
		return this.isCompleted;
	}
	//현재해야하는 내용확인
	String getworkContent() {
		return this.content;
	}
	
	//해야하는 내용과 환료여부 확인
	void printWork() {
		System.out.printf("%s, %s\n", this.content, (this.isCompleted ? "완료" : "미완료"));
	}
	

}
