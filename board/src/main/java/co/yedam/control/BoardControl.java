package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		//db정보 조회 후 -> boardList.jsp 출력
		BoardService svc = new BoardServiceImpl();
		
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("bvo", vo);
		
		//페이지 재지정.
		req.getRequestDispatcher("WEB-INF/view/board.jsp").forward(req, resp);;

	}

}
