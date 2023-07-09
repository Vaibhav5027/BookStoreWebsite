<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="..//css/richtext.min.css">

<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${book !=null}">
		<div class="pageheading" align="center">
			<h3>Edit The Details:</h3>
		</div>
	</c:if>
	<c:if test="${book ==null}">
		<div class="pageheading" align="center">
			<h3>Fill Book Details:</h3>
		</div>
	</c:if>
	<div align="center">
		<c:if test="${book==null }">
			<form action="create_book" method="post" id="bookform" enctype="multipart/form-data">
		</c:if>
		<c:if test="${book !=null }">
	
			<form action="update_book" method="post" id="bookform" enctype="multipart/form-data">
				<input type="hidden" name="bookId" value="${book.bookId}" />
		</c:if>
		
		<table>
		
		
			<tr>
				<td>Category:</td>
				<td><select name="category">
						<c:forEach items="${categoryList}" var="category">
						<c:if test="${category.categoryId eq book.category.categoryId }">
						<option value="${category.categoryId}" selected>
						</c:if>
						<c:if test="${category.categoryId ne book.category.categoryId }">
						<option value="${category.categoryId}">
						</c:if>
							${category.name}</option>
						</c:forEach>
				</select></td>
	
			</tr>
		
			<tr>
				<td align="center">Title:</td>
				<td align="left"><input type="text" id="title" name="title"
					value="${book.title}" size="20"></td>
			</tr>
			<tr>
				<td align="center">Author:</td>
				<td align="left"><input type="text" id="author" name="author"
					value="${book.author}" size="20"></td>
			</tr>
			<tr>
				<td align="center">ISBN:</td>
				<td align="left"><input type="text" id="isbn" name="isbn"
					value="${book.isbn}" size="20"></td>
			</tr>
			<tr>
				<td align="center">Price:</td>
				<td align="left"><input type="text" id="price" name="price"
					value="${book.price}" size="20"></td>
			</tr>
			<tr>
				<td align="center">Published Date</td>
				<td align="left"><input type="text" id="publisheddate" size="20"
					name="publisheddate" value="<fmt:formatDate pattern="MM/dd/yyyy" value='${book.published}'/>" /></td>
			</tr>
	       		<tr>
				<td align="right">Book Image:</td>
				<td align="left">
					<input type="file" id="bookImage" name="bookImage" size="20" /><br/>
					<img id="thumbnail" alt="Image Preview"  style="width:20%; margin-top: 10px;"
					 src="data:image/jpg;base64,${book.base64Image}"/>
				</td>
			</tr>
			<tr>
				<td align="center">Description:</td>
				<td align="left" ><textarea rows="5" cols="50"
						name="description" id="description" >${book.description}</textarea></td>
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
	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		
     $("#publisheddate" ).datepicker();
     $('#description').richText();
     
     $('#bookImage').change(function() {
			showImageThumbnail(this);
		});
		
		$("#bookform").validate({
			rules:{
				category:"required",
			title: "required",
	        author: "required",
	        publisheddate: "required",
		bookImage: "required",
		price: "required",
		description:"required",
		isbn:"required",
			},
	
			messages: {
			category:"please select category",
				title:"title is required",
				author:"author is required",
				publisheddate:"publishdate is required",
				bookImage:"image is required",
				price:"price is required",
				description:"description is required",	
				isbn:"isbn required",	
			}
		});
	});

	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}


	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
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

</html>