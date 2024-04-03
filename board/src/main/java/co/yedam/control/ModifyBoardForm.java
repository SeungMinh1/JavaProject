package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoardForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		String bno = req.getParameter("bno");
		
		//추가 파라미터
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String page = req.getParameter("page");	
		
		
		BoardService svc = new BoardServiceImpl();
		BoardVO bvo = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		
		req.setAttribute("bvo", bvo);
		
		
		req.getRequestDispatcher("board/ModifyForm.tiles").forward(req, resp);
	}

}
