package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //set/getter, toString, hashCode 등 생성
@AllArgsConstructor //모든 멤버변수를 포함한 생성자 생성
@NoArgsConstructor //매게변수 없는 생성자 생성
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
}
