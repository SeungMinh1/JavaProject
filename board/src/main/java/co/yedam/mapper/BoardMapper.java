package co.yedam.mapper;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

public interface BoardMapper {
	public String getTimes();
	public List<BoardVO> selectList(SearchVO search); //페이지당 5개씩 가져오는기능
	public int selectCount(SearchVO search);
	public int insertBoard(BoardVO bo);
	public int deleteBoard(int bno);
	public int updateBoard(BoardVO vo);
	public BoardVO getBoard(int bno);
}
