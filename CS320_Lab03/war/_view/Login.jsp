<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Track N Snack</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/Login" method="post">
			<table>
				<tr>
					<td class="label">Username: </td>
					<td><input type="text" name="first" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password: </td>
					<td><input type="text" name="second" size="12" value="${password}" /></td>
				</tr>
				<a href="/lab03/Homepage"><button type="button">Login to Homepage</a>
				<br />
				<a href="/lab03/CreateAccount"><button type="button">Click to create account</a>
			</table>
		</form>
	</body>
</html>