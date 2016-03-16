<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Add Numbers</title>
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
	
		<form action="${pageContext.servletContext.contextPath}/CreateAccount" method="post">
			<table>
				<tr>
					<td class="label">First name:</td>
					<td><input type="text" name="second" size="12" value="${firstName}" /></td>
				</tr>
				<tr>
					<td class="label">Last name:</td>
					<td><input type="text" name="second" size="12" value="${lastName}" /></td>
				</tr>
				<tr>
					<td class="label">New Username:</td>
					<td><input type="text" name="first" size="12" value="${userName}" /></td>
				</tr>
				<tr>
					<td class="label">New password:</td>
					<td><input type="text" name="second" size="12" value="${password}" /></td>
				</tr>
				<tr>
					<td class="label">email address:</td>
					<td><input type="text" name="second" size="12" value="${email}" /></td>
				</tr>
				
			</table>
			
		</form>
	</body>
</html>