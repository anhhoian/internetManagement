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
		<p class="title-content mt-3 mb-2">Danh sách máy</p>
		<div class="border">
			<p class="form-header pl-3 pr-3 mb-3">Danh sách máy của cửa hàng</p>
			<div class="m-3 search-area">
				<form action="${pageContext.request.contextPath}/readMachine/${currentPage}"
					method="get">
					<label for="search" class="form-label">Search:</label> <input
						type="text" class="form-control" id="search" name="searchMaMay"
						placeholder="Search..." value="${searchMaMay }">
					<button type="submit" class="btn btn-secondary">Seach</button>
				</form>
			</div>
			<div class="text-danger ml-3">${message }</div>
			<div class="pl-3 pr-3">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col" style="width: 20%">Mã máy</th>
							<th scope="col" style="width: 30%">Vị tí</th>
							<th scope="col" style="width: 30%">Trạng thái</th>
							<th scope="col" style="width: 20%">Actions</th>
						</tr>
					</thead>
					<tbody id="content-data">
						<c:forEach items="${listMay}" var="listMay">
							<tr>
								<td>${listMay.maMay}</td>
								<td>${listMay.viTri}</td>
								<td>${listMay.trangThai}</td>
								<td><a
									href="${pageContext.request.contextPath}/showupdateMachine/${listMay.maMay}"><i
										class="fas fa-edit"></i>
									</a> 
									<a
									onclick="deleteItem(event)"
									href="${pageContext.request.contextPath}/deleteMachine/${listMay.maMay}"><i
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
						href="${pageContext.request.contextPath}/readMachine/${previousPage}?searchMaMay=${searchMaMay}">Previous</a></li>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<li
							class="page-item <c:if test="${i == currentPage }">active</c:if>">
							<a class="page-link"
							href="${pageContext.request.contextPath}/readMachine/${i}?searchMaMay=${searchMaMay}">
								${i } </a>
						</li>
					</c:forEach>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/readMachine/${nextPage}?searchMaMay=${searchMaMay}">Next</a></li>
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
	<script type="text/javascript" src="./resources/js/validation.js"></script>
</body>
</html>