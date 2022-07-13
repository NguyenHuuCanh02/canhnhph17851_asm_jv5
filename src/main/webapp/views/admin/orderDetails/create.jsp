<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/SOF3021_Assignment_Canhnhph17851/css/bootstrap.min.css" />
</head>
<body>

	<header>
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="https://static.musictoday.com/store/bands/4606/images/PromoBanners/TR_Hero_1920x950_VHSTourMerch_043019.jpg"
						class="d-block w-100" alt="..." height="400px">
				</div>
				<div class="carousel-item">
					<img
						src="https://th.bing.com/th/id/R.3c724905d6c8f5be1abb7eadaad66ba4?rik=7a0pW9H%2fdYhfQg&pid=ImgRaw&r=0"
						class="d-block w-100" alt="..." height="400px">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</header>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="/SOF3021_Assignment_Canhnhph17851/views/layout.jsp">Trang
				Chủ</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<!-- Admin -->
					<c:if test="0==0">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Quản lí </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item"
									href="/SOF3021_Assignment_Canhnhph17851/admin/accounts/index">Quản
										lý người dùng</a></li>
								<li><a class="dropdown-item"
									href="/SOF3021_Assignment_Canhnhph17851/admin/products/index">Quản
										lý sản phẩm</a></li>
								<li><a class="dropdown-item"
									href="/SOF3021_Assignment_Canhnhph17851/admin/categories/index">Quản
										lý danh mục</a></li>

							</ul></li>

					</c:if>


					<!-- người dùng -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Cài đặt </a>
				</ul>

				<ul class="ms-auto">
					<div class="d-flex align-items-center">
						<a class="navbar-brand py-1"></a>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="row">
		<aside class="col-3"></aside>
		<article class="row col-9">
			<form:form method="POST" class="form-control"
				action="/SOF3021_Assignment_Canhnhph17851/admin/orderDetails/store"
				modelAttribute="tai">
				<div >
					<label class="col-1">Oder</label>
					<form:select path="order" name="order">
							<form:option value="${ oder.id }">${ oder.user.fullname}</form:option>
					</form:select>
				</div>
				<div >
					<label class="col-1">Product</label>
					<form:select path="product" name="product">
						<c:forEach items="${ pro }" var="pro">
							<form:option value="${ pro.id }">${ pro.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div >
					<label class="col-1">Price</label>
					<form:select path="price" name="price">
						<c:forEach items="${ pro }" var="pro">
							<form:option value="${ pro.price }">${ pro.name}-${ pro.price}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div >
					<label class="col-1">Quantity</label>
					<form:input path="quantity" />
				</div>
				<button class="btn btn-success">Create</button>
			</form:form>

		</article>
	</div>
	<div class="bg-dark text-white text-center mt-2">Nguyễn Hữu Cảnh</div>

	<script src="/SOF3021_Assignment_Canhnhph17851/js/jquery.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/popper.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/bootstrap.min.js"></script>
</body>
</html>