package com.yedam.java.object;

public class Member {
	//필드
	public String id;
	public String name;
	
	public int age;
	//생성자
	
	public Member(String id) {
		this.id = id;
	}
	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//메소드
	@Override
	public boolean equals(Object obj) {
		// 필드 id값이 같다면 같은 객체로 인식
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public String toString() {
		return  "Member : id, " + id;//super.toString(); "Member : id, " + id;
	}
	
	
	

}
