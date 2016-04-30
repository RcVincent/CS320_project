<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Add an item</title>
<style type="text/css">
.error {
	color: blue;
}
td.label {
	text-align: right;
}
button{
	margin-top: 2px;
}
#PageName {
	color: white;
	font-size: 250%;
	text-align: center;
	background-color: darkblue;
	font-variant: small-caps;
}
#logon {
    margin: 50px auto;
	border: 1px solid darkblue;
	width: 400px;
	padding: 10px;
}
#Content {
	float: left;
}
</style>
</head>

<body>
	<div id="PageName">Add to your menu</div>	
	<form action="${pageContext.servletContext.contextPath}/AddItem" method="post">
		
		<div id = "Add an Item to the menu">

		<table>
			
				<c:if test="${! empty message}">
					<tr>
					   <td><class="error">${message}</class></td>
					</tr>
				</c:if>
			<tr>
				<td class="label">Item:</td>
				<td><input type="text" name="item" size="12" /></td>
			</tr>
			<tr>
				<td class="label">Price:</td>
				<td><input type="text" name="price" size="12"  /></td>
			</tr>
		</table>
		<div>
			<input type="Submit" name="submit" value="Add Item" />
		</form>
		</div>
		<div>
			<form action="${pageContext.servletContext.contextPath}/Menu" method="post">
			<input type="Submit" name="submit" value="Cancel" />
			</form>
		</div>
		</div>
</body>
</html>