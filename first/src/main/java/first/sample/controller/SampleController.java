package first.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import first.sample.service.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping("/openBoardList.do")
	public ModelAndView openBoardList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardList");
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap.getMap());
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/sample/boardWrite";
	}
	
	@RequestMapping("insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
		sampleService.insertBoard(commandMap.getMap(), request);
		return mv;
	}
	
	@RequestMapping("openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardDetail");
		Map<String, Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		
		mv.addObject("list", map.get("list"));
		mv.addObject("map", map.get("map"));
		return mv; 
	}
	
	@RequestMapping("openBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardUpdate");
		log.info(commandMap.toString());
		Map<String, Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		log.info(map.toString());
		
		return mv; 
	}
	
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(CommandMap commandMap, Model model, HttpServletRequest request) throws Exception{

		sampleService.updateBoard(commandMap.getMap(), request);
		model.addAttribute("IDX", commandMap.get("IDX"));
		return "redirect:/sample/openBoardDetail.do";
	}
	
	
	
	@RequestMapping("deleteBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
		sampleService.deleteBoard(commandMap.getMap());
		return mv;
	}
	
	
			
	
	
	
	
	
	
	
	
			
}
