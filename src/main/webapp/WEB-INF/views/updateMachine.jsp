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
	<link rel="stylesheet" href="../resources/css/style1.css" />
</head>
<body>
<div>
	<p class="title-content mt-3 mb-2">Sửa máy</p>
	<form:form action="${pageContext.request.contextPath}/updateMachine" method="post" id="createMachine" class="border" modelAttribute="may">
	<div class="text-danger ml-3">${message}</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="form-group">
				<label for="maMay">Mã Máy</label>: <span>${may.maMay}</span>
				<form:input path="maMay" class="form-control d-none" id="maMay"/>
			</div>
			<div class="form-group">
				<label for="viTri">Vị trí</label> 
				<form:input path="viTri" class="form-control" id="viTri"/>
				<form:errors path="viTri"  class="text-danger"/>
			</div>
			<div class="form-group">
				<label for="trangThai">Trạng thái</label> 
				<form:input path="trangThai" class="form-control" id="trangThai"/>
				<form:errors path="trangThai"  class="text-danger"/>
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