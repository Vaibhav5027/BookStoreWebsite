<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore Administration</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="../css/styles.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${category !=null}">
		<div class="pageheading" align="center" >
			<h3>Edit The Details:</h3>
		</div>
	</c:if>
	<c:if test="${category ==null}">
		<div class="pageheading" align="center" >
			<h4>Fill Category Details:</h4>
		</div>
	</c:if>
	<div align="center">
	<c:if test="${category==null }">
		<form action="create_category" method="post" id="categoryform">
	</c:if>	
	<c:if test="${category !=null }">
			<form action="update_category" method="post" id="categoryform">
			<input type="hidden" name="categoryId" value="${category.categoryId}"/>
	
	</c:if>
		<table>
				
				<tr>
					<td align="right">Name:</td>
					<td align="left"><input type="text" id="name" size="20"
						value="${category.name}" name="name"></td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="submit" value="save"> Save</button>
					<button onclick="javascript:history.go(-1)"> Cancel</button>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#categoryform").validate({
		rules:{
			name:"required"  
		},
		messages: {
		name:"category name is required"
		},
		});
		});

	
		function validateFormInput() {
		
			var fieldname = document.getElementById("name");
		
			if (fieldname.value.length == 0) {
				alert("category name is required");
				fieldname.focus();
				return false;
			}
		
		}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>