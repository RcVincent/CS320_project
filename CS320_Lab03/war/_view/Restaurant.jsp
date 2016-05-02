<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>${restaurant}</title>
<style type="text/css">
#PageName {
	color: white;
	font-size: 250%;
	text-align: center;
	background-color: darkblue;
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
	width: 350px;
	margin-left: 13px;
	margin_bottom: 20px;
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

</style>
</head>

<body>


	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>

		<div id="PageName">${restaurant}</div>



	<div id="Content">
		<div id="LinkContent">
			<div id="LinkName">Home</div>
			<form action="${pageContext.servletContext.contextPath}/Homepage"
				method="get">
				<table>
					<tr>
						<td><input type="Submit" name="submit"
							value="Click to go to Homepage" /></td>
					</tr>
				</table>
			</form>
		</div>

		<br>

		<div id="LinkContent">
			<div id="LinkName">Menu</div>
			<form action="${pageContext.servletContext.contextPath}/Menu"
				method="get">
				<table>
					<tr>
						<td><input type="Submit" name="submit"
							value="Click to view our menu" /></td>
					</tr>
				</table>
			</form>
		</div>
		<c:if test="${ empty utype}">
		<br>
		<div id="LinkContent">
			<div id="LinkName">Add ${restaurant} to Favorites</div>
			<form action="${pageContext.servletContext.contextPath}/Favorites" method="get">
				<table>
					<tr>
						<input type="hidden" name="restaurant" id="restaurant" value="${restaurant}">
						<td><input type="Submit" name="submit" value="Click to add to favorites" /></td>
					</tr>
				</table>
			</form>
		</div>
		</c:if>
		<c:if test="${! empty utype}">
			<br>
			<div id="LinkContent">
				<div id="LinkName">Your Orders</div>
				<div>
					<form action="${pageContext.servletContext.contextPath}/RestOrders"
						method="get">
						<table>
							<tr>
								<td><input type="Submit" name="submit"
									value="Click to view Your Orders" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</c:if>
		<br> <a href="https://twitter.com/share"
			class="twitter-share-button" data-via="krum_austin" data-size="large"
			data-hashtags="sweetJSPs">Tweet</a>
		<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';
		if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+':
		//platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>

		<div class="fixed">
			<button>
				<a href="/lab03/Login">Logout</a>
			</button>
		</div>
</body>
</html>