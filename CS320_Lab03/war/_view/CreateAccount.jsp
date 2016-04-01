<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
#PageName {
	color: darkblue;
	font-size: 200%;
	text-align: center;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
}
#createAccount {
	width: 50%;
	margin-left: 13px;
	margin-top: 13px;
	float: left;
	border: 1px solid darkblue;
	width: 400px;
	padding: 10px;
}
</style>
</head>

<body>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>
	<div id="PageName">Create Your Account</div>
	<form action="${pageContext.servletContext.contextPath}/CreateAccount"
		method="post">
		<div id="createAccount">
			<table>
				<tr>
					<td class="label">First name:</td>
					<td><input type="text" name="firstName" size="12"
						value="${firstName}" required /></td>
				</tr>
				<tr>
					<td class="label">Last name:</td>
					<td><input type="text" name="lastName" size="12"
						value="${lastName}" required /></td>
				</tr>
				<tr>
					<td class="label">New Username:</td>
					<td><input type="text" name="userName" size="12"
						value="${userName}" required /></td>
				</tr>
				<tr>
					<td class="label">New password:</td>
					<td><input type="password" name="password" size="12"
						value="${password}" required /></td>
				</tr>
				<tr>
					<td class="label">email address:</td>
					<td><input type="email" name="email" size="12"
						value="${email}" required /></td>
				</tr>
				<tr>
					<td class="label">Account Type:</td>
					<td><input type="radio" name="AccountType" value="patron"
						checked> Patron</td>
					<td><input type="radio" name="AccountType" value="owner">
						Owner</td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Create Account" />
		</div>
	</form>
</body>
</html>