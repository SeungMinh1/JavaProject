package com.yedam.loginMember;

public class LoginMem {
	
	//필드
	private String Id;
	private String pwd;
	private int memberRole;// memberRole : 0 - 관리자, 1 - 일반 
	
	
	//메소드 getter
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(int memberRole) {
		this.memberRole = memberRole;
	}
	
	@Override
	public String toString() {
		String info = "";
		if(memberRole == 0) {
			info = "관리자 계정 : " + Id;
		}else {
			info = "일반 계정 : " + Id;
		}
		
		return info;
	}
	

}
