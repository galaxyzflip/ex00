package org.zerock.domain;

import java.util.Date;

import lombok.Data;


/** 댓글 1개의 VO*/
@Data
public class ReplyVO {

	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
