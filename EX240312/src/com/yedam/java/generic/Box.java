package com.yedam.java.generic;

public class Box<P, C> {  //<T, C > 여러개여서 상관은 없음
	//제네릭 : 결정되지 않은 타입을 특정 파라미터로 처리하고 실제로 사용하는
	//순간 해당 파라미터를 실제타입으로 대체해서 처리
	
	private P p;
	private C c;
	
	public P getProduct() {
		return this.p;
	}
	public void setProduct(P p) {
		this.p = p;;
	}
	public C getCount() {
		return this.c;
	}
	public void setCount(C c) {
		this.c= c;
	}
	

}
