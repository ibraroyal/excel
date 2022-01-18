<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%--  L' errore "Cannot resolve dyrectory" è un falso positivo   --%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>download excel</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

<%--  L' errore "Cannot resolve symbol" è un falso positivo   --%>
<tags:navbarprova/>
&nbsp;

<FORM method="get" style="text-align: center" action="/download/dates">
	<table>
		<tr>
			<td> <INPUT type="date" name="start">  </td>
			<td> <INPUT type="date" name="end">  </td>
		</tr>
		<tr>
			<br>
			<td>  <INPUT type="submit" class="btn btn-primary" name="formOk" value="Download"> </td>
		</tr>
	</table>
</FORM>
<FORM method="POST" style="text-align: center" action="/download/testing">
			<br>
			<INPUT type="submit" class="btn btn-primary" value="Test">
</FORM>
<FORM method="GET" style="text-align: center" action="/download/template">
	<br>
	<INPUT type="submit" class="btn btn-primary" value="Template">
</FORM>
</body>
</html>
