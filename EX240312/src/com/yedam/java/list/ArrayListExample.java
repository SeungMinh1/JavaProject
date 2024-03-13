package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		String[] strList = new String[10];
		List<String> list = new ArrayList<String>(); //new ArrayList<>(); 같다
		System.out.println("List 크기 : " + strList.length);
		System.out.println("List 크기 : " + list.size());
		// add = 값을 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servletc/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		// size = List의 현재 크기
		System.out.println("List 크기 : " + list.size());
		
		//값을 가져옴
		String skill = list.get(0);
		System.out.println("2 : " + skill);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println("");
		//remove = 특정 인덱스에 위차한 값을 삭제
		list.remove(2);
		list.remove(2);
		//향상된 for문 : 배열, List Set
		for(String str : list) {
			System.out.println(str);
		}
	}

}
