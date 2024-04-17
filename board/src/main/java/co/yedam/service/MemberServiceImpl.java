package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.vo.CartVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.ProdVO;

public class MemberServiceImpl implements MemberService{

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO mvo) {
		return mapper.selectMember(mvo);
	}

	@Override
	public boolean addMember(MemberVO mvo) {
		
		return mapper.insertMember(mvo) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		
		return mapper.selectList();
	}

	@Override
	public List<ProdVO> prodList() {
		return mapper.prodList();
	}

	@Override
	public boolean removeMember(String mid) {
		
		return mapper.deleteMember(mid) == 1;
	}
	
	// 카트 관련
	@Override
	public List<CartVO> cartList() {
		return mapper.selectCart();
	}

	@Override
	public boolean removeCart(int no) {
		return mapper.deleteCart(no) == 1;
	}

	@Override
	public boolean changeQty(CartVO vo) {
		return mapper.updateCart(vo) == 1;
	}

}
