package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("id");
		String memberPw = req.getParameter("pw");
		String memberNm = req.getParameter("name");
		String phone = req.getParameter("tel");
		
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(memberId);
		mvo.setMemberPw(memberPw);
		mvo.setMemberNm(memberNm);
		mvo.setPhone(phone);
		
		MemberService svc = new MemberServiceImpl();
		
		if(svc.addMember(mvo)){
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("msg", "등록중 애러발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
		}
		

	}

}
