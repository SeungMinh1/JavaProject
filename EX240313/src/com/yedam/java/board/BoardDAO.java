package com.yedam.java.board;

import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) : 자료에 접근하는 클래스
public class BoardDAO {
	//핃드 => 실제자료를 저장하는 변수
	private List<Board> boardList;
	
	//생성자 =>  기본생성자 => 초기화하는 생성자
	public BoardDAO() {
		this.boardList = new ArrayList<>();
	}
	
	//메소드
	
	//등록
	public void addBoard(String title, String writer, String createDate, String content) {
		Board board = new Board(title, writer, createDate, content);
		boardList.add(board);
	}
	
	public void addBoard(Board board) {
		boardList.add(board);
	}
	
	//수정 - 내용,
	public void updateBoard(String title, String content) {
		for(int i=0; i<boardList.size(); i++) {
			Board selBoard = boardList.get(i);
			if(title.equals(selBoard.getTitle())) {
				selBoard.setContent(content);
			}
		}
	}
	
	//삭제
	public void delBoard(String title) {
		for(int i=0; i<boardList.size(); i++) {
			Board selBoard = boardList.get(i);
			
			if(title.equals(selBoard.getTitle())) {
				boardList.remove(i);
			}
		}
	}
	//조회
	// 1) 단건조회
	public Board getBoard(String title) {
		Board selected = null;
		for(Board board : boardList) {
			if(title.equals(board.getTitle())) {
				selected = board;
			}
		}
		return selected;
	}
	
	// 2) 전체조회
	public void printAllBoard() {
		for(Board board : boardList) {
			System.out.println(board.getBoardInfo());
		}
	}
	
	
	
}
