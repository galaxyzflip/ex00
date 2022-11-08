<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/include/include-header.jspf" %>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form id="frm">
	<table class="board_view">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="35%">
		</colgroup>
		
		<caption>게시글 상세</caption>
		
		<tbody>
			<tr>
				<th scope="row">글번호</th>
				<td>
					${map.IDX }
					<input type="hidden" id="IDX" name="IDX" value="${map.IDX }">
				</td>
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
				<td colspan=3>
					<input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" class="view_text">
					<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS }</textarea>
				</td>
			</tr>
		
		</tbody>
		
	</table>

</form>

<a href="#this" class="btn" id="list">목록으로</a>
<a href="#this" class="btn" id="update">저장하기</a>
<a href="#this" class="btn" id="delete">삭제하기</a>

<%@ include file="/WEB-INF/include/include-body.jspf" %>


<script>


	$(document).ready(function() {
		$('.btn').on("click", function(e) {
			e.preventDefault();

			var id = $(this).attr("id");
			
			var comSubmit = new ComSubmit();
			
			if(id == 'list'){
				comSubmit.setUrl("<c:url value='/sample/openBoardList.do'/>");
				comSubmit.submit();
				
			}else if(id == 'update'){
				comSubmit.setUrl("<c:url value='/sample/updateBoard.do'/>");
				comSubmit.submit();
				
			}else if(id == 'delete'){
				comSubmit.setUrl("<c:url value='/sample/deleteBoard.do'/>");
				comSubmit.addParam("IDX", $("#IDX").val());
				comSubmit.submit();
			}

		})

	})
</script>



</body>
</html>












