<%@page import="Dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="bigimg">
		<%
		Task task = (Task) request.getAttribute("task");
		%>
		<form action="updatetasks" method="post">
			Task Id:<input type="text" name="taskid" hidden=""
				value="<%=task.getTaskId() %>"> <br> 
				Task Title:<input
				type="text" name="tasktitle" value="<%=task.getTaskTitle() %>"
				> <br> 
				Task Description:<input type="text"
				name="taskdescription" value="<%=task.getTaskDescription() %>">
			<br> Current Task Priority:
			<h4><%=task.getTaskPriority() %></h4>
			<label for="option1"> <input type="radio" id="option1"
				value="low" name="taskpriority"> Low
			</label> <br> <label for="option2" id="on"> <input type="radio"
				id="option2" value="medium" name="taskpriority"> Medium
			</label> <br> <label for="option3"> <input type="radio"
				id="option3" value="high" name="taskpriority"> High
			</label> <br>  <br>
			<input type="text" hidden="" name="userid"
				value="<%=task.getUserId() %>"> <br>
			 Due Date:<input type="date" name="taskduedate"
				value="<%=task.getTaskDueDate() %>"> <br>  <input
				type="submit">
		</form>

	</div>

</body>
</html>