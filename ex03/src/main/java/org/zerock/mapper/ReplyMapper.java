package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno); //특정 댓글 읽기
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	/**cri, 원글번호 파라미터*/
	//Mybatis는 두개이상 파라미터 전달하기 위해서는 객체로 구성, Map, @Param을 사용해야함
	//이게 아닌경우 상관없었지...
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	
	public List<ReplyVO> getListWithPaging2(
			Map map);
	
	
	
	public int getCountByBno(Long bno);
}
