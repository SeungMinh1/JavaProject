package com.yedam.java.ch01;

import java.util.Scanner;

public class Backtry11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = false;
		String a = sc.nextLine();
		char[] c = new char[a.length()];
		for(int i=0; i<a.length(); i++) {
			c[i] = a.charAt(i);
		}
		for(int i=0; i<a.length()/2; i++) {
			if(c[i] == c[a.length()-1-i]) {
				run = true;
			}else
				run = false;
		}		
		if(run == true) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
			

	}

}
