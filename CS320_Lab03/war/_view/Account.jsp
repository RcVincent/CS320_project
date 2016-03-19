<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Your Account</title>
		<style type="text/css">
		#PageName {
			color: darkblue;
			font-size: 200%;
			text-align: center;
			border-top: 3px solid darkblue;
			border-bottom: 3px solid darkblue;
			font-variant: small-caps;
}
		</style>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/Account" method="post">
			<div id = "PageName">Your Account</div>
			<div>
			<table>
				<tr>
					<td class="label">First name:</td>
					
				</tr>
				<tr>
					<td class="label">Last name:</td>
				</tr>
				<tr>
					<td class="label">Username:</td>
				</tr>
				<tr>
					<td class="label">Address:</td>
				</tr>
			</table>
			</div>
		</form>
	</body>
</html>