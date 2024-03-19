package com.yedam.java.ch01;

import java.util.Scanner;

public class Backtry10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		
		for(int i=1; i<=a; i++) {
			for(int k = 0; k<a-i; k++) {
				System.out.print(' ');
			}
			for(int j = 0; j<2*i-1; j++) {
				System.out.print('*');
			}
			System.out.println();	
		}
		for(int i=a-1; i>0; i--) {
			for(int j=0; j<a-i; j++) {
				System.out.print(' ');
			}
			for(int k = 0; k<2*i-1; k++) {
				System.out.print('*');
			}
			System.out.println();	
			
		}

	}

}
