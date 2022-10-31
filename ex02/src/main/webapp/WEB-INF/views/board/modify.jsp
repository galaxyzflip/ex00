<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->



<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading-body -->
			
			<div class="panel-body">
			
				<!-- redirect 처리함 -->
				<form role="form" action="/board/modify" method="post">
				
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
					<input type='hidden' name='amount'  value='<c:out value="${cri.amount }" />'>
				
					<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
					<input type="hidden" name="keyword" value='<c:out value="${cri.type }"/>'> 
				
					<div class="form-group">
						<label>Bno</label>
						<input class="form/control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name='title' value='<c:out value="${board.title }"/>'>
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='content' >
							<c:out value="${board.content }"/>
						</textarea>
					</div>
				
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name='writer' value='<c:out value="${board.writer }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name='regdate' value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>UpdateDate</label>
						<input class="form-control" name='updatedate' value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updatedate }"/>' readonly="readonly">
					</div>
					
					
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>


				</form>
			
			</div>
			<!--  end panel-body -->
		
		</div>
		<!-- end panel-body -->
	
	</div>
	<!-- end panel -->

</div>
<!-- /.row -->


</body>


<script type="text/javascript">

	$(document).ready(function(){
	
		var formObj = $("form");
		
		$('button').on("click", function(e){
			
			e.preventDefault(); //button의 기본 기능 submit을 막고 button 의 oper에 따라 아래에서 작업 후 마지막에 submit 처리함
			
			var operation = $(this).data("oper");
			//무슨 버튼 클릭했는지
			
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action", "/board/remove");
				//button의 oper에 따라 action 속성의 내용을 수정 위는 remove 버튼 클릭시 /board/remove
			}else if(operation === 'list'){
				//move to list
				//클릭한 버튼이 list일 경우 처리
				
				formObj.attr("action", "/board/list").attr("method", "get");
				//list oper버튼 클릭시 action 속성의 값은 /board/list, method 방식은 get으로 변경
				//contrller클래스에서 /board/list get방식의 메소드 실행
				
				//필요한것들 복사해두기
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				
				formObj.empty(); 
				
				
				//삭제처리 후 list로 redirect 할때 기존 내용 지우고 list뷰에 필요한 것들 추가해준다.
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			
			formObj.submit();
			
		});
		
	});

</script>




</html>