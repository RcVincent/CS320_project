<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Wag's ribs</title>
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
.Address {
	font-size: 15px;
	font-color: black;
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
		<div id="PageName">Owner Page</div>
	<div id="Content">
		<div id="Restaurants">
			<c:forEach items="${rest}" var="restaurant">
				<div id="LinkContent">
					<div id="LinkName">${restaurant.name}</div>
					<table>
						<tr>
							<td class = "Address">${restaurant.address },</td>
							<td class = "Address">${restaurant.city },</td>
							<td class = "Address">${restaurant.zipCode }</td>
							<form action="${pageContext.servletContext.contextPath}/${restaurant.name }" method="get">
								<td><input type="submit" value="Click to view your page"></td>
							</form>
						</tr>
					</table>
				</div>
				<br>
			</c:forEach>
			<form action="${pageContext.servletContext.contextPath}/Homepage" method="post">
					<input type="Submit" name="submit" value="Click to go to Homepage"/>
			</form>
		</div>
	</div>

		<div class="fixed">
			<button>
				<a href="/lab03/Login">Logout</a>
			</button>
		</div>
</body>
</html>