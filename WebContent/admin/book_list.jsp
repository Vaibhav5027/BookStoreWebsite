<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookList</title>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<div>
			<h3>Book Management</h3>
		</div>
		<h3>
			<a href="new_book">create new book</a>
		</h3>
	</div>
	<c:if test="${message !=null}">
		<div align="center">
			<h4 class="message">
				${message}
			</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th>INDEX</th>
				<th>ID</th>
				<th>IMAGE</th>
				<th>TITLE</th>
				<th>AUTHOR</th>
				<th>CATEGORY</th>
				<th>PRICE</th>
				<th>LASTUPDATED</th>
				<th>ACTION</th>
			</tr>
			<c:forEach var="book" items="${booklist}" varStatus="status">
				<tr>
					<td>${status.index+ 1 }</td>
					<td>${book.bookId }</td>
					<!-- ${book.image } -->
					<td>
					<img  src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"></td>
				    <td>${book.title }</td>
				    <td>${book.author}</td>
				    <td>${book.category.name}</td>
				    <td>$${book.price}</td> 
				    <td><fmt:formatDate pattern="MM/dd/yyyy" value='${book.updatedOn}'/></td> 
					<td><a href="edit_book?id=${book.bookId}">Edit
							&nbsp;&nbsp;</a> 
							<a href="javascript:void(0);" class="deletelink" id="${book.bookId}">Delete</a></td>

				</tr>

			</c:forEach>

		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<script>
		$(document).ready(function() {
			$(".deletelink").each(function() {
				$(this).on("click", function() {
					bookId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the book with ID ' +  bookId + '?')) {
						window.location = 'delete_book?id=' + bookId;
					}					
				});
			});
		});	
	</script>
</body>

</html>