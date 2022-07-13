<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Update Account</title>
<link rel="stylesheet"
	href="/SOF3021_Assignment_Canhnhph17851/css/bootstrap.min.css" />
</head>
<body>
	<form:form method="POST"
	 action="/SOF3021_Assignment_Canhnhph17851/admin/accounts/update/${account.id }"
		modelAttribute="account" class=" row col-4">
		<div class="pb-1 row">
			<label>Fullname</label>
			<form:input path="fullname"/>
		</div>
		<div  class="pb-1 row">
			<label>Email</label>
			<form:input path="email" type="email" />
		</div>
		<div  class="pb-1 row">
			<label>Username</label>
			<form:input path="username" />
		</div>
		<div  class="pb-1 row">
			<label>Password</label>
			<form:password path="password" />
		</div>
		<div  class="pb-1 row">
			<label>Photo</label>
			<form:input path="photo" />
		</div>
		<div  class="pb-1 row">
			<label>Admin</label>
			<form:select path="admin">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<button class="pb-1 row">Save</button>
	</form:form>
</body>
</html>