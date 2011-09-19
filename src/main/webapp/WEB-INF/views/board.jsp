<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="false" %>

<tags:template>
	<jsp:body>
		Hello and welcome to the ${board.name eq null ? 'GreenBoard' : board.name}
	</jsp:body>
</tags:template>
