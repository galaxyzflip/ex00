package org.zerock.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	/*
	 * @Test public void testGetList() { mapper.getList().forEach(board ->
	 * log.info(board)); }
	 * 
	 * @Test public void testInsert() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 글"); board.setContent("새로 작성하는 글");
	 * board.setWriter("newbie"); mapper.insert(board); log.info(board);
	 * 
	 * }
	 * 
	 * @Test public void testInsertSelectKey() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 글 selectkey");
	 * board.setContent("새ㅔ로 작성하는 글  selectkeyt"); board.setWriter("newbie");
	 * mapper.insertSelectKey(board); log.info(board); }
	 * 
	 * @Test public void testRead() { BoardVO board = mapper.read(8L);
	 * log.info(board);
	 * 
	 * }
	 * 
	 * @Test public void deletetest() { log.info("delete count:" +
	 * mapper.delete(3L));
	 * 
	 * }
	 * 
	 * @Test public void testUpdate() { BoardVO board = new BoardVO();
	 * board.setBno(5L); board.setTitle("수정된 제목"); board.setContent("수정된 내용");
	 * board.setWriter("user002"); int count = mapper.update(board);
	 * log.info("udpate count: " + count); }
	 */
	
	/*
	 * @Test public void testPaging() { Criteria cri = new Criteria(3, 10);
	 * List<BoardVO> list = mapper.getListwithPaging(cri); list.forEach(board ->
	 * log.info(board)); }
	 */
	
	@Test
	public void testEarch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로"	);
		cri.setType("TCW");
		
		List<BoardVO> list = mapper.getListwithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	
	
}
