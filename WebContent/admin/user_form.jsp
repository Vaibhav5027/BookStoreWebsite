<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore Administration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${user !=null}">
		<div align="center">
			<h3>Edit The Details:</h3>
		</div>
	</c:if>
	<c:if test="${user ==null}">
		<div align="center">
			<h4>fill user details:</h4>
		</div>
	</c:if>
	<div align="center">
	<c:if test="${user==null }">
		<form action="create_user" method="post" onsubmit="return validateFormInput()">
	</c:if>	
	<c:if test="${user !=null }">
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="userId" value="${user.userId}"/>
	
	</c:if>
		<table>
				<tr>
					<td align="center">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						value="${user.email}" size="20"></td>
				</tr>
				<tr>
					<td align="right">FullName:</td>
					<td align="left"><input type="text" id="fullname" size="20"
						value="${user.fullName}" name="fullname"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password"
						size="20" value="${user.password}" name="password"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="save" /> <input type="button" value="cancel"
						onclick="javascript:history.go(-1)"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function validateFormInput() {
			var fieldEmail = document.getElementById("email");
			var fieldFullname = document.getElementById("fullname");
			var fieldPassword = document.getElementById("password");
			if (fieldEmail.value.length == 0) {
				alert("email is required");
				fieldEmail.focus();
				return false;
			}
			if (fieldFullname.value.length == 0) {
				alert("fullname is required");
				fieldFullname.focus();
				return false;
			}
			if (fieldPassword.value.length == 0) {
				alert("password is required");
				fieldPassword.focus();
				return false;
			}
		}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>