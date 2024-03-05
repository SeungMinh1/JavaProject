package com.yedam.java.ch01;

import java.util.Scanner;

public class Backtry4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		String[] word = new String[n];
		for(int i =0; i<n; i++) {
			word[i] = sc.nextLine();
		}
		for(int i =0; i<n; i++) {
			System.out.println(word[0].charAt(0));
		}
		
		//word[0].charAt(word[0].length()-1)
	}

}
