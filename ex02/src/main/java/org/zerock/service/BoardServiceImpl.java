package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList.............");
		
		return mapper.getList();

	}

}
