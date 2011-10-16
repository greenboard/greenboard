<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title><tiles:insertAttribute name="title" defaultValue="Greenboard" /></title>
		<link rel="stylesheet/less" type="text/css" href="<c:url value="/resources/css/greenboard.less"/>"></link>
		<script type="text/javascript" src="<c:url value="/resources/scripts/less-1.1.3.min.js"/>">
		</script>
		<style type="text/css">
			body {
				padding-top: 60px;
			}
		</style>
	</head>
	
	<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />
	</body>
</html>
