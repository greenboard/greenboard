<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="hidesearch" required="false" rtexprvalue="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Welcome to the Board...</title>
	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/cupertino/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/greenboard.css" rel="stylesheet" />	
	<script data-main="${pageContext.request.contextPath}/resources/scripts/main" src="${pageContext.request.contextPath}/resources/scripts/require-jquery.js"></script>
</head>
<body>
	<div class="header">
		<h1>Greenboard</h1>
	</div>
	<div class="body">
		<jsp:doBody/>
	</div>
	<div class="footer"/>
</body>
</html>
