package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.common.SearchVO;
import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(SearchVO search);
	public int deleteReply(int rno);
	public ReplyVO getreply(int bno);
	public int selectReplyCount(int bno);
	public int insertReply(ReplyVO rvo);
	
	public List<ReplyVO> replyListNoPage(SearchVO search);
	//chart
	public List<Map<String, Object>> selectCntByMember();
}
