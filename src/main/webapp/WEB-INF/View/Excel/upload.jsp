<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--  L' errore "Cannot resolve dyrectory" è un falso positivo   --%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%--  L' errore "Cannot resolve symbol" è un falso positivo   --%>
<tags:navbarprova/>
<br>
<input id="fileupload" type="file" name="fileupload">
	<button id="uploadButton" onclick="uploadFile()"> UPLOAD </button>
	<button id="uploadButton" onclick="uploadFileExcel()"> UPLOAD Excel</button>
	
	<script>
		async function uploadFile() {
		  let formData = new FormData(); 
		  formData.append("file", fileupload.files[0]);
			  let response = await fetch('/upload', {
			    method: "POST", 
			    body: formData
				}); 

		  	if (response.status == 200) {
		    alert("File successfully uploaded.");
		 	 }
		}
	</script>
	<script>
		async function uploadFileExcel() {
		  let formData = new FormData(); 
		  formData.append("file", fileupload.files[0]);
			  let response = await fetch('/upload/excel', {
			    method: "POST", 
			    body: formData
				}); 

		  	if (response.status == 200) {
		    alert("File successfully uploaded.");
		 	 }
		}
	</script>


</body>
</html>