<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="images/BookstoreAdminLogo.png" />
	</div>
	<div>
		<input type="text" name="keyword" size=50> <input
			type="button" value="search">

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="login"> Sign In |</a> <a
			href="register">Register |</a> <a href="view_cart">Cart |</a>
	</div>
	<div>&nbsp;</div>
	<div>
		<c:forEach var="cat" items="${categorylist}">
		<a href="view_category?categoryid=${cat.categoryId}">
			<font size="+1"><c:out value=" ${cat.name}" ></c:out></font>
			</a>
			&nbsp;
		</c:forEach>

	</div>
</div>