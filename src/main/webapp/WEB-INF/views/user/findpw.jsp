<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${cookie.save_id.value ne null}">
	<c:set var="saveid" value="${cookie.save_id.value}"/>
	<c:set var="idck" value=" checked=\"checked\""/>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY-비밀번호 찾기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(document).on("click", ".find-btn", function() {
		let vid = document.getElementById("userid").value;
		if(vid == null || vid == ""){
			alert("아이디를 입력하세요.");
			return;
		}
		$.ajax({
			url:'${root}/admin/user/' + vid,  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			success:function(user) {
				if(user != null){
					$("#resultarea").text("비밀번호는"+user.userpwd+"입니다.");
				}else{
					$("#resultarea").text("등록되지 않은 아이디 입니다.");
				}
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
			}				
		});			
	});
});
</script>
</head>
<body>

<div class="container" align="center">
	<h2>비밀번호 찾기</h2>
	<div class="col-lg-6" align="center">
		<form id="findform" method="get" action="">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${saveid}">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning find-btn">찾기</button>
			</div>
		</form>
	</div>
	<div class="col-lg-6" align="center" id="resultarea">
	
	</div>
</div>
