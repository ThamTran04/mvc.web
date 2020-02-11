<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>uploadFile</title>
</head>
<body>
	<h1>Upload file in servlet</h1>
	<form action="/mvc.web/upload" method="post"
		enctype="multipart/form-data">
		File name: <input type="file" name="file" size="50" /> <br /> <br />
		<input type="submit" value="Upload File" />
	</form>
</body>

</html>