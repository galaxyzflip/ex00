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

<style>
	
.uploadReuslt{
	width:100%;
	background-color:gray;
		
}

.uploadResult ul{
	display : flex;
	flex-flow : row;
	justify-content:center;
	align-items:center;
}

.uploadResult ul li{
	list-style:none;
	padding: 10px;
	
}

.uploadResult ul li img{
	width: 200px;
}

</style>

<body>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->





<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading-body -->
			
			<div class="panel-body">
			
				<form role="form" action="/board/register" method="post">
					<div class="form-group">
						<label>Title</label><input class="form-control" name="title">
					</div>
					
					<div class="form-group">
						<label>Test area</label><textarea class="form-control" rows="3" name='content'></textarea>
					</div>
					
					<div class="form-group">
						<label>Writer</label><input class="form-contro" name="writer">
					
					</div>
					
					<button type="submit" class="btn btn-default">Submit Button</button>
					<button type="reset" class="btn btn=default">Reset Button</button>
					
				</form>
			
			</div>
			<!--  end panel-body -->
		
		</div>
		<!-- end panel-body -->
	
	</div>
	<!-- end panel -->

</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			
			<div class="panel-heading">File Attach</div>		
			<!-- /.panel-heading -->
			
			<div class="panel-body">
				<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" multiple>
				</div>
				
				<div class="uploadResult">
					<ul>
					
					
					</ul>
				</div>
			
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<script>

	$(document).ready(function(){
		
		
		function showUploadResult(uploadResultArr){
			if(!uploadResultArr || uploadResultArr.length == 0){return;}
			
			var uploadUL = $(".uploadResult ul");
			var str ="";
			
			$(uploadResultArr).each(function(i, oj){
				if(!obj.image){
					var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
					str += "<li><div>";
					str += "<span>" + obj.fileName + "</span>";
					str += "<button type='button' class='btn btn-warning btn-circle'>";
					str += "<i class='fa fa-times'></i></button><br>";
					str += "<ing src='/display?fileName="+fileCallPath+"'>";
					str += "</div></li>"
					
					
				}else{
					var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
					var originPath = originPath + "\\" + obj.uuid + "_" + obj.fileName;
					originPath = originPath.replace(new RegExp(/\\/g), "/");
					str += "<li><a href=\"javascript:showImage(\'"+originPath+"/')\"><img src='/display?fileName="+fileCallPath+"'></li>";					 
				}
			})//end each
			
			uploadUL.append(str);
		}//end function
		
		
		var formObj = $('form[role="form"]');
		
		$("button[type='submit']").on("click", function(e){
			e.preventDefault();
			
			console.log("submit clicked");
		});
		
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880; //5MB
		
		function checkExtension(fileName, fileSize){
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			
			if(regex.test(fileName)){
				alert("해당 종류의 파일은 업로드할 수 없습니다");
				return false;
			}
			return true;
		}
		
		$("input[type='file']").change(function(e){
			
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			
			for(var i=0;i<files.length; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
			}
			$.ajax({
				url : '/uploadAjaxAction',
				type : "post",
				processData : false,
				contentType : false,
				data:formData,
				dataType : 'json',
				success : function(result){
					console.log(result);
					showUploadResult(result);//업로드 결과 처리 함수
				}
				
			})//end ajax
		})
		
	})

</script>


</body>
</html>