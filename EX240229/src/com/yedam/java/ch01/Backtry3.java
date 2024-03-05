package com.yedam.java.ch01;
import java.util.Scanner;

public class Backtry3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double [] score = new double[n];
		
		double max = 0; //최대
		double avg = 0; // 평균
		for(int i=0; i<n; i++) {
			score[i] = sc.nextDouble();
			if(max<score[i]){
				max = score[i];
			}
		}
		for(int i=0; i<score.length; i++) {
			score[i] = score[i]/max*100;
			avg += score[i];
		}
		System.out.println(avg/score.length);

	}

}
