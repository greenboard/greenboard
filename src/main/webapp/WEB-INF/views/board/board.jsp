<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>

<div class="board">
	Hello and welcome to the ${board.name eq null ? 'GreenBoard' : board.name}
</div>
