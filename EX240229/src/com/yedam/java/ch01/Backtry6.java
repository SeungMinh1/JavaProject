package com.yedam.java.ch01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Backtry6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);   //문자열 개수 세기
		String word = sc.nextLine();
		//String[] arr1 = word.split("\\s+");
		//System.out.println(arr1.length);
		StringTokenizer st = new StringTokenizer(word);
		System.out.println(st.countTokens());
		//int tokenCount = StringTokenizer.countTokens(st);
		
		
		
		/*백준2675
		int T = Integer.parseInt(sc.nextLine());
		for(int k = 0; k<T; k++) {
			
			int n = sc.nextInt();
			String S = sc.next();
			
			for(int i=0; i<S.length(); i++) {
				char ch = S.charAt(i);
				for(int j=0; j<n; j++) {
					System.out.print(ch);
				}
			}
			System.out.print("\n");
		}
		*/
		
	}

}
