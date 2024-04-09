package co.yedam.test;

import java.util.List;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest2 {
	public static void main(String[] args) {
		
//		SearchVO search = new SearchVO();
//		search.setPage(1);
//		search.setSearchCondition("W");
//		search.setKeyword("sd");
//		BoardService svc = new BoardServiceImpl();
//		svc.boardList(search).forEach(board -> System.out.println(board.toString()));;
		
		
		ReplyMapper mapper = DataSource.getInstance().openSession().getMapper(ReplyMapper.class);
		List<ReplyVO> list = mapper.replyList(177);
		for(ReplyVO rvo : list) {
			System.out.println(rvo.toString());
		}
	}
}
