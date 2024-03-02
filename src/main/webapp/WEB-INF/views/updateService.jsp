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
<link rel="stylesheet" href="../resources/css/style1.css">
</head>
<body>
<div>
	<p class="title-content mt-3 mb-2">Sửa dịch vụ</p>
	<form:form action="${pageContext.request.contextPath}/updateService" method="post" id="createMachine" class="border" modelAttribute="dichVu">
	<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="form-group">
				<label for="maDichVu">Mã dịch vụ</label>: <span>${dichVu.maDichVu}</span>
				<form:input path="maDichVu" class="form-control d-none" id="maDichVu"/>
			</div>
			<div class="form-group">
				<label for="tenDichVu">Tên dịch vụ </label> 
				<form:input path="tenDichVu" class="form-control" id="tenDichVu"/>
				<form:errors path="tenDichVu"  class="text-danger"/>
			</div>
			<div class="form-group">
				<label for="donViTinh">Đơn vị tính </label> 
				<form:input path="donViTinh" class="form-control" id="donViTinh"/>
				<form:errors path="donViTinh"  class="text-danger"/>
			</div>
			<div class="form-group">
				<label for="dongia">Đơn giá</label> 
				<form:input path="dongia" class="form-control" id="dongia" />
				<form:errors path="dongia"  class="text-danger"/>
			</div>
			<div class="form-group">
				<form:button type="submit" class="btn btn-outline-secondary">Submit</form:button>
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
	<script type="text/javascript" src="../resources/js/validation.js"></script>
	
<!-- <script type="text/javascript">
$( "#back" ).click(function() {
	window.history.back();
});
</script> -->
</body>
</html>