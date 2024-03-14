package com.yedam.java.exception;

import java.util.ArrayList;
import java.util.List;

import com.yedam.java.object.Member;

public class ExceotionExample {

	public static void main(String[] args) {
		try {
			//실행예외(Runtime Exception)
			// 1) NullPointerException
			String str = null;
			System.out.println(str.length());
			
			// 2)ArrayIndexOutOfBoundsException
			List<Integer> list = new ArrayList<>();
			list.add(100);
			list.add(200);
			for(int i = 0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 확인");
		}catch(NullPointerException e) {
			System.out.println("해당 변수의 값을 확인해주세요.");
		}catch(Exception e) {
			System.out.println("예측하지 못한 예외가 발생");
		}
			
		
		
		// 3) NumberFormatException
		String strA = "100";
		String strB = "a100";
		int intA = Integer.parseInt(strA);
		//int intB = Integer.parseInt(strB);
		
		// 4)ClassCastException
		try {
			Object obj = new Member("blue");
			Member member = (Member)obj;
			//Member newMem = (Member)(new Object());
			System.out.println("정상적으로 실행");
		}catch(ClassCastException e) {
			//e.printStackTrace();
			System.out.println("예외가 발생");
		}finally {
			System.out.println("항상 실행");
		}
		
		
		

	}

}
