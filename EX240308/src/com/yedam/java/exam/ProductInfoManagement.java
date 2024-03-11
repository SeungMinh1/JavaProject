package com.yedam.java.exam;

import java.io.IOException;
import java.util.Scanner;

public class ProductInfoManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Product[] productList = null;
		int menu = 0;
		
		while(run){
			System.out.println("==================================================");
			System.out.println(" 1.상품수 | 2.상품정보입력 | 3.전체정보출력 | 4.분석 | 5.종료");
			System.out.println("==================================================");
			System.out.print("메뉴선택 > ");
			try {
				menu = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				//System.out.println("메뉴를 입력하여야 합니다.");
			}
			
			if(menu ==1) {
				System.out.print("입력받을 최대 상품수 : ");
				try{
					int maxsize= Integer.parseInt(sc.nextLine());
					productList = new Product[maxsize];
				}catch(NumberFormatException e) {
					System.out.println("상품수를 입력하여야 합니다.");
				}
				
			}else if(menu ==2) {
				for(int i=0; i<productList.length; i++) {
					System.out.println((i+1) + "번째 상품 정보입력");
					System.out.print("상품이름 :");
					String name = sc.nextLine();
					System.out.print("가격 > ");
					int price = Integer.parseInt(sc.nextLine());
					Product product = new Product(name, price);
					productList[i] = product;
				}
			}else if(menu ==3) {
				System.out.println("전체 상품정보를 출력합니다.");
				for(int i=0; i<productList.length; i++) {
					Product product = productList[i];  
					System.out.println(product.getproductN() + " " + product.getproductP());
				}
				/* 향상된 포문
				 for(Product p : productList){
				 	System.out.printf("%s : %d원 \n,  p.name, p.price);
				 }		 
				 */
				
			}else if(menu ==4) {
				Product max =  productList[0];
				int sum =0;
				
				for(int i =0; i<productList.length; i++) {
					Product p = productList[i];
					if(max.getproductP() < p.getproductP()) {
						max = p;
					}
				}
				
				System.out.println("최고가격은 제품은" + max.getproductN() + " "+ max.getproductP());
				
				//평균 구하기
				int cnt = 0;
				for(int i =0; i<productList.length; i++) {
					if(productList[i].getproductP() == max.getproductP()) {
						cnt++;
						continue;
					}
					sum += productList[i].getproductP();
				}
				double avg = (double)sum/(productList.length-cnt);
				System.out.println("해당 제품을 제외한 제품들의 가격을 다 더하면 "+sum + "원 입니다.");
				System.out.println("평균은 "+ avg +"입니다.");
				/*
				for(Product p : productList){
					if(p.price == max.price){
					cnt++;}
					}else{
					sum += p.price;}
				}
				double avg = sum/(productList.length - cnt);
				 */
			}else if(menu ==5) {
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}else {
				System.out.println("잘못된 메뉴선택 입니다.");
			}
			
			
			
		}
		

	}

}
