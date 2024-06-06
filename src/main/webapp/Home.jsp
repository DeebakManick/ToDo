<%@page import="Dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="Dto.User"%>
<%@page import="com.mysql.cj.Session"%>
<%@page import="DAO.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="./font-awesome.min.css">
</head>
<body>

<style>
*{
font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
#img{
height: 60px;
width:60px;
margin-left: 500x;
}

a{
text-decoration: none;
}


#nav{
    
    display: flex;
    border: 1px solid black;
    background-color: black;
    color: white;  
    height: 90px;
    width: 100%;
    margin: 0px;
    justify-content: center;
    align-items: center;
  
}

#logout{

           color: white;
           border-radius: 10px;
           padding: 10px;
           font-weight: bolder;
           font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
           text-decoration: none;
         
}


#profile{

 color: white;
           border-radius: 10px;
           padding: 10px;
           font-weight: bolder;
           font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
           text-decoration: none;
}

#prf{

   margin-left: 800px;

}

</style>

	<%
		User user = (User) request.getSession().getAttribute("user");
		%>
					<div id="nav">
			<h2 id="name" class="bt">
				Welcome <%=user.getUsername() %> !!</h2>
	
			
				<%
				String image = new String(Base64.getEncoder().encode(user.getUserimage()));
				%>
				
				<div id="prf">
				
				<img alt="" src="data:image/jpeg;base64,<%=image%>" id="img" class="rounded-circle mw-100">
				
			<a id="profile" href="profile.jsp">Profile</a></div>	<a id="logout" href="logout">Logout</a>
			
		</div>
	
		
	<%int userid =user.getUserId(); %>
		
		<%Dao dao=new Dao(); 
		List<Task> tasks = dao.getalltaskByUserId(userid);%>
	
	<div id="table">
		<h3 id="tasm">Tasks</h3>
			    <table  class="table">
        <thead class="dark">
        <tr>

            <th scope="col" >TaskNumber</th>
            <th scope="col">TaskID</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Priority</th>
            <th scope="col">Due Date</th>					
            <th scope="col">Delete</th>
            <th scope="col">Edit</th>

           </tr>
        </thead>
        <% int num = 1; %>
        <%
        for (Task task : tasks) {
        %>
        <tr border="2px">
            <th scope="row"><%=num%></th>
            <td><%=task.getTaskId() %>
            <td><%=task.getTaskTitle()%></td>
            <td><%=task.getTaskDescription() %></td>
            <td><%=task.getTaskPriority()%></td>
            <td><%=task.getTaskDueDate()%></td>

            <td><a href="delete?taskid=<%=task.getTaskId()%>">Delete</a>
            <td> <a href="edit?id=<%= task.getTaskId()%>">UpdateTask</a></td>
            </td>
        </tr>
            <% num=num+1; %>
        <%}	%>
    </table>

			
		</div>	
	</div>
<a href="addTask.jsp">AddTask</a>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="./bootstrap.esm.min.js">
    </script>
</body>
</html>


	