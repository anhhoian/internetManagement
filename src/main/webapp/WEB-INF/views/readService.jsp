<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- <link rel="stylesheet" href="resources/css/style1.css"> -->
<link rel="stylesheet" href="./resources/css/style1.css">
<link rel="stylesheet" href="../resources/css/style1.css">
</head>
<body>
	<div>
		<p class="title-content mt-3 mb-2">Danh sách dịch vụ</p>
		<div class="border">
			<p class="form-header pl-3 pr-3 mb-3">Danh sách dịch vụ của cửa hàng</p>
			<div class="m-3 search-area">
				<form action="${pageContext.request.contextPath}/readService/${currentPage}"
					method="get">
					<label for="search" class="form-label">Search:</label> <input
						type="text" class="form-control" id="search" name="searchMaDV"
						placeholder="Search..." value="${searchMaDV}">
					<button type="submit" class="btn btn-secondary">Seach</button>
				</form>
			</div>
			<div class="text-danger ml-3">${message }</div>
			<div class="pl-3 pr-3">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col" style="width: 20%">Mã dịch vụ</th>
							<th scope="col" style="width: 30%">Tên dịch vụ</th>
							<th scope="col" style="width: 30%">Đơn giá</th>
							<th scope="col" style="width: 20%">Đơn vị tính</th>
						</tr>
					</thead>
					<tbody id="content-data">
						<c:forEach items="${listDV}" var="listDV">
							<tr>
								<td>${listDV.maDichVu}</td>
								<td>${listDV.tenDichVu}</td>
								<td>${listDV.dongia}</td>
								<td>${listDV.donViTinh}</td>
								<td><a
									href="${pageContext.request.contextPath}/showupdateService/${listDV.maDichVu}"><i
										class="fas fa-edit"></i>
									</a> 
									<a
									onclick="deleteItem(event)"
									href="${pageContext.request.contextPath}/deleteService/${listDV.maDichVu}"><i
										class="fas fa-trash-alt"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">
					<li class="page-item mt-2 mr-5">
						Total Items: ${totalItems} - Page ${currentPage} of ${totalPages}
					</li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/readService/${previousPage}?searchMaDV=${searchMaDV}">Previous</a></li>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<li
							class="page-item <c:if test="${i == currentPage }">active</c:if>">
							<a class="page-link"
							href="${pageContext.request.contextPath}/readService/${i}?searchMaDV=${searchMaDV}">
								${i} </a>
						</li>
					</c:forEach>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/readService/${nextPage}?searchMaDV=${searchMaDV}">Next</a></li>
					<li class="page-item ml-4"><a class="page-link"
						href="/springmvc_hibernate/">Exit</a></li>
				</ul>
			</div>
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