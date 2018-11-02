<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
<link rel="stylesheet" href="../resources/css/skel.css"/>
<link rel="stylesheet" href="../resources/css/style.css"/>
<link rel="stylesheet" href="../resources/css/style-xlarge.css"/>
</head>
<body>
<header id="header" class="skel-layers-fixed">
<div class="container">
	<a href="${pageContext.request.contextPath}">
	<h1>ROOM NUMBER 5</h1>
	</a>
	<nav id="nav">
	<ul>
		<c:if test="${loginId==null}">
		<li><a href="${pageContext.request.contextPath}/user/joinForm">JOIN</a></li>
		<li><a href="${pageContext.request.contextPath}/user/loginForm">LOGIN</a></li>
		</c:if>
		<c:if test="${loginId !=null}">
		<li><a class="cate" href="${pageContext.request.contextPath}/user/logout">LOGOUT</a></li>
		</c:if>
		<li><a class="cate" href="${pageContext.request.contextPath}/cart/myCart">CART</a></li>
		<li><a class="cate" href="${pageContext.request.contextPath}/user/update">MYPAGE</a></li>
		<c:if test="${loginId=='admin'}">
		<li><a class="cate" href="${pageContext.request.contextPath}/prod/prodForm">INSERT</a></li>
		</c:if>
		<li><a href="${pageContext.request.contextPath}/prod/outerList?typeText=outer">OUTER</a></li>
		<li><a href="${pageContext.request.contextPath}/prod/outerList?typeText=top">TOP</a></li>
		<li><a href="${pageContext.request.contextPath}/prod/outerList?typeText=pants">PANTS</a></li>
		<li><a href="${pageContext.request.contextPath}/prod/outerList?typeText=skirt">SKIRT</a></li>
		<c:if test="${loginId !=null}">
		<li>HELLO! " ${sessionScope.loginId} "</li>
		</c:if>
	</ul>
	</nav>
</div>
</header>
<div class="header_spacing" style="height: 120px;">
</div>
</body>
</html>