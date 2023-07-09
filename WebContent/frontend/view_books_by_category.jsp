<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/styles.css">
<title>List of Books</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="left" style="width:80% ;margin: 0 auto">
		<h1>${name}</h1>
		<div style="col">
			<c:forEach var="book" items="${booklist}">
			<div style="float:left;  display: inline-block; margin: 5px ;align-content: center ">
				<div >
				<a href="view_book?id=${book.bookId}">
					<img src="data:image/jpg;base64,${book.base64Image}" width="84"
						height="110"/></a>
				</div>
				<div><a href="view_book?id=${book.bookId}"><b>${book.title}</b></a></div>
				<div>Rating ***</div>
				<div><i>by ${book.author}</i></div>
				<div><b>$ ${book.price}</b></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>