<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Bakers Menu</title>
		<style type="text/css">
#PageName {
	color: white;
	font-size: 250%;
	text-align: center;
	background-color: darkblue;
	font-variant: small-caps;
}
#AccountInfo{
		font-size: 125%;
		text-align: left;
		align: center;
}
table{
	border-spacing: 10px;
}
		</style>
	</head>

	<body>
	<form action="${pageContext.servletContext.contextPath}/Menu" method="post">
			<div id = "PageName">Baker's Donuts Menu</div>
			<div id = "AccountInfo">
			<table>
				<c:forEach items="${items}" var="items">
				<tr>
					<td><input type="checkbox" name="Order" value= "${items.item}" > ${items.item} </td>
					<td> $ ${items.price}0 </td>
				</tr>
			</c:forEach>
				
				<tr>
				<c:if test="${empty utype}">
					<td><input type="Submit" name="submit" value="Submit your order"/></td>
				</c:if>
		</form>
		<c:if test="${! empty utype}">
			<form action="${pageContext.servletContext.contextPath}/AddItem" method="get">
					<td><input type="Submit" name="submit" value="Add Menu Item"/></td>
					</form>
			</c:if>
				<form action="${pageContext.servletContext.contextPath}/Homepage" method="get">
					<td><input type="Submit" name="submit" value="Click to go to Homepage"/></td>
				</form>
				</tr>
			</table>
		</div>
		
	</body>
</html>