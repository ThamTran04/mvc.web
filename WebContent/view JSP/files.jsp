<%@ page import="java.util.List,bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet File Upload/Download</title>
<link rel="stylesheet" href="resource/css/main.css" />
<link rel="stylesheet"
	href="//static.jstree.com/3.3.8/assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#jstree_div').jstree(
				{
					"core" : {
						"animation" : 0,
						"check_callback" : true,
						"themes" : {
							"stripes" : true
						},
					},
					"plugins" : [ "contextmenu", "dnd", "search", "state",
							"types", "wholerow" ]
				});
	});
</script>
<body>
	<div id=jstree_div>
		<ul>
			<li data-jstree='{"opened":false,"selected":true}'>
				${node.fileName}
				<jsp:include page="filesNode.jsp" />
			</li>
		</ul>
	</div>
</body>
</html>