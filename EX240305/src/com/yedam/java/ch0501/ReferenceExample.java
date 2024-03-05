package com.yedam.java.ch0501;

public class ReferenceExample {

	public static void main(String[] args) {
		String strVal1 = "신미철";
		String strVal2 = "신미철";
		if(strVal1 == strVal2) {
			System.out.println("val1  val2가 참조가 같음");
		}else {
			System.out.println("val1  val2가 참조가 다름");
		}
		
		String strVal3 = new String("신미철");
		String strVal4 = new String("신미철");
		if(strVal3 == strVal4) {
			System.out.println("val1  val2가 참조가 같음");
		}else {
			System.out.println("val1  val2가 참조가 다름");
		}
		// equals
		if(strVal3.equals(strVal4)) {
			System.out.println("val1  val2가 문자열이 같음");
		}else {
			System.out.println("val1  val2가 문자열이 다름");
		}
		//equalsIgnoreCase
		if(strVal3.equalsIgnoreCase(strVal4)) {  //대소문자구분없이 비교(한글x)
			System.out.println("val1  val2가 문자열이 같음");
		}else {
			System.out.println("val1  val2가 문자열이 다름");
		}
		
		boolean result = strVal3.equals(strVal4);
		System.out.println(result);
		
		
	}

}
