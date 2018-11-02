<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>PRODUCT FORM</title>
<link rel="stylesheet" href="../resources/css/skel.css" />	
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/style-xlarge.css" />

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
<h2>Product Insert</h2>


<form id="writeform" action="insertProd"  method="post" 
	enctype="multipart/form-data">
	
<table>
<tr>

	<th>type</th>
	<td>
		<input type="text" name="prod_type" id="prod_type" style="width:400px;">
	</td>
</tr>
<tr>
	<th>name</th>
	<td>
		<input type="text" name="prod_name" id="prod_name" style="width:400px;">
	</td>
</tr>
<tr>
	<th>price</th>
	<td>
		<input type="text" name="prod_price" id="prod_price" style="width:400px;">
	</td>
</tr>
<tr>
	<th>inventory</th>
	<td>
		<input type="text" name="prod_inv" id="prod_inv" style="width:400px;">
	</td>
</tr>
<tr>
	<th>explain</th> 
	<td>
		<textarea name="prod_exp" id="prod_exp" style="width:400px;height:200px;resize:none;"></textarea>
	</td>
</tr>
<tr>
	<th>image</th> 
	<td>
		<input type="file" name="upload" size="30">
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="submit" />
	</td> 
</tr>
</table>
</form>

</section>
</div>
</section>
<%@include file="../include/footer.jsp" %>
</body>
</html>