<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Create Account</title>
<link rel="stylesheet"
	href="/SOF3021_Assignment_Canhnhph17851/css/bootstrap.min.css" />
</head>
<body>
	<form:form method="POST"
		action="/SOF3021_Assignment_Canhnhph17851/admin/products/update/${pro.id }"
		modelAttribute="pro" class=" row col-4">
		<div class="pb-1 row">
			<label>Name</label>
			<form:input path="name" />
		</div>
		<div class="pb-1 row">
			<label>Image</label>
			<form:input path="image" />
		</div>
		<div class="pb-1 row">
			<label>Price</label>
			<form:input path="price" />
		</div>
		<div class="pb-1 row">
			<label>Available</label>
			<form:select path="available">
				<form:option value="0">In-Available</form:option>
				<form:option value="1">Available</form:option>
			</form:select>
		</div>
		<div class="pb-1 row">
			<label>Category</label>
			<form:select path="category">
				<c:forEach items="${ listCate }" var="cate">
					<option value="${ cate.id }">${ cate.name }</option>
				</c:forEach>
			</form:select>
		</div>
		<button class="pb-1 row">Save</button>
	</form:form>
</body>
</html>