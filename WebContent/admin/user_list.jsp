<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList</title>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>s
</head>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<div>
			<h3>User Management</h3>
		</div>
		<h3>
			<a href="user_form.jsp">create new user</a>
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
				<th>EMAIL</th>
				<th>FULLNAME</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${userlist}" varStatus="status">
				<tr>
					<td>${status.index+ 1 }</td>
					<td>${user.userId }</td>
					<td>${user.email }</td>
					<td>${user.fullName }</td>
					<td><a href="edit_user?id=${user.userId}">Edit
							&nbsp;&nbsp;</a> 
							<a href="javascript:void(0);" class="deletelink" id="${user.userId}">Delete</a></td>

				</tr>

			</c:forEach>

		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<script>
		$(document).ready(function() {
			$(".deletelink").each(function() {
				$(this).on("click", function() {
					categoryId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the user with ID ' +  categoryId + '?')) {
						window.location = 'delete_user?id=' + categoryId;
					}					
				});
			});
		});	
	</script>
</body>

</html>