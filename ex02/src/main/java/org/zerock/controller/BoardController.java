package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	/*
	 * @GetMapping("/list") public void list(Model model) { log.info("list");
	 * model.addAttribute("list", service.getList()); }
	 */
	
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));
		//테스트용
		int total = service.getTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("register:" + board);
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno()); 
		//등록작업이 끝난 후 다시 목록화면으로 돌아가는데 그때 새로 등록된 게시물의 번호(bno)를 같이 전달하기 위함..
		//list.jsp에서 modal로 등록된 글번호 보여줌
		
		return "redirect:/board/list";
		//forward 하면 안됨 url이 남아있어 같은 요청이 다시 들어갈 수 있음
		//동일한 내용을 전송할 수 없도록 URL을 이동하는 방식을 이용해야함 (등록, 수정, 삭제 작업 후)
	}
	
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) { // bno파라미터값을 알맞게 Long 형으로 변환해준다. 파라미터가 없으면 400 에러 발생함...
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify :" + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		//rttr은 일회성으로만 데이터를 전달함, redirect 처리하지만 뷰로 보내줘야할 데이터가 있을 경우 사용한다.
		
		return "redirect:/board/list";
	}
	
	
	
	/*
	 * UriComponentsBuilder 클래스 적용시
	 * @PostMapping("/modify") public String modify(BoardVO board, Criteria cri,
	 * RedirectAttributes rttr) { log.info("modify :" + board);
	 * 
	 * if(service.modify(board)) { rttr.addFlashAttribute("result", "success"); }
	 * 
	 * return "redirect:/board/list" + cri.getListLink(); }
	 */
	
	
	/*
	 * UriComponentsBuilder 클래스 적용시
	 * 
	 * @PostMapping("/remove") public String remove(@RequestParam("bno") Long bno,
	 * Criteria cri, RedirectAttributes rttr) { log.info("remove......" + bno);
	 * 
	 * if(service.remove(bno)) { rttr.addFlashAttribute("result", "success"); }
	 * 
	 * return "redirect:/board/list"+cri.getListLink(); }
	 */
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove......" + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
}


















