<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Order Confirmation</title>
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
td.label{
	text-align: right;
}
		</style>
	</head>

	<body>
			<div id = "PageName">Order Confirmation</div>
			<div id = "AccountInfo">
			<table>
				<tr>
					<td> Order Number:</td>
					<td> ${num} </td>
				</tr>
				<tr>
					<td class = "label"> Status: </td>
					<td class = "label"> ${status}</td>
				</tr>
			</table>
			<table>
				<c:forEach items="${order}" var="order">
				<tr>
					<td> ${order.quantity} </td>
					<td> ${order.item} </td>
					<td> @ </td>
					<td> $ ${order.price} </td>
				</tr>
			</c:forEach>
			</table>
			<table>
				<tr>
					<td class = "label"> Total price: </td>
					<td class = "label"> $ ${total} </td>
				</tr>
				<tr><form action="${pageContext.servletContext.contextPath}/Homepage" method="get">
					<td><input type="Submit" name="submit" value="Click to go to Homepage"/></td>
					</form>
				</tr>
			</table>
			</div>
		
	</body>
</html>