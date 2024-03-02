<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<div>
	<p class="title-content mt-3 mb-2">Đăng kí sử dụng dịch vụ</p>
	<form:form action="${pageContext.request.contextPath}/dkSuDungDV"
		method="post" class="border" id="dkSuDungDV" modelAttribute="suDungDV">
		<p class="form-header pl-3 pr-3 mb-3">Đăng kí sử dụng dịch vụ cho
			khách hàng</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="maKH">Mã khách hàng</label> 
						<select
							class="form-control" name="maKH">
							<option value=""> --SELECT CUSTOM--</option>
							<c:forEach items="${listKhachHang}" var="listKhachHang">
								<option value="${listKhachHang.maKH}">${listKhachHang.maKH}</option>
							</c:forEach>
							<form:errors path="maKH"  class="text-danger"/>
						</select>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="maDichVu">Mã dịch vụ</label> 
						<select class="form-control"
							name="maDichVu">
							<option value=""> --SELECT SERVICE--</option>
							<c:forEach items="${listDV}" var="listDV">
								<option value="${listDV.maDichVu}">${listDV.tenDichVu}</option>
							</c:forEach>
							<form:errors path="maDichVu"  class="text-danger"/>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="ngaySuDung">Ngày sử dụng</label> 
						<form:input type="date"
							name="ngaySuDung" path="ngaySuDung" class="form-control" id="ngaySuDung"
							value="${suDungDichVu.id.ngaySuDung }"/>					
						<form:errors path="ngaySuDung"  class="text-danger"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="gioSuDung">Giờ sử dụng</label> 
						<form:input type="time"
							name="gioSuDung" path="gioSuDung" class="form-control" id="gioSuDung"/>
						<form:errors path="gioSuDung"  class="text-danger"/>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="soLuong">Số lượng</label> 
						<form:input type="number"
							name="soLuong" path="soLuong" class="form-control" id="soLuong" min="0"/>
						<form:errors path="soLuong"  class="text-danger"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-secondary">Submit</button>
				<button type="reset" class="btn btn-outline-secondary">Reset</button>
				<button type="button" class="btn btn-outline-secondary" id="back"><a href="/springmvc_hibernate">Thoát</a></button>
			</div>
		</div>
	</form:form>
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
	
<!-- <script type="text/javascript">
$( "#back" ).click(function() {
	window.history.back();
});
</script> -->
</body>
</html>