package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoardAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//int boardN = Integer.parseInt(req.getParameter("boardN"));
		String title= req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO bvo = new BoardVO();
		//bvo.setBoardNo(boardN);
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		BoardService bsv = new BoardServiceImpl();
		if(bsv.addBoard(bvo)) {
			//{"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			//{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
		
	}

}
