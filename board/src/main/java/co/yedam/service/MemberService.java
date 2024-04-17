package co.yedam.service;

import java.util.List;

import co.yedam.vo.CartVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.ProdVO;

public interface MemberService {
	public MemberVO loginCheck(MemberVO mvo);
	
	boolean addMember(MemberVO mvo);
	List<MemberVO> memberList();
	List<ProdVO> prodList();
	public boolean removeMember(String mid);
	
	// 카트관련
	public List<CartVO> cartList();
	public boolean removeCart(int no);
	public boolean changeQty(CartVO vo);
}
