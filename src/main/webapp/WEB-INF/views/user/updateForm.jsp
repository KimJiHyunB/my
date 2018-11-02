<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>UPDATE FORM</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

<%@include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript"></script>

</head>
<body id="top">
<section id="main" class="wrapper style1">
<header class="major">
<h2>PARK</h2>
<p>And don't you know, it's a beautiful new day</p>
</header>
<div class="container">
<section>
<h2>MY PAGE</h2>

<form id="updateform" action="update"  method="post" onsubmit="return formCheck();">
<table>
	<tr>
		<th>ID</th>
		<td>${user.user_id}</td>
	</tr>
	<tr>
		<th>PASSWORD</th>
		<td><input type="password" name="user_pass" id="user_pass" placeholder="비밀번호 입력" /><br>
		<input type="password" id="user_pass2" placeholder="비밀번호 다시 입력" /></td>
	</tr>
	<tr>
		<th>NAME</th>
		<td><input type="text" name="user_name" id="user_name" placeholder="이름 입력" value="${user.user_name}" /></td>
	</tr>
	<tr>
		<th>EMAIL</th>
		<td><input type="text" name="user_email" id="user_email" placeholder="이메일  입력" value="${user.user_email}" /></td>
	</tr>
	<tr>
		<th>PHONE</th>
		<td><input type="text" name="user_phone" placeholder="phone 입력" value="${user.user_phone}" style="width:300px;" /></td>
	</tr>
	<tr>
		
	</tr>
	<tr>
		<th>ADD</th>
		<td><input type="text" name="user_add" placeholder="주소 입력" value="${user.user_add}" style="width:300px;" /></td>
	</tr>
</table>
	<br>

<input type="submit" value="modify" />
<input type="reset" value="reset" />

</form>
</section>
</div>
</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>