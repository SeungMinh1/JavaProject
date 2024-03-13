package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer>map = new HashMap<>();
		
		//값추가
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		System.out.println("총 Entry 수 : " + map.size());
		
		//값 확인
		
		System.out.println("\t 홍길동 : " + map.get("홍길동"));
		
		//Iterator - Entry
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.printf("%s %d\n", key, value);
		}
		
		//객체 삭제 remove
		map.remove("홍길동");
		System.out.println("총 Entry 수 : " + map.size());
		//Iterator - Key
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.printf("%s %d\n", key, value);
			
		}
		
	}

}
