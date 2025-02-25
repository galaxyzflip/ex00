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
			
				<div class="form-group">
					<label>Bno</label>
					<input class="form/control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Title</label>
					<input class="form-control" name='title' value='<c:out value="${board.title }"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content' readonly="readonly">
						<c:out value="${board.content }"/>
					</textarea>
				</div>
			
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name='writer' value='<c:out value="${board.writer }"/>' readonly="readonly">
				</div>
				
				<button data-oper='modify' class="btn btn-default">
					Modify
				</button>
				<button data-oper='list' class="btn btn-info">
					List
				</button>
				
				<form id='operForm' action="/board/modify" method="get">
					<input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno }"/>">
					<input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum }"/>">
					<input type="hidden" name="amount" value="<c:out value="${cri.amount }"/>">
					<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
					<input type="hidden" name="type" value="<c:out value="${cri.type }"/>"/>
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
	
		/* button 클릭시 처리 정의, action속성의 값을 /board/modify, /board/list 로 처리 */
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			
			operForm.find('#bno').remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
			
		});
		
	})

</script>



</html>