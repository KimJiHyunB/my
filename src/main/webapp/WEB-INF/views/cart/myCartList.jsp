<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>MY CART</title>
<link rel="stylesheet" href="../resources/css/style.css">
<%@include file="../include/header.jsp" %>
</head>
<body>
<section id="content">
<div class="container">
	<h2>MY CART</h2>
	<c:choose>
	<c:when test=" ${myCartList==null} -">
	empty </c:when>
	<c:otherwise>
	<form name="form1" id="form1" method="post" action="">
		<table>
		<tr>
			<th>
				product
			</th>
			<th>
				price
			</th>
			<th>
				Qty
			</th>
			<th>
				account
			</th>
			<th>
				romove
			</th>
		</tr>
		<c:foreach var="row" items="${myCartList}" varstatus="i">
		<tr>
			<td>
				 ${row.prod_name}
			</td>
			<td style="width: 80px" align="right">
				<fmt:formatnumber pattern="###,###,###" value="${row.prod_price}"/>
			</td>
			<td>
				<input type="number" style="width: 40px" name="amount" value="${row.amount}" min="1">
				<input type="hidden" name="productId" value="${row.prod_id}">
			</td>
			<td style="width: 100px" align="right">
				<fmt:formatnumber pattern="###,###,###" value="${row.money}"/>
			</td>
			<td>
				<a href="deleteCart?cart_id=${row.cart_id}">romove</a>
			</td>
		</tr>
		</c:foreach>
		<tr>
			<td colspan="5" align="right">
				 Subtotal : <fmt:formatnumber pattern="###,###,###" value="${sumMoney}"/><br>
				 shipping : ${fee}<br>
				 Estimated Total :<fmt:formatnumber pattern="###,###,###" value="${total}"/>
			</td>
		</tr>
		</table>
	</form>
	</c:otherwise>
	</c:choose>
	<input type="submit" class="button alt" value="check out"/>
</div>
</section>
</body>
</html>