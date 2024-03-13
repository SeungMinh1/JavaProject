package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		//값을 추가 (위치지정 불가, 중복안됨) 
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		System.out.println("set 현재 크기 : " + set.size());
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			
			System.out.printf("\t %s\n", iterator.next());
		}
		
		set.remove("Java");
		set.remove("Servlet/JSP");
		for(String str : set) {
			System.out.println(str);
		}
		
		

	}

}
