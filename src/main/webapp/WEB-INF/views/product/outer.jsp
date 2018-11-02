<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>OUTER</title>
<link rel="stylesheet" href="../resources/css/skel.css"/>
<link rel="stylesheet" href="../resources/css/style.css"/>
<link rel="stylesheet" href="../resources/css/style-xlarge.css"/>
<%@include file="../include/header.jsp" %>
<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
<script>
function pagingFormSubmit(currentPage) {
	var form = document.getElementById('pagingForm');
	var page = document.getElementById('page');
	page.value = currentPage;
	form.submit();
}
</script>
</head>
<body id="top">
<section id="one" class="wrapper style1">
<header class="major">
<h2>PARK</h2>
<p>
	And don't you know, it's a beautiful new day
</p>
</header>
<!-- <h2>MY PAGE</h2> -->
 total : ${navi.totalRecordsCount}
<div class="container">
	<c:foreach var="board" items="${boardlist}">
	<div class="row">
		<div class="4u">
			<section class="special box">
			<img src="/boardfile/${board.prod_saveimg}" width="30%">
			<h5><a href="read?prod_id=${board.prod_id}">${board.prod_name}</a></h5>
			<p>
				${board.prod_price}
			</p>
			</section>
		</div>
	</div>
	</c:foreach>
</div>
<a href="javascript:pagingFormSubmit(${navi.currentPage - navi.pagePerGroup})">◁◁ </a> &nbsp;&nbsp; <a href="javascript:pagingFormSubmit(${navi.currentPage - 1})">◀</a> &nbsp;&nbsp; <c:foreach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
<c:if test="${counter==navi.currentPage}"><b></c:if>
<a href="javascript:pagingFormSubmit(${counter})">${counter}</a>&nbsp; <c:if test="${counter==navi.currentPage}"></b></c:if>
</c:foreach>
&nbsp;&nbsp; <a href="javascript:pagingFormSubmit(${navi.currentPage + 1})">▶</a> &nbsp;&nbsp; <a href="javascript:pagingFormSubmit(${navi.currentPage + navi.pagePerGroup})">▷▷</a>
<br>
<br>
<%-- <form id="pagingForm" method="get" action="outerList">
	<input type="hidden" name="page" id="page"/>
	제목 : <input type="text" name="typeText" value="${typeText}"/>
	<input type="button" onclick="pagingFormSubmit(1)" value="검색">
</form> --%>
<section id="two" class="wrapper style1"></section>
</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>