<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Update Category</title>
<link rel="stylesheet"
	href="/SOF3021_Assignment_Canhnhph17851/css/bootstrap.min.css" />
</head>
<body>
	<form:form method="POST" action="/SOF3021_Assignment_Canhnhph17851/admin/categories/update/${cate.id }"
		modelAttribute="cate" class=" row col-4">
		<div class="pb-1 row">
			<label>Name</label>
			<form:input path="name"/>
		</div>
		<button class="pb-1 row">Save</button>
	</form:form>
</body>
</html>