<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<form action="addtask" method="post" >
				Task Id:<input type="text" name="taskid" > <br>
				Task Title :<input type="text" name="tasktitle" required class="bn"> <br>
				Task Description :<input type="text" name="taskdescription"  class="bn"> <br>
				
				<div id="hos">
					Options: <br>
				<label for="option1" >
					<input type="radio" id="option1" value="low" name="taskpriority" > Low
				</label> <br>
				<label for="option2" id="on">
					<input type="radio" id="option2" value="medium" name="taskpriority" id="ob" > Medium
				</label> <br> 
				
				<label for="option3" >
					<input type="radio" id="option3" value="high" name="taskpriority" > High
				</label> <br>
				
				</div>
				
				Due Date :<input type="date" name="taskduedate" class="bn"> <br>
				
				<input type="submit" class="bn" id="btn">
		</form>
		
		</div>

</body>
</html>