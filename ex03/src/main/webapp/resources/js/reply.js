//여기있는 코드들을 이용하여 url을 controller로 전달함
//get.jsp에서 함수 호출하고있음(테스트용)

console.log("Reply Module........");

var replyService = (function(){

	function add(reply, callback, error) {
		console.log("add reply...........");
		
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error) {
					error(er);
				}
			}
			
		})
	}
	
	function getList(param, callback, error) {
		
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json", 
			function(data){
				if(callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err){
				if(error) {
					error();
				}
			});
		
	}
	
	
	function remove(rno, callback, error) {
		$.ajax({
			type : 'delete', 
			url : '/replies/' + rno,
			success : function(deleteResult, status, xhr){
				if(callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error) {
					error(er);
				}
			}
		});
		
	}
	
	
	function update(reply, callback, error) {
		console.log("rno : " + reply.rno);
		
		$.ajax({
			type : 'put',
			url : '/replies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function get(rno, callback, error) {
		$.get("/replies/" + rno + ".json", function(result){
			
			if(callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error) {
				error();
			}
		});
	}
				
				
				
		
	
	
	
		
	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		get : get
	};
		
})();
	
	
	