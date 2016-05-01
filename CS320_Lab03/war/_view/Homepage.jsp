<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Track N Snack Home</title>
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

.Address {
	font-size: 15px;
}

#Restaurants {
	float: left;
	border: 3px solid darkblue;
	width: 50%;
	margin-left: 150px;
	margin-top: 13px;
	margin-bottom: 13px;
	font-size: 150%;
}

#results {
	margin-top: 20px;
	margin-left: 150px;
	width: 50%;
	color: white;
	font-size: 200%;
	text-align: center;
	background-color: darkblue;
	border-top: 3px solid darkblue;
	border-bottom: 3px solid darkblue;
	font-variant: small-caps;
	float: left;
}

#resultList {
	font-size: 150%;
	text-align: center;
}

td.label {
	text-align: right;
}
</style>
</head>

<body>
	<div id="fb-root"></div>
	<script>
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id))
					return;
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		</script>
	</div>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>


	<div id="PageName">Track N Snack</div>
	<div id="Content">
		<div id="LinkContent">
			<div id="LinkName">Search</div>
			<table>
				<tr>
					<form action="${pageContext.servletContext.contextPath}/Homepage"
						method="post">
						<td class="label"></td>
						<td><input type="search" name="search" size="12"
							placeholder="Search" /></td>
						<td><input type="Submit" name="submit" value="Search" /></td>
						<td><input type="radio" name="searchType" value="city"
							checked>City</td>

					</form>
				</tr>
			</table>
		</div>
		<c:if test="${empty utype}">
		<br>
		<div id="LinkContent">
			<div id="LinkName">Recent Orders</div>
			<div id="ContentBody">
				<div>
					<form
						action="${pageContext.servletContext.contextPath}/RecentOrders"
						method="get">
						<table>
							<tr>
								<td><input type="Submit" name="submit"
									value="Click to view Recent Orders" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		</c:if>
		<br>
		<div id="LinkContent">
			<div id="LinkName">Your Account</div>
			<div>
				<form action="${pageContext.servletContext.contextPath}/Account"
					method="post">
					<table>
						<tr>
							<td><input type="Submit" name="submit"
								value="Click to view Account Info" /></td>
						</tr>
					</table>
				</form>
			</div>

		</div>
		
		<br>
		<div class="fb-like" data-href="http://localhost:8081/lab03/Homepage"
			data-width="50" data-layout="button" data-action="recommend"
			data-show-faces="false" data-share="false"></div>
		<br>
		<br> <a href="https://twitter.com/tracksnack"
			class="twitter-follow-button" data-show-count="false">Follow
			@tracksnack</a>
		<script>
			!function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
						.test(d.location) ? 'http' : 'https';
				if (!d.getElementById(id)) {
					js = d.createElement(s);
					js.id = id;
					js.src = p + '://platform.twitter.com/widgets.js';
					fjs.parentNode.insertBefore(js, fjs);
				}
			}(document, 'script', 'twitter-wjs');
		</script>

		<c:if test="${! empty utype}">
			<br>
			<div id="LinkContent">
				<div id="LinkName">Your Restaurants</div>
				<div>
					<form action="${pageContext.servletContext.contextPath}/OwnerPage"
						method="get">
						<table>
							<tr>
								<td><input type="Submit" name="submit"
									value="Click to view Your Restaurants" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
	</div>
	</c:if>
	</div>
	<c:if test="${! empty rest}">
		<div id="results">Search Results</div>
		<div id="Restaurants">
			<c:forEach items="${rest}" var="restaurant">
				<div id="LinkContent">
					<div id="LinkName">${restaurant.name}</div>
					<table>
						<tr>
							<td class="Address">${restaurant.address },</td>
							<td class="Address">${restaurant.city },</td>
							<td class="Address">${restaurant.zipCode }</td>
							<form
								action="${pageContext.servletContext.contextPath}/${restaurant.name }"
								method="post">
								<td><input type="submit" value="Click to view page"></td>
							</form>
						</tr>
					</table>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<c:if test="${ empty rest}">
		<div id="results">Make America Fat Again</div>
	</c:if>
	<div class="fixed">
		<button>
			<a href="/lab03/Login"><type="button">Logout </a>
		</button>
</body>
</html>