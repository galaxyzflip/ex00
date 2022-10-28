package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	
	//아래형식 파라미터가 전달되면 Date형식으로 변경
	//이 어노테이션 있으면 initbinder 없어도됨
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
}
