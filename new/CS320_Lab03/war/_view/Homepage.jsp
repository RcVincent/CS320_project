<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Track N Snack Home</title>
<style type="text/css">
#PageName {
	color: darkblue;
	font-size: 200%;
	text-align: center;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
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

	<form action="${pageContext.servletContext.contextPath}/Homepage" method = "post">

		<div id="PageName">Track N Snack</div>

		<div id="Content">

			<div id="LinkContent">
				<div id="LinkName">Search</div>

				<table>
					<tr>
						<td class="label"></td>
						<td><input type="search" name="search" size="12" required/></td>
						<td><input type="Submit" name="submit" value="Search" /></td>
					</tr>
				</table>
			</div>

			<br>

			<div id="LinkContent">
				<div id="LinkName">Favorites</div>
				<div id="ContentBody">
					<button>
						<a href="/lab03/Favorites">Click here to view favorites</a>
					</button>
				</div>
			</div>

			<br>

			<div id="LinkContent">
				<div id="LinkName">Your Account</div>
				<div id="ContentBody">
					<button>
						<a href="/lab03/Account">Click here to view your account details</a>
					</button>
				</div>
			</div>
		</div>
		<c:if test="${! empty search}">
			<div id="results">Search Results</div>
		</c:if>
		<c:if test="${ empty search}">
			<div id="results">Because Food</div>
		</c:if>
		<div class="fixed">
			<button>
				<a href="/lab03/Login">Logout</a>
			</button>
		</div>
	</form>
</body>
</html>