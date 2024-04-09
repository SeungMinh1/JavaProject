package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardno = req.getParameter("boardN") ;
		int boardno2 = Integer.parseInt(boardno);
		BoardService bvc = new BoardServiceImpl();
		if(bvc.removeBoard(boardno2)) {
			//{"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			//{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}


	}

}
