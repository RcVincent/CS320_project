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
	color: darkblue;
	font-size: 200%;
	text-align: center;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
}
#logon {
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
	<div id="PageName">Welcome to Track N Snack</div>	
	<form action="${pageContext.servletContext.contextPath}/Login" method="post">
		<div id = "logon">
		<table>
			<tr>
				<c:if test="${! empty errorMessage}">
					<div class="error">${errorMessage}</div>
				</c:if>
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
			<button><a href="/lab03/CreateAccount"><type= "button">Click to create account</a></button>
		</div>
		</div>
	</form>
</body>
</html>
