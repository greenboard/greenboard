<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>

<tags:template>
	<jsp:body>
		Hello and welcome to the ${board.name eq null ? 'GreenBoard' : board.name}
		<!-- TODO replace /greenboard/ with root context as a variable -->
		<form action="/greenboard/board/new" method="POST" name="newBoard" id="newBoard" class="mainForm">
			<input type="text" name="name" id="name" placeholder="Enter the boards name">
			<input type="text" name="description" id="description" placeholder="Enter a description for the new board">
			<input type="submit" name="submit" id="submit">
		</form>
	</jsp:body>
</tags:template>
