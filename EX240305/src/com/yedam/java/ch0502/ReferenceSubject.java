package com.yedam.java.ch0502;

import java.util.Arrays;
import java.util.Collections;

public class ReferenceSubject {

	public static void main(String[] args) {
		
		int[] arr1 = {10, 20, 30, 50, 3, 60, -3};
		
		//문제1. 주어진 배열 중에서 값이 60인곳의 인덱스 출력
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i]==60) {
				System.out.println("값이 60인곳의 인덱스 : " +i);
				break;
			}
		}
		//문제2. 주어진 배열 중에서 인덱스가 짝수인 값을 출력
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] %2 == 0) {
				System.out.print(arr1[i] + " ");
			}
		}
		//문제3. 주어진 배열 중에서 최대값과 최소값을 출력
		int max = 0; int min=0;
		for(int i=0; i<arr1.length; i++) {
			if(max < arr1[i]) {
				max = arr1[i];
			}
			if(min > arr1[i]) {
				min = arr1[i];
			}
		}
		System.out.printf("\n최대값 : %d, 최소값 : %d \n", max, min);
		
		//내림차순 정렬 큰수 > 작은수
		/*
		 Arrays.sort(arr1, Collections.reverseOrder());
		
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		*/
		
		for(int j=0; j<arr1.length; j++) {
			for(int i=1; i<arr1.length-1; i++) {
				if(arr1[j]<arr1[i]) {
					max = arr1[j];
					arr1[j] = arr1[i];
					arr1[i] = max;
				}
			}		
		}
		
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		
		
		
	
		
	}

}
