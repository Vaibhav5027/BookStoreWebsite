<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<a href="${pageContext.request.contextPath}">
		<img src="<%=request.getContextPath()%>/images/BookstoreAdminLogo.png" />
	</a>
	<div>
	<form action="search_book" method="get">
		<input type="text" name="keyword" size=50> <input
			type="submit" value="search">
</form>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h4> <a href="login"> Sign In |</a> <a
			href="register">Register |</a> <a href="view_cart">Cart |</a></h4>
	</div>
	<div>
		<c:forEach var="cat" items="${categorylist}">
		<a href="view_category?id=${cat.categoryId}">
			<font size="+2"><c:out value=" ${cat.name}"></c:out></font>
			</a>
			&nbsp;
		</c:forEach>

	</div>
</div>