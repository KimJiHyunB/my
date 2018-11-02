<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<title>USER LOGIN</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

<%@include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script>
$(function () {
	if($("#user_id").val() == ""){
        
        $("#user_id").focus();
        return false;
      }
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
<h2>MY PAGE</h2>

		<form action="login" method="post">
			<input type="text" name="user_id" id="user_id" placeholder="USER ID">			
			<br/>
			<input type="password"  name="user_pass" id="user_pass" placeholder="PASSWORD">
			<br/>
			<input type="submit" value="LOGIN" class="button alt" />
		</form>
		<br/>
		<a href="searchmy">
			<p class="small">Forgot your password?</p>
		</a>

</section>
	</div>

</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>