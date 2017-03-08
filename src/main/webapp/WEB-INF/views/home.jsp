<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Welcome to Spittr</h1>
	<form action="<c:url value="/login"/>" method="POST">
	User Name <input type="text"/>
	Password <input type="password"/>
		<input type="submit" value="Sign in"/>
	
	</form>
	<a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>