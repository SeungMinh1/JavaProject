package com.yedam.java.ch0605;

public class FinalExample {

	public static void main(String[] args) {
		System.out.printf("지구의 반지름 : %.2f, 지구 표면적 : %.10f\n", Earth.EARTH_RADIUS, Earth.EARCH_AREA);
		
		
		//인스턴스 필드상수
		Person kang = new Person("1234", "kang");
		System.out.printf("%s, %s, %s\n", kang.nation, kang.ssn, kang.name);
		//kang.ssn = "0987"; 안됨
		Person lee = new Person("6789", "lee");
		System.out.printf("%s, %s, %s\n", lee.nation, lee.ssn, lee.name);

	}

}
