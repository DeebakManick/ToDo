package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao;
import Dto.Task;
import Dto.User;
@WebServlet("/updatetasks")
public class updatetask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int   taskid = Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdescription = req.getParameter("taskdescription");
		String taskpriority = req.getParameter("taskpriority");
		String taskduedate = req.getParameter("taskduedate");	
    	int userid = Integer.parseInt(req.getParameter("userid"));
		
//		System.out.println("---------------------");
		    Task task = new Task( );
		    task.setTaskId(taskid);
		    task.setTaskTitle(tasktitle);
		    task.setTaskDescription(taskdescription);
		    task.setTaskPriority(taskpriority);
		    task.setTaskDueDate(taskduedate);
		    task.setUserId(userid);
		    Dao dao = new Dao();
		 
	try {
			int res = dao.updatetask(task);
			if(res>0) {
				HttpSession ses = req.getSession();
//				User user = (User) ses.getAttribute("user");
				User use = (User) req.getSession().getAttribute("user");
				req.setAttribute("tasks", dao.getalltaskByUserId(use.getUserId()));		
				resp.sendRedirect("Home.jsp");
			}else {
				resp.getWriter().print("Somthing Wrong");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

