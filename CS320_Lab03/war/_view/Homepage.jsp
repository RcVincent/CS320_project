<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Track N Snack Home</title>
<style type="text/css">
#SiteName {
	color: darkblue;
	font-size: 200%;
	text-align: center;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
}

#ContactContent {
	float: left;
	border: 1px solid darkblue;
	width: 400px;
	margin-left: 13px;
	margin-top: 13px;
}

#ContactName {
	color: darkblue;
	font-size: 150%;
	border-bottom: 2px solid darkblue;
	width: 300px;
	margin-left: 13px;
}

#ContactBody {
	margin-left: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
}

#Content {
	float: left;
}

#ContentName {
	font-size: 150%;
	border-bottom: 1px solid darkblue;
	color: darkblue;
	margin-top: 13px;
	width: 800px;
}

div.fixed {
	position: fixed;
	bottom: 10px;
	right: 10px;
}

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
		
	<form action="${pageContext.servletContext.contextPath}/Homepage" method = "post">
		<div id="SiteName">Track N Snack</div>

		<div id="ContactContent">
			<div id="ContactName">Search</div>
			
			<div id="ContactBody">
				<input type="search" name="search" value="${search}">

			</div>

		</div>
		<div class="fixed">
			<a href="/lab03/Login"><type = "button"> Logout</a>
		</div>
	</form>
</body>
</html>