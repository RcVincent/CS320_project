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
					<td class="label">eMail:</td>
					<td>${email}</td>
				</tr>
				<tr>
					<td class="label">Account Type:</td>
					<td>${AccountType}</td>
				</tr>
				<tr><form action="${pageContext.servletContext.contextPath}/Homepage" method="get">
					<td><input type="Submit" name="submit" value="Click to go to Homepage"/></td>
					</form>
				</tr>
				<tr><form action="${pageContext.servletContext.contextPath}/ChangeUsername" method="get">
					<td><input type="Submit" name="submit" value="Click to change your username"/></td>
					</form>
				</tr>
			</table>
			</div>
		
	</body>
</html>