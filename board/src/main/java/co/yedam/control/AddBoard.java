package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//title, content, writer 3개의 파라미터가 넘어옴.
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		BoardService svc = new BoardServiceImpl();
		if(svc.addBoard(vo)){
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("msg", "등록중 애러발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
		}

	}

}
