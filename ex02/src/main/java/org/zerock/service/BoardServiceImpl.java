package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

//	1.
//	@Setter(onMethod_ = @Autowired)
//	
// 	2.
//	public BoardServiceImpl(BoardMapper mapper) {
//		this.mapper = mapper;
//	}

	private BoardMapper mapper;
	// @AllArgsConstructor 어노테이션으로 인해 모든 파라미터를 이용하는 생성자를 만들게 된다.
	// 2번 주석에 있는 생성자가 자동으로 생성된다. outline 참조

	@Override
	public void register(BoardVO board) {

		log.info("register..." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..........." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify......" + board);
		return mapper.update(board) == 1;
		
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove....." + bno);
		return mapper.delete(bno) == 1;
	}

	/*
	 * @Override public List<BoardVO> getList() { log.info("getList.............");
	 * 
	 * return mapper.getList();
	 * 
	 * }
	 */
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List width criteria : " + cri);
		return mapper.getListwithPaging(cri);
		
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

}
