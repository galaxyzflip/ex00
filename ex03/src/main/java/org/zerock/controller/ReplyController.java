package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	
	final static int PAGE_PER_REPLY = 10;
	
	private ReplyService service;
	
	
	
	@PostMapping(value="/new", consumes="application/json", //json 타입과 일치할때만 요청을 매핑해줌 , 클아이언트가 서버에게 보내는 데이터 타입을 명시
			produces= {MediaType.TEXT_PLAIN_VALUE}) //생산 가능한 미디어타입의 목록을 지정한다. 서버가 클라이언트에게 반환하는 데이터 타입을 명시
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		//ResponseEntity - 응답 코드까지 보낼때 HttpStatus.* 같은것들
		
		log.info("ReplyVO : " + vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT: " + insertCount);
		
		return insertCount == 1 
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//아래 value로 접근하면 xml 로 출력된다. xml, json
	@GetMapping(value="/pages/{bno}/{page}", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, 
			@PathVariable("bno") Long bno){
		
		Criteria cri = new Criteria(page, PAGE_PER_REPLY);
		
		log.info("get REply List bno : " + bno);
		log.info("cri: " + cri);
		
		return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, bno), HttpStatus.OK);
		
	}

	
	@GetMapping(value = "/{rno}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {

		log.info("get:" + rno);

		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);

	}
	 	
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		log.info("remove: " + rno);
		
		return service.remove(rno) == 1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}
			, value="/{rno}"
			, consumes="application/json"
			, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, 
			@PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		log.info("rno :" + rno);
		log.info("modify:" + vo);
		
		return service.modify(vo) == 1
				? new ResponseEntity<String>("sucess", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
}












