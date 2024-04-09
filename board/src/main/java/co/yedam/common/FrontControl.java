package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.AddBoard;
import co.yedam.control.AddBoardAjax;
import co.yedam.control.AddBoardForm;
import co.yedam.control.AddMember;
import co.yedam.control.AddMemberAjax;
import co.yedam.control.AddMemberForm;
import co.yedam.control.BoardControl;
import co.yedam.control.BoardListControl;
import co.yedam.control.DomForm;
import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.LogoutControl;
import co.yedam.control.MemberAjax;
import co.yedam.control.MemberDataControl;
import co.yedam.control.MemberForm;
import co.yedam.control.MemberListControl;
import co.yedam.control.ModifyBoard;
import co.yedam.control.ModifyBoardForm;
import co.yedam.control.ProductListControl;
import co.yedam.control.RemoveBoard;
import co.yedam.control.RemoveBoardControl;
import co.yedam.control.RemoveBoardForm;
import co.yedam.control.RemoveMemberConrtol;
import co.yedam.control.RemoveReply;
import co.yedam.control.ReplyList;
import co.yedam.control.boardAform;
import co.yedam.control.boardAjax;


//init -> service -> destroy
public class FrontControl extends HttpServlet{
	

	//url pattern - 실행서블릿, 관리.
	Map<String, Control> map;
	
	public FrontControl(){
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do",  new MainControl());
		map.put("/second.do",  null);
		map.put("/resume.do", new ResumeControl());
		
		//게시글 목록
		map.put("/boardList.do", new BoardListControl());
		map.put("/getboard.do", new BoardControl());
		map.put("/addForm.do", new AddBoardForm()); //등록화면
		map.put("/addBoard.do", new AddBoard()); //등록기능
		map.put("/modifyForm.do", new ModifyBoardForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/removeForm.do", new RemoveBoardForm());
		map.put("/removeBoard.do", new RemoveBoard());
		
		//member 로그인
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		//회원가입 기능
		map.put("/addMemberForm.do", new AddMemberForm());
		map.put("/addMember.do", new AddMember());
		
		//회원 목록 조회
		map.put("/memberList.do", new MemberListControl());
		
		//json 데이터 생성
		map.put("/domForm.do", new DomForm());
		map.put("/memberData.do", new MemberDataControl());
		
		//상품
		map.put("/productList.do", new ProductListControl());
		
		map.put("/memberForm.do", new MemberForm());
		map.put("/memberAjax.do", new MemberAjax());
		
		map.put("/removeMember.do", new RemoveMemberConrtol());
		map.put("/addMemberAjax.do", new AddMemberAjax());
		
		map.put("/boardAform.do", new boardAform());
		map.put("/boardAjax.do", new boardAjax());
		map.put("/removeBoardAjax.do",new RemoveBoardControl());
		map.put("/addBoardAjax.do", new AddBoardAjax());
		
		map.put("/replyList.do", new ReplyList()); //목록 json
		map.put("/removeReply.do", new RemoveReply()); //댓글삭제 json
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println("uri : "+uri+", context : "+context + ", path: "+ path);
		Control control = map.get(path);
		control.exec(req, resp);
		
	}
	
	
	

}
