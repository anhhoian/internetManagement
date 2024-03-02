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
	<p class="title-content mt-3 mb-2">Lịch sử</p>
	<div class="border">
		<p class="form-header pl-3 pr-3 mb-3">Lịch sử của cửa hàng</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="pl-3 pr-3">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">Mã KH</th>
						<th scope="col">Tên KH</th>
						<th scope="col">Mã Máy</th>
						<th scope="col">Vị Trí</th>
						<th scope="col">TT</th>
						<th scope="col">Ngày BDSD</th>
						<th scope="col">Giờ BDSD</th>
						<th scope="col">TG SD</th>
						<th scope="col">Mã DV</th>
						<th scope="col">Ngày SD</th>
						<th scope="col">Giờ SD</th>
						<th scope="col">Số lượng</th>
<!-- 						<th scope="col">Tổng tiền</th> -->
					</tr>
				</thead>
				<tbody id="content-data">
					<c:forEach items="${listAllInfo}" var="info">
						<tr>
							<td>${info.getmaKH()}</td>
							<td>${info.gettenKH()}</td>
							<td>${info.getmaMay()}</td>
							<td>${info.getviTri()}</td>
							<td>${info.gettrangThai()}</td>
							<td>${info.getngayBatDauSuDung()}</td>
							<td>${info.getgioBatDauSuDung()}</td>
							<td>${info.getthoiGianSuDung()}</td>
							<td>${info.getmaDichVu()}</td>
							<td>${info.getngaySuDung()}</td>
							<td>${info.getgioSuDung()}</td>
							<td>${info.getsoLuong()}</td>
<%-- 							<td>${info.gettongTien}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
                        <c:if test="${currentPage >1}">
                            <li class="page-item"><a class="page-link" href="/springmvc_hibernate/ShowHistoryUse?page=${currentPage-1}">Previous</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${totalPage}" var="i" >
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="page-item"><a class="page-link bg-success" href="/springmvc_hibernate/ShowHistoryUse?page=${i}">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link" href="/springmvc_hibernate/ShowHistoryUse?page=${i}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${currentPage < totalPage}">
                            <li class="page-item"><a class="page-link" href="/springmvc_hibernate/ShowHistoryUse?page=${currentPage+1}">Next</a></li>
                        </c:if>
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