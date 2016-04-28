<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Your Account</title>
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
			text-align: right;
			align: center;
		}
		table{
			border-spacing: 10px;
		}
		</style>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/Account" method="post">
			<div id = "PageName">Your Account</div>
			<div id = "AccountInfo">
			<table>
				<tr>
					<td class="label">First name:</td>
					<td>${firstname}</td>
				</tr>
				<tr>
					<td class="label">Last name:</td>
					<td>${lastname}</td>
				</tr>
				<tr>
					<td class="label">Username:</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td class="label">Account Type:</td>
					<td>${AccountType}</td>
				</tr>
			</table>
			</div>
		</form>
	</body>
</html>