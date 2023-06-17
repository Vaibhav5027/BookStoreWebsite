<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/styles.css">
</head>
<body >
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<div class="pageheading">
			<h1>Administration Dashboard</h1>
		</div>
		<div class="pageheading">
			<h2>Quick Actions::</h2>
			<a href="create_book"> New Book</a> &nbsp; <a href="create_user">
				New User</a> &nbsp; <a href="create_category"> New Category</a> &nbsp; <a
				href="create_customer"> New Customer</a> &nbsp;
		</div>
		<div class="pageheading">
			<hr width="60%" />
			<h2>Recent Sales ::</h2>
		</div>
		<div class="pageheading">
			<hr width="60%" />
			<h2>Recent Reviews ::</h2>
		</div>
		<div class="pageheading">
			<hr width="60%" />
			<h2>Statistics ::</h2>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>