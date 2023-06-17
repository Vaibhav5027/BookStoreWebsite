<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page not found</title>
</head>
<body>
	<div align="center">
		<div>
			<img src="${pageContext.request.contextPath}/images/BookstoreLogo.png" />
		</div>
		<div>
			<h2>sorry ,requested page not found</h2>
		</div>
		<div>
			<button onclick="javascript:history.go(-1)">Go Back</button>
		</div>
	</div>

</body>
</html>