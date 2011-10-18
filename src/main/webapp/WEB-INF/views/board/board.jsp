<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<div class="board">
	Hello and welcome to the ${board.name eq null ? 'GreenBoard' : board.name}
	<form action="<c:url value="/board/new"/>" method="POST" name="newBoard" id="newBoard" class="mainForm">
		<input type="text" name="name" id="name" placeholder="Enter the boards name">
		<input type="text" name="description" id="description" placeholder="Enter a description for the new board">
		<input type="submit" name="submit" id="submit">
	</form>
</div>

