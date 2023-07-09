<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/styles.css">
<title>Result for ${keyword}</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<c:if test="${fn:length(books)==0}">
			<h1>No result for ${keyword}</h1>
		</c:if>
	</div>
	<c:if test="${fn:length(books)>0}">
		<div align="left" style="width: 70%; margin:  auto">
			<center><h1>result for ${keyword}</h1></center>
			<c:forEach var="book" items="${books}">
				<div style="display: inline-block; margin: 20px; width: 10%">
					<div>
						<div>
							<a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="100"
								height="124" /></a>
						</div>
					</div>
				</div>
				<div style="display: inline-block; margin: 20px; vertical-align: top; width: 60%">
					<div>
						<a href="view_book?id=${book.bookId}"><b>${book.title}</b></a>
					</div>
					<div>Rating ***</div>
					<div>
						<i>by ${book.author}</i>
					</div>
					<div><p>${fn:substring(book.description,0,100)}...</p></div>
				</div>
				<div style="display: inline-block; margin: 20px; vertical-align: top;">
					<b>$${book.price}</b></br>
					<button type="submit">Add To Cart</button>
				</div>
			</c:forEach>
		</div>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>