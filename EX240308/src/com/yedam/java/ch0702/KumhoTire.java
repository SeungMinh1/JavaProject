package com.yedam.java.ch0702;

public class KumhoTire extends Tire{
	
	KumhoTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		accumulatiedRotation++;
		if(accumulatiedRotation < maxRotation) {
			System.out.printf("%s 금호 Tire 수명 : %d회\n", location, (maxRotation - accumulatiedRotation));
			return true;
		}else {
			System.out.printf("****%s 금호 Tire 펑크\n", location);
			return false;
		}
	}

}
