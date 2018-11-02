<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<title>PROD READ</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

<%@include file="../include/header.jsp" %>

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script>

function paging(pageNum,text) {
	location.href="outerList?page="+pageNum+"&typeText="+text;
}

</script>
</head>
<body id="top">
<body id="top">
<section id="one" class="wrapper style1">
<header class="major">
<h2>${typeText }</h2>
<p>And don't you know, it's a beautiful new day</p>
</header>
<div class="container">

<div class="row">
<c:forEach var="board" items="${boardlist}">

<div class="4u">
<section class="special box">
<img src="/boardfile/${board.prod_saveimg}" height="216px">
<h5><a href="read?prod_id=${board.prod_id}">${board.prod_name}</a></h5>
<p>${board.prod_price}</p> 

</section>
</div>

</c:forEach>
</div>
                    
	<a onclick="javascript:paging('${navi.currentPage - navi.pagePerGroup}','${typeText }')">◁◁ </a> &nbsp;&nbsp;
	<a onclick="javascript:paging('${navi.currentPage - 1}','${typeText }')">◀</a> &nbsp;&nbsp;

	<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}"> 
		<c:if test="${counter == navi.currentPage}"></c:if>
			<a onclick="javascript:paging('${counter}','${typeText }')">${counter}</a>
		<c:if test="${counter == navi.currentPage}"></c:if>
	</c:forEach>
	&nbsp;&nbsp;
	<a onclick="javascript:paging('${navi.currentPage + 1}','${typeText }')">▶</a> &nbsp;&nbsp;
	<a onclick="javascript:paging('${navi.currentPage + navi.pagePerGroup}','${typeText }')">▷▷</a>
	
<br><br>

</div>
</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>