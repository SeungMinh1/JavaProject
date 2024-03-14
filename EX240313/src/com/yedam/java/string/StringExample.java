package com.yedam.java.string;

public class StringExample {

	public static void main(String[] args) {
		
		//charAt() : 문자추출
		String ssn = "123456-1234567";
		char gender = ssn.charAt(7);
		
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
		//indexOf() : 문장에 원하는 값이 있는지 없는지
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") > -1){
			System.out.println("자바와 관련된책");
		}else {
			System.out.println("자바와 관련없는 책");
		}
		
		// substring(), length()
		String search = subject.substring(location, subject.length());
		System.out.println(search);
		
		ssn = "100624-1230123";
		String bitrhday = ssn.substring(0, 6);
		System.out.println(bitrhday);
		
		
		//toLowerCaer(), toUpperCase()
		String valA = "Hello, World";
		String valB = "HELLO, WORLD";
		System.out.println(valA.toLowerCase());
		
		if(valA.toLowerCase().equals(valB.toLowerCase())) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
	}

}
