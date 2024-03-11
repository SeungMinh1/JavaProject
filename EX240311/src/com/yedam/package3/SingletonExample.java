package com.yedam.package3;

public class SingletonExample {

	public static void main(String[] args) {
		//Singleton one = new Singleton();
		Singleton one = Singleton.getInstance();
		
		Singleton two = Singleton.getInstance();
		
		if(one == two) {
			System.out.println("동일함");
		}else {
			System.out.println("아님");
		}
	}

}
