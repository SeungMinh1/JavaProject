package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String bno = req.getParameter("boardNo");
		int bno2 = Integer.parseInt(bno);
		
		BoardVO vo = new BoardVO();
		vo.setBoardNo(bno2);
		vo.setTitle(title);
		vo.setContent(content);
		BoardService svc = new BoardServiceImpl();
		if(svc.modifyBoard(vo)){
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("msg", "등록중 애러발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
		}
	}

}
