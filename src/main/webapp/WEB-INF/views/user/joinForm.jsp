<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>JOIN FORM</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

<%@include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">
<c:if test="${errorMsg != null}">alert('${errorMsg}');</c:if>

function formCheck() {
	var pw = document.getElementById('user_pass');
	var pw2 = document.getElementById('user_pass2');
	var name = document.getElementById('user_name');
	
	if (pw.value != pw2.value) {
		alert("password check please");
		pw.focus();
		pw.select();
		return false;
	}
	
	if (name.value == '') {
		alert("name please");
		name.focus();
		name.select();
		return false;
	}
	return true;
}
$(function(){
	$('#checkId').on('click',function(){
		// id 속성값 가져오기 .val()메서드 사용
		var user_id = $('#user_id').val();
		
		// 데이터 다 꺼냈고 에이젝스로 보낸다
		$.ajax({
			url : "idcheck",
			type : "POST",
			data : {
				user_id : user_id
			},
			success : function(data){
				alert(data);
			},
			error : function(e){
				alert("실패");
			}
		});
	});
});
</script>
</head>
<body id="top">
<section id="main" class="wrapper style1">
<header class="major">
<h2>PARK</h2>
<p>And don't you know, it's a beautiful new day</p>
</header>
<div class="container">
<section>
<h2>WELCOME! ROOM NUMBER 5</h2>

<br>
<form id="joinform" action="join" method="post" onsubmit="return formCheck();">
<table>
	<tr>
		<th>ID</th>
		<td>
			<input type="text" name="user_id" id="user_id" maxlength="10" value="${user.user_id}" />
			<input type="button" value="ID CHECK" id="checkId">
		</td>
	</tr>
	<tr>
		<th>PASSWORD</th>
		<td><input type="password" name="user_pass" id="user_pass" value="${user.user_pass}" />
		<input type="password" id="user_pass2" value="${user.user_pass}" /></td>
	</tr>
	<tr>
		<th>NAME</th>
		<td><input type="text" name="user_name" id="user_name" value="${user.user_name}" /></td>
	</tr>
	<tr>
		<th>E-MAIL</th>
		<td><input type="text" name="user_email" id="user_email" value="${user.user_email}" /></td>
	</tr>

	<tr>
		<th>PHONE</th>
		<td><input type="text" name="user_phone" value="${user.user_phone}" style="width:300px;" /></td>
	</tr>
	<tr>
		<th>ADDRESS</th>
		<td><input type="text" name="user_add" value="${user.user_add}" style="width:300px;" /></td>
	</tr>
</table>
	<br>

<input type="submit" class="button alt" value="join" />
<input type="reset" value="reset" />

</form>
</section>
</div>
</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>