package com.yedam.java.ch04;


public class ConditonalExample {

	public static void main(String[] args) {
		
		int sum1 = 0; //합
		int sum2 = 0; //합
		// 1~10 사이정수출력
		for(int i=1; i<=10; i++) {
			System.out.print(i+ " ");
			sum1 += i;
		}
		
		System.out.print("\n");
		int i =1;
		while(i<=10) {
			System.out.print(i+ " ");
			sum2 += i;
			i++;
		}
		System.out.print("\n");
		System.out.println("sum for = "+sum1);
		System.out.println("sum while = "+sum2);
		
		//do ~ while
		int index =0;
		while(index <0) {
			System.out.println("while 문, " + index);
		}
		index = 0;
		do {
			System.out.println("while 문, " + index);
		}while(index<0);
		
		//break문
		for(int x = 0; x<100; x+=2) {
			if(x==20) {
				break;
			}
			System.out.println(x);
		}
		while(true) {
			int nu = (int)(Math.random() * 6 + 1);
			System.out.println(nu);
			if(nu == 6) {
				break;
			}
		}
		System.out.println("------------");
		outter: for(char upper ='A'; upper<='Z'; upper++) {
			for(char lower = 'a'; lower <='z'; lower++) {
				System.out.println(upper +" - " + lower);
				if(lower == 'g') break outter;
			}
		}
		
		//continue
		for(int x = 1; x<=10; x++) {
			if(x%2 == 0) {
				continue;
			}
			System.out.println(x +", 해당 값은 홀수입니다.");
		}
		
	
	}
}
