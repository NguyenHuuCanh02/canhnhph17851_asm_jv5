<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
				href="/SOF3021_Assignment_Canhnhph17851/index">Trang
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
					<c:if test="${sessionScope.user.admin==1}">

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
								<li><a class="dropdown-item"
									href="/SOF3021_Assignment_Canhnhph17851/admin/orders/index">Quản
										lý hóa đơn</a></li>
								<li><a class="dropdown-item"
									href="/SOF3021_Assignment_Canhnhph17851/admin/orderDetails/index">Quản
										lý hóa đơn chi tiết</a></li>
							</ul></li>

					</c:if>


					<!-- người dùng -->
					<c:if test="${empty sessionScope.user}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle"
							href="/SOF3021_Assignment_Canhnhph17851/login" role="button">
								Đăng nhập</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.user}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle"
							href="/SOF3021_Assignment_Canhnhph17851/logout" role="button">
								Đăng xuất </a></li>
					</c:if>
				</ul>
				<ul class="ms-auto">
					<div class="d-flex align-items-center">
						<a class="navbar-brand py-1">${ user.fullname}</a>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="row">
		<aside class="col-3">
			<div class="card m-3" style="width: 22rem;">
				<div class="card-header">Categories</div>
				<c:forEach items="${ listCate }" var="cate">
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${cate.name }</li>
					</ul>
				</c:forEach>
			</div>
		</aside>
		<article class="row col-9">
			<c:forEach items="${ listPro }" var="pro">
				<div class="card col-3 m-3" style="width: 21rem;">
					<img src="${pro.image }" class="card-img-top" alt="..." width="100%" height="300px">
					<div class="card-body">
						<h5 class="card-title">${ pro.name }</h5>
					</div>
					<div class="card-body">
						<form action="/SOF3021_Assignment_Canhnhph17851/carts"
							method="get">
							<input type="hidden" name="productId" value="${ pro.id }">
							<li><button>
									<i class="fa fa-shopping-cart">Thêm vào giỏ hàng</i></li>
						</form>
					</div>
				</div>
			</c:forEach>
		</article>
	</div>
	<div class="bg-dark text-white text-center mt-2">Nguyễn Hữu Cảnh</div>

	<script src="/SOF3021_Assignment_Canhnhph17851/js/jquery.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/popper.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/bootstrap.min.js"></script>
</body>
</html>