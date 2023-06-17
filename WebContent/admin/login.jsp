<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
	</div>
	<div align="center">
		<h2>Admin Login</h2>
	</div>
	<c:if test="${message !=null}">
		<div align="center">
			<h4 class="message">
				${message}
			</h4>
		</div>
	</c:if>
	<div align="center">
		<form action="login" method="post" id="loginform">

			<table>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit">login</button></td>

				</tr>
			</table>

		</form>
	</div>
	<script type="text/javascript">
	 $(document).ready(function(){
	$("#loginform").validate({
	rules:{
		email:{
 			required: true,
  			email:true
			},
			password:"required",
	},
	
	messages: {
		email :{
			required:"Please Enter Email",
            email:"please enter valid email"
				},
		password:"password is required"
	}
	
	
	});
	
	
	});
	
	</script>
</body>
</html>