package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.CartVO;

public class CartQtyChage implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String change = req.getParameter("change");

		MemberService svc = new MemberServiceImpl();
		CartVO cvo = new CartVO();
		cvo.setNo(Integer.parseInt(no));
		cvo.setQty(Integer.parseInt(change));
		
		if(svc.changeQty(cvo)) {
			// {"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
