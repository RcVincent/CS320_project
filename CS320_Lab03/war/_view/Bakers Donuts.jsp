<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Bakers Donuts</title>
<style type="text/css">
#PageName {
	color: white;
	font-size: 250%;
	text-align: center;
	background-color: darkblue;
	font-variant: small-caps;
}
body{
	color: darkblue;
}
#LinkContent {
	float: left;
	border: 1px solid darkblue;
	width: 400px;
	margin-left: 13px;
	margin-top: 13px;
	margin-bottom: 13px;
}

#LinkName {
	color: darkblue;
	font-size: 150%;
	border-bottom: 2px solid darkblue;
	width: 300px;
	margin-left: 13px;
	margin_bottom: 20px;
}

#ContactBody {
	margin-left: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
}

#Content {
	float: left;
}
button {
	margin-top: 3px;
	margin-left: 5px;
	margin-bottom: 5px;
}
div.fixed {
	position: fixed;
	bottom: 10px;
	right: 10px;
}

button {
	margin-top: 3px;
	margin-left: 5px;
	margin-bottom: 5px;
}

.error {
	color: red;
}
#results{
	margin-top: 20px;
	margin-left: 150px;
	width: 50%;
	color: darkblue;
	font-size: 200%;
	text-align: center;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
	float: left;
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
		<div id="PageName">Baker's Donuts</div>

		<div id="Content">

			<div id="LinkContent">
				<div id="LinkName">Home</div>
				<form action="${pageContext.servletContext.contextPath}/Homepage" method="post">
					<table>
							<tr>
								<td><input type="Submit" name="submit" value="Click to go to Homepage"/></td>
							</tr>
						</table>
					</form>
			</div>

			<br>

			<div id="LinkContent">
				<div id="LinkName">Menu</div>
					<form action="${pageContext.servletContext.contextPath}/Menu" method="post">
					<table>
							<tr>
								<td><input type="Submit" name="submit" value="Click to view our menu"/></td>
							</tr>
						</table>
					</form>
			</div>
		<c:if test="${! empty utype}">
			<br>
			<div id="LinkContent">
			<div id="LinkName">Your Orders</div>
				<div>
					<form action="${pageContext.servletContext.contextPath}/RestOrders"
							method="get">
						<table>
							<tr>
								<td><input type="Submit" name="submit" value="Click to view Your Orders"/></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</c:if>
			<br>

		<div class="fixed">
			<button>
				<a href="/lab03/Login">Logout</a>
			</button>
		</div>
</body>
</html>