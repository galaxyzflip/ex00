<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/include/include-header.jspf" %>


<title>Insert title here</title>
</head>
<body>

<table class="board_view">

	<colgroup>
		<col width="15%"/>
		<col width="35%"/>
		<col width="15%"/>
		<col width="35%"/>
	</colgroup>
	
	<caption>게시글 상세</caption>
	
	<tbody>
		<tr>
			<th scope="row">글 번호</th>
			<td>${map.IDX }</td>
			<th scope="row">조회수</th>
			<td>${map.HIT_CNT }</td>
		</tr>
			
		<tr>
			<th scope="row">작성자</th>
			<td>${map.CREA_ID }</td>
			<th scope="row">작성시간</th>
			<td>${map.CREA_DTM }</td>
		</tr>
		
		<tr>
			<th scope="row">제목</th>
			<td colspan="3">${map.TITLE }</td>
		</tr>
		
		<tr>
			<td colspan="4">${map.CONTENTS }</td>
		</tr>		
	
	</tbody>

</table>

<A HREF="#this" class="btn" id="list">목록으로</A>
<A HREF="#this" class="btn" id="update">수정하기</A>

<%@ include file="/WEB-INF/include/include-body.jspf" %>

<script>

	$(document).ready(function(){
		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openBoardList();
		})
		
		
		$("#update").on("click", function(e){
			e.preventDefault();
			fn_openBoardUpdate();
		})
	
	})
	
	function fn_openBoardList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardList.do'/>");
		comSubmit.submit();
	}
	
	function fn_openBoardUpdate(){
		var idx="${map.IDX}";
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardUpdate.do'/>");
		comSubmit.addParam("IDX", idx);
		comSubmit.submit();
	}


</script>


</body>
</html>











