package com.yedam.java.ch0601;

public class ScoreManagement {
	//필드
	private int[] scoreList;
	private int currentIndex = 0;
	//생성자
	ScoreManagement(int studentNum){
		this.scoreList = new int[studentNum];
	}
	
	//메소드
	// 점수 추가
	public void addScore(int score) {
		this.scoreList[this.currentIndex++] = score;
	}
	
	// 개별 점수 확인
	public int printScore(int selected) {
		return this.scoreList[selected];
	}
	// 전체 점수 확인
	public void printScoreList() {
		for(int i=0; i<this.scoreList.length; i++) {
			System.out.printf("scoreList[%d]> %d\n",i, this.printScore(i));				
		}
	}
	
	// 점수 총 합계
	public int calcTotalScore() {
		int sum = 0;
		for(int i=0; i<this.scoreList.length; i++) {
			sum += this.scoreList[i];				
		}
		return sum;
	}
	
	// 최고 점수
	public int calcMaxScore() {
		int max = this.scoreList[0];
		for(int i=0; i<this.scoreList.length; i++) {
			if(max < this.scoreList[i]) {
				max = this.scoreList[i];
			}
		}
		return max;
	}
	// 최저 점수
	public int calcMinScore() {
		int min = this.scoreList[0];
		for(int i=0; i<this.scoreList.length; i++) {
			if(this.scoreList[i] < min) {
				min = this.scoreList[i];
			}
		}
		return min;
	}
	
	// 평균 점수
	public double calcAvgScore() {
		return (double) this.calcTotalScore() / this.scoreList.length;
	}
	
	//분석
	
}
