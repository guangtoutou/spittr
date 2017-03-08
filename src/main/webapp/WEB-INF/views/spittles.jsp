<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittles</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/style.css" />">
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
</head>
<body>
			<c:url value="/spittles.json" var="JsonUrl" />

<h1>hello</h1>
<ul id="spittleList">
</ul>	
	<script type="text/javascript">

		
	$(document).ready(function() {
		fetchSpittles();
	})


	function fetchSpittles(){
		$.getJSON('${JsonUrl}',function( json ) {
	     for(i=0;i<json.length;i++){
	    	 var messageHTML = "<div class='message'>"+json[i].message+"</div>";
	    	 var messageTimestamp = "<span class='spittleTime'>"+json[i].time+"</span><span class='fullName''>"+json[i].spitter.fullName+"</span>";
			$("#spittleList" ).append("<li class='spittle'>"+messageHTML+messageTimestamp+"</li>");
	     }
		})
	}
		</script>
</body>
</html>