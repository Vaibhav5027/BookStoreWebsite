<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<form>
		<div align="center">
			Email::<input type="text" size="10" />
		</div>

		<div align="center" >
			Password::<input type="text" size="10" /><input type="submit" value="submit" />
		</div>

	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>