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
				href="/SOF3021_Assignment_Canhnhph17851/index">Trang Chủ</a>
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
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Người tạo</th>
						<th>Ngày tạo</th>
						<th>Địa chỉ</th>
						<th colspan="3">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ data.content }" var="order">
						<tr>
							<td>${ order.id }</td>
							<td>${ order.user.fullname }</td>
							<td>${ order.createdDate }</td>
							<td>${ order.address}</td>
							<td><a class="btn btn-success"
								href="/SOF3021_Assignment_Canhnhph17851/admin/orderDetails/create/${ order.id }">
									Mua hang </a></td>
							<td><a class="btn btn-primary"
								href="/SOF3021_Assignment_Canhnhph17851/admin/orders/edit/${ order.id }">
									Update </a></td>
							<td>><a class="btn btn-danger" data-bs-toggle="modal"
								data-bs-target="#exampleModal${ order.id }"
								class="btn btn-primary">Detete</a>
							</td>
						</tr>
						<div class="modal fade" id="exampleModal${ order.id }"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có chắc chắn muốn xóa không ?
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Cancel</button>
										<a type="button" class="btn btn-primary"
											href="/SOF3021_Assignment_Canhnhph17851/admin/orders/delete/${ order.id }">Delete</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</tbody>
			</table>
		</article>
	</div>
	<div class="bg-dark text-white text-center mt-2">Nguyễn Hữu Cảnh</div>

	<script src="/SOF3021_Assignment_Canhnhph17851/js/jquery.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/popper.min.js"></script>
	<script src="/SOF3021_Assignment_Canhnhph17851/js/bootstrap.min.js"></script>
</body>
</html>