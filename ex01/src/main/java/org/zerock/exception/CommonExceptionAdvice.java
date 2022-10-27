package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;


@ControllerAdvice //컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@Log4j //로그기록용
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class) //해당 메서드가 ()에 들어가는 예외 타입을 처리한다.
	public String except(Exception ex, Model model) {
		log.error("Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page"; //문자열이므로 jsp 파이르이 경로가 된다. error_page.jsp
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException ex) {
		return "custom404";
	}
}
