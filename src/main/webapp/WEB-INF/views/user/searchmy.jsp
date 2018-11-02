<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function () {
	$('#btn').on('click',function(){

		var user_id = $('#user_id').val();
		
		$.ajax({
			url : "searchmypw",
			type : "post",
			data : {
				user_id : user_id
			},
			datatype : "text",
			success : function(data){
				alert("password : " + data);
				$('#user_id').val('');
			}, 
			error : function(e){
				alert("again");
			}
			
		});

	});
	
	});
</script>
<%@include file="../include/header.jsp" %>
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

<form>
<input type="text"  name="user_id" id="user_id" placeholder="USER ID">
<input type="button" id="btn" value="search" class="button alt" />
</form>

</section>
</div>
</section>






<%@include file="../include/footer.jsp" %>
</body>
</html>