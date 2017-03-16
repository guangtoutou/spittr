<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>Spittles</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/style.css" />">
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
</head>
<body>
<c:url value="/spittles.json" var="JsonUrl" />

<h1>有什么新鲜事想告诉大家</h1>
<input type="text"/>
<input type="button" value="提交"/>
<div id="loading">努力加载中...</div>
<ul id="spittleList">
</ul>	
<table id="spittlesTable" class="display">

</table>
	<script type="text/javascript">

		
	$(document).ready(function() {
		fetchSpittles();
		
	})


	function fetchSpittles(){
		$.getJSON('${JsonUrl}',{name:"james"},function( json ) {
/*		for(i=0;i<json.length;i++){
	    	var time = new Date();
	    	time.setTime(json[i].time);
	    	var spitter = "<span class='fullName'>"+json[i].spitter.fullName+"</span>"
	    	var message = "<div class='message'>"+json[i].message+"</div>";
			var timeStamp = "<span class='spittleTime'>"+time.toLocaleDateString()+" "+time.toLocaleTimeString()+"</span>";
			$("#spittleList" ).append("<li class='spittle'>"+spitter+message+timeStamp+"</li>");
	     }*/
		
	     $("#spittlesTable").DataTable({
	    	    data: json,
	    	    columns: [
	    	        { "data": "id" },
	    	        { "data": "message" },
	    	        { "data": "time" },
	    	        { "data": "spitter.fullName" }
	    	    ],
	            "columnDefs": [
	                {
	                    // The `data` parameter refers to the data for the cell (defined by the
	                    // `data` option, which defaults to the column being worked with, in
	                    // this case `data: 0`.
	                    "render": function ( data, type, row ) {
	                        var time = new Date();
	                        time.setTime(data);
	                    	return time.toLocaleDateString();
	                    },
	                    "targets": 2
	                }
	     		]
	     });
	     
	     $("#loading").hide();
		});
	}
		</script>
</body>
</html>