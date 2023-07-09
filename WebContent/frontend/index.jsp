<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EverGreenBookStore</title>
</head>
<body>
	<h1 align="center">Welcome to My book store</h1>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<div align="center" style="width:80% ;margin: 0 auto">
			<h1>New Books</h1>
		<div style="col">
			<c:forEach var="book" items="${bookList}">
			<div style="float:left;  display: inline-block; margin: 10px ;align-content: center ">
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
	</div>
		<div align="center" style=" clear: both">
		<h1>Most Selling Bos</h1>
		<h1>Most Favorite Books</h1>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>