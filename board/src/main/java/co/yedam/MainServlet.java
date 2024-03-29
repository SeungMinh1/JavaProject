package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		// get요청을 실행
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //출력스트림.
		out.print("안녕하세요hello");
		out.print("<a href='info/resume.html'> resume로 이동 </a>");
		*/
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardVO board = new BoardVO();
		board.setBoardNo(bno);
		
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		
		if(mapper.deleteBoard(bno) == 1) {
			response.getWriter().println("OK");
		}else {
			response.getWriter().println("NG");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// 저장후 저장성공 메세지 출력.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println("title : "+ title +"content : "+ content+ "writer : "+ writer );
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		
		if(mapper.insertBoard(board) == 1) {
			response.getWriter().println("OK");
		}else {
			response.getWriter().println("NG");
		}
	}

}
