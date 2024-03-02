<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <title><tiles:getAsString name="title" /></title> -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/css/style1.css">
</head>
<body>
	<div
		class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
		<header class="display-4">
			<p class="title text-secondary">Cyber GAMS</p>
		</header>
		<p class="lead">448 Nguyễn Tri Phương, Hội An</p>
	</div>
	<div class="row main">
		<div class="col-2 navbar navbar-dark border-right bg-light">
			<div class="input-group" style="margin: 20px 20px">
				<input type="text" class="form-control" placeholder="Tìm kiếm">
				<div class="input-group-append">
					<button class="btn btn-secondary" type="button">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<ul class="list-group">
				<a href="ShowInsertMachine" id=""><i class="fa fa-plus-square"></i>Thêm máy</a>
				<a href="ShowListMachine" id=""> <i class="fas fa-desktop"></i> Danh sách máy
				</a>
				<a href="ShowInsertCustom" id=""> <i class="fa fa-user-plus"></i> Thêm khách
					hàng
				</a>
				<a href="ShowListCustom" id=""> <i class="fas fa-users"></i> Danh sách khách
				</a>
				<a href="ShowInsertService" id=""> <i class="fa fa-cart-plus"></i> Thêm dịch vụ
				</a>
				<a href="ShowListService" id=""> <i class="fas fa-utensils"></i> Danh sách dịch
					vụ
				</a>
				<a href="ShowInsertUseMachine" id=""> <i class="fas fa-plus"></i> Đăng kí máy
				</a>

				<a href="ShowInsertUseService" id=""> <i class="fas fa-plus"></i> Đăng kí dịch vụ
				</a>
				<a href="ShowHistoryUse" id=""> <i class="fas fa-history"></i> Lịch sử sử dụng
				</a>
			</ul>
		</div>
		<div class="col" id="content">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="resources/js/validation.js"></script>
</body>
</html>