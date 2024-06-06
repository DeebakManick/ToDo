package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/addtask")
public class AddTask extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    
        // Retrieve and parse request parameters
        int id = Integer.parseInt(req.getParameter("taskid"));
        String tasktitle = req.getParameter("tasktitle");
        String taskdescription = req.getParameter("taskdescription");
        String taskpriority = req.getParameter("taskpriority");
        String taskduedate = req.getParameter("taskduedate");
        
        // Get the User object from the session
        User u = (User) req.getSession().getAttribute("user");
    
        Dao dao = new Dao();
        
        try {
        	  Task task = new Task();
//        	  id, tasktitle, taskdescription, taskpriority, taskduedate, u.getUserId()
        	task.setTaskId(id);
  			task.setTaskTitle(tasktitle);
  			task.setTaskDescription(taskdescription);
  			task.setTaskPriority(taskpriority);
  			task.setTaskDueDate(taskduedate);
  			task.setUserId( u.getUserId());
        	  
        	  
           int res = dao.SaveTask(task);
           
           if(res>0) {
   			HttpSession ses = req.getSession();
   			User us = (User)ses.getAttribute("user");
   			req.setAttribute("tasks", dao.getalltaskByUserId(us.getUserId()));
   			resp.sendRedirect("Home.jsp");
   			}else {
   				resp.getWriter().println("Failed");
   			}
  
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
         
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
