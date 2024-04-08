package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.MemberVO;
import co.yedam.vo.ProdVO;

public interface MemberMapper {
	
	public List<MemberVO> selectList();
	
	public MemberVO selectMember(MemberVO mvo);
	public int insertMember(MemberVO mvo);
	
	public List<ProdVO> prodList();
	//상품목록
	
	public int deleteMember(String mid);
}
