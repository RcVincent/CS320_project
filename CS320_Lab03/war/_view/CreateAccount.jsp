<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Create Account</title>
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
	
		<form action="${pageContext.servletContext.contextPath}/Homepage" method="post">
			<table>
				<tr>
					<td class="label">First name:</td>
					<td><input type="text" name="firstName" size="12" value="${firstName}" required/></td>
				</tr>
				<tr>
					<td class="label">Last name:</td>
					<td><input type="text" name="lastName" size="12" value="${lastName}" required/></td>
				</tr>
				<tr>
					<td class="label">New Username:</td>
					<td><input type="text" name="userName" size="12" value="${userName}" required/></td>
				</tr>
				<tr>
					<td class="label">New password:</td>
					<td><input type="text" name="password" size="12" value="${password}" required/></td>
				</tr>
				<tr>
					<td class="label">email address:</td>
					<td><input type="text" name="email" size="12" value="${email}" required/></td>
				</tr>
		
			</table>

   			<input type="Submit" name="submit" value="Create Account"/>

		</form>
	</body>
</html>