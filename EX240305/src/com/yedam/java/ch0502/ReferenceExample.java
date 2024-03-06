package com.yedam.java.ch0502;

public class ReferenceExample {

	public static void main(String[] args) {
		
		//배열선언
		int[] intAry = {1, 10, 25};// = new int[];
		double[] doubleAry;
		doubleAry = new double[] {25.9, 55.2};//객체생성후 값할당
		String[] strAry = new String[3];
		
		for(int i=0; i<intAry.length; i++) {
			System.out.print(intAry[i] + " ");;
		}
		System.out.println();
		
		for(int i=0; i<=strAry.length-1; i++) {
			System.out.print(strAry[i] + " ");
		}
		System.out.println("");
		
		System.out.println("=====================");
		//2차원 배열
		int[][] intList = {{1,2,3}, {5,6,7}};
		String[][] strList = new String[2][3];
		for(int i=0; i<intList.length; i++) {
			//intList[i] => 1차원 배열
			for(int j=0; j<intList[i].length; j++) {
				System.out.printf("intList[%d][%d] : %d\n", i,j,intList[i][j]);
			}
		}
		
		System.out.println("intList.length : " + intList.length);
		System.out.println("intList[0].length : " + intList[0].length);
		
		System.out.println("strList.length : " + strList.length);
		String[] strArray = strList[0];
		System.out.println("strArray.length : " + strArray.length);
		
		System.out.println("=====================");
		
		//참조타입배열 & 복사
		intList = new int[][] { {1,2,3}, {5,6,7}};
		int[][] newList = new int [2][3];
		
		//1.얕은 복사
		for(int i=0; i<intList.length; i++) {
			//newList[i] = intList[i];
		}
		System.out.printf("intList : %d newList : %d\n",intList[1][0], newList[1][0]);
		newList[1][0] = 10;
		System.out.printf("intList : %d newList : %d\n",intList[1][0], newList[1][0]);
		//2.깊은 복사
		
		for(int i=0; i<intList.length; i++) {
			//intList[i] => 1차원 배열
			for(int j=0; j<intList[i].length; j++) {
				newList[i][j] = intList[i][j];
			}
		}
		
		newList[1][0] = 10;
		System.out.printf("intList : %d newList : %d\n",intList[1][0], newList[1][0]);
		
		int[] aray = {1,2,5,7,8};
		for(int i=0; i<aray.length; i++) {
			System.out.printf("인덱스 : %d, 값 : %d\n", i, aray[i]);
		}
		for(int i : aray) {
			System.out.println(i);
		}
	}

}
