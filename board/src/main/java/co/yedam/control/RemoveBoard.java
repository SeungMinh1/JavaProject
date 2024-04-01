package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		int bno2 = Integer.parseInt(bno);
		

		BoardService svc = new BoardServiceImpl();
		if(svc.removeBoard(bno2)){
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("msg", "등록중 애러발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
		}

	}

}
