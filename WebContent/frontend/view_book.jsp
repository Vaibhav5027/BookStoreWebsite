<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.title}</title>
</head>
<body>
	<h1 align="center">Welcome to My book store</h1>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<table width="90%">
			<tr>
				<td colspan="1" align="left">
					<h2>${book.title}</h2> by ${book.author}
				</td>
			</tr>
			<tr>
				<td rowspan="2"><img
					src="data:image/jpg;base64,${book.base64Image}" width="240"
					height="300" /></td>
				<td valign="top" align="left">Rating *****</td>
				<td valign="top" rowspan="2"><b>$${book.price}</b></br>
					<button type="submit">Add To Cart</button>
				</td>
			</tr>
			<tr>
				<td valign="top" style="text-align: justify">${book.description}</td>
			</tr>
             <tr>
             <td><h2>Customer Review</h2></td>
             <td colspan="2" align="center">
             <button>Write a Customer Review</button>
             </td>
             
             </tr>



		</table>

	</div>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>