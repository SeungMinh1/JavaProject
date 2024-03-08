package com.yedam.java.ch0603;

import java.util.Scanner;

public class VendingExample {
	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		String prdouct = vm.getBeverage(menu);
		System.out.println(prdouct);
		
		
		
		sc.close();
	}

}
