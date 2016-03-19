<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

	<form action="${pageContext.servletContext.contextPath}/Login"
		method="post">
		<table>
			<tr>
				<td class="label">Username:</td>
				<td><input type="text" name="username" size="12" required /></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><input type="password" name="password" size="12" required /></td>
			</tr>

		</table>
		<div>
			<input type="Submit" name="submit" value="Login" />
		</div>
		<div>
			<a href="/lab03/CreateAccount"><type= "button">Click to
				create account</a>
		</div>

	</form>
</body>
</html>
