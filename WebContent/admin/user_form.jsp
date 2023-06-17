<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${user !=null}">
		<div class="pageheading" align="center">
			<h3>Edit The Details:</h3>
		</div>
	</c:if>
	<c:if test="${user ==null}">
		<div class="pageheading" align="center">
			<h3>Fill User Details:</h3>
		</div>
	</c:if>
	<div align="center">
		<c:if test="${user==null }">
			<form action="create_user" method="post" id="userform">
		</c:if>
		<c:if test="${user !=null }">
			<form action="update_user" method="post" id="userform">
				<input type="hidden" name="userId" value="${user.userId}" />
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
				<td align="left"><input type="password" id="password" size="20"
					value="${user.password}" name="password"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" value="save">Save</button>
					<button onclick="javascript:history.go(-1)">Cancel</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#userform").validate({
			rules:{
				email:{
					required: true,
 					email:true
				},
				fullname:"required",
				<c:if test="${user == null}">
				password: "required"
				</c:if>
			},
	
			messages: {
				email :{
					required:"Please Enter Email",
					email:"Please enter a valid email"
				},
				fullname:"name is required",
				<c:if test="${user == null}">
				password: "Please enter password"
				</c:if>
			}
		});
	});
</script>





<%--

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
--%>
	

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>