package mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	private Long[] bnoArr = { 4194307L, 4194306L, 4194305L, 4194304L, 4194303L };

	/*
	 * @Test public void testMapper() { log.info(mapper);
	 * 
	 * }
	 */

	/*
	 * @Test public void testCreate() { IntStream.rangeClosed(1, 10).forEach(i ->{
	 * ReplyVO vo = new ReplyVO(); vo.setBno(bnoArr[i % 5]); vo.setReply("댓글 테스트 " +
	 * i); vo.setReplyer("replyer" + i);
	 * 
	 * mapper.insert(vo);
	 * 
	 * }); }
	 * 
	 * @Test public void testMapper() { log.info(mapper); }
	 */

	/*
	 * @Test public void testRead() { Long targetRno = 10L; ReplyVO vo =
	 * mapper.read(targetRno);
	 * 
	 * log.info(vo);
	 * 
	 * }
	 */

	/*
	 * @Test public void testDelete() { Long targetRno = 5L;
	 * mapper.delete(targetRno); }
	 */

	/*
	 * @Test public void testUpdate() {
	 * 
	 * Long targetRno = 10L;
	 * 
	 * ReplyVO vo = mapper.read(targetRno); vo.setReply("Update Reply ssss");
	 * 
	 * int count = mapper.update(vo);
	 * 
	 * log.info("update count: sss" + count); }
	 */
	
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 4194306L);
		
		replies.forEach(reply -> log.info(reply));
		
	}

}
