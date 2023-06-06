<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<div>
			<h3>Category Management</h3>
		</div>
		<h3>
			<a href="category_form.jsp">create new Category</a>
		</h3>
	</div>
	<c:if test="${message !=null}">
		<div align="center">
			<h4>
				<i>${message}</i>
			</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th>INDEX</th>
				<th>ID</th>
				<th>Name</th>
				<th>Action</th>
				
			</tr>
			<c:forEach var="category" items="${categoryList}" varStatus="status">
				<tr>
					<td>${status.index+ 1 }</td>
					<td>${category.categoryId }</td>
					<td>${category.name }</td>
			
					<td><a href="edit_category?id=${category.categoryId }">Edit
							&nbsp;&nbsp;</a>
					 <a href="javascript:confirmDelete(${category.categoryId })">Delete</a></td>

				</tr>

			</c:forEach>

		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmDelete(categoryId) {
			if (confirm('are you sure you want to delete user with id :'
					+ categoryId + '')) {
				window.location='delete_category?id='+categoryId;
			}

		}
	</script>
</body>

</html>