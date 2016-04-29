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
button{
	margin-top: 2px;
}
#PageName {
	color: white;
	font-size: 250%;
	text-align: center;
	background-color: darkblue;
	font-variant: small-caps;
}
#logon {
    margin: 50px auto;
	border: 1px solid darkblue;
	width: 400px;
	padding: 10px;
}
#Content {
	float: left;
}
</style>
</head>

<body>
	<div id="PageName">Track N Snack</div>	
	
		<form action="${pageContext.servletContext.contextPath}/ChangeUsername" method="post">
		<div id = "logon">

		<table>
			<tr>
				<c:if test="${! empty errorMessage}">
					<div class="error">${errorMessage}</div>
				</c:if>
				<td class="label">Username:</td>
				<td><input type="text" name="username" size="12" /></td>
			</tr>
			<tr>
				<td class="label">New Username:</td>
				<td><input type="text" name="newUsername" size="12" /></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><input type="password" name="password" size="12" /></td>
			</tr>
			<tr>
				
				<td><input type="Submit" name="submit" value="Change Username" /></td>
					<td><button><a href="/lab03/Homepage"><type= "button">Click to create account</a></button></td>
			</tr>
		</table>
		</div>
		</form>
</body>
</html>