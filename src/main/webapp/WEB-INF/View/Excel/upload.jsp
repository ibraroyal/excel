<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%--  L' errore "Cannot resolve dyrectory" � un falso positivo   --%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Excel</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<%--  L' errore "Cannot resolve symbol" � un falso positivo   --%>
	<tags:navbarprova />
	<div align="center" class="mt-5 bg">
		<div class="ml-3">
			<h2 class="text-center text-info">Upload Excel</h2>
			<h6 class="text-center text-info">( Max file size 10 MB )</h6>
			<br> <br>




			<form method="POST" enctype="multipart/form-data"
				action="/upload/excel">


				<div class="margin-top">

					<input class="btn btn-info" type="file" name="file" /><br> <br>

					<input class="btn btn-success" type="submit" value="Upload Excel" />

				</div>

			</form>
			<br> <br>


			<c:forEach items="${list}" var="var">

				<div class="w-50 p-3" style="background-color: #eee;">


					<c:out value="${var}"></c:out>
					<br> <br>


				</div>

			</c:forEach>




			<script>
				
			</script>

			<br>


		</div> 
		<div class="ml-5" align="left">
			<h5>Download Template</h5>
			<FORM method="GET" 
				action="/download/template">
				<br> <INPUT type="submit" class="btn btn-primary"
					value="Template">
			</FORM>

		</div>

		<br> <br>
		<div class="ml-5" align="left">

			<h6>Example</h6>
			<div class="mt-3 " align="left">
				<div class="w-25">
					<div class="h-25">
						<table class="table">
							<thead>
								<tr class="bg-light">

									<th scope="col">Nome Prodotto</th>
									<th scope="col">Categoria</th>
									<th scope="col">Prezzo</th>
								</tr>
							</thead>
							<tbody>
								<tr>

									<td>Pc Acer k22zy'</td>
									<td>Informatica</td>
									<td>649,99</td>
								</tr>
								<tr class="bg-light">

									<td>Gilet LHNK</td>
									<td>Abbigliamento</td>
									<td>43,99</td>
								</tr>
								<tr>

									<td>Salmone Premium</td>
									<td>Alimenti</td>
									<td>8,00</td>
								</tr>
								<tr>

									<td colspan="2"></td>
									<td></td>
								</tr>

							</tbody>
						</table>



					</div>
				</div>
			</div>
		</div>
	</div>
	<div align="right" class="mr-5">
		<a class="btn btn-dark" href="http://localhost:8080/index/home"
			role="button">Home</a>

	</div>

</body>
</html>
