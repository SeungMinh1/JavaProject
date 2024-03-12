package com.yedam.java.ch0702;

public class HankookTire extends Tire{
	
	//필드
	
	//생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	//메소드
	@Override
	public boolean roll() {
		accumulatiedRotation++;
		if(accumulatiedRotation < maxRotation) {
			System.out.printf("%s 한국 Tire 수명 : %d회\n", location, (maxRotation - accumulatiedRotation));
			return true;
		}else {
			System.out.printf("****%s 한국 Tire 펑크\n", location);
			return false;
		}
	}

}
