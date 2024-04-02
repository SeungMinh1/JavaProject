package co.yedam.test;

import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class AppTest2 {
	public static void main(String[] args) {
		SearchVO search = new SearchVO();
		search.setPage(1);
		search.setSearchCondition("W");
		search.setKeyword("sd");
		BoardService svc = new BoardServiceImpl();
		svc.boardList(search).forEach(board -> System.out.println(board.toString()));;
	}
}
