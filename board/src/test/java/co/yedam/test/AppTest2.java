package co.yedam.test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class AppTest2 {
	public static void main(String[] args) {
		
//		SearchVO search = new SearchVO();
//		search.setPage(1);
//		search.setSearchCondition("W");
//		search.setKeyword("sd");
//		BoardService svc = new BoardServiceImpl();
//		svc.boardList(search).forEach(board -> System.out.println(board.toString()));;
		
		
		//ReplyMapper mapper = DataSource.getInstance().openSession().getMapper(ReplyMapper.class);
		//List<ReplyVO> list = mapper.replyList(177);
		//for(eplyVO rvo : list) {
			
			//System.out.println(rvo.toString());
		
		ReplyService svc = new ReplyServiceImpl();
		//SearchVO  search = new SearchVO();
		//search.setBno(177);
		//search.setRpage(1);
		//svc.replyList(search).forEach(reply -> System.out.println(reply));
		
		//ReplyVO rvo = new ReplyVO();
		//rvo.setBoardNo(777);
		//rvo.setReply("댓글테스트");
		//rvo.setReplyer("tester");
		
		//if(svc.addReply(rvo)) {
		//	System.out.println("등록성공");
		//}else {
		//	System.out.println("등록실패");
		//}
		//System.out.println(rvo);
		
		
		List<Map<String, Object>> obj = svc.getCntByMember();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);
		System.out.println(json);
		
	}
}
