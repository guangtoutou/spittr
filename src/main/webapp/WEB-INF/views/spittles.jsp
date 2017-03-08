<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittles</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/style.css" />">
</head>
<body>
	<c:forEach items="${spittleList}" var="spittle">
		<li id="spittle_<c:out value="spittle.id"/>" class="spittle">
			<div class="spittleMessage">
				<c:out value="${spittle.message}" />
			</div>
			<div>
				<span class="spittleTime"><c:out value="${spittle.time}" /></span>
				<span class="spitterName"><c:out value="${spittle.spitter.id}" /></span>
			</div>
		</li>
	</c:forEach>
</body>
</html>