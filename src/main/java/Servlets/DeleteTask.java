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

@WebServlet("/delete")
public class DeleteTask extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt( req.getParameter("taskid"));
		
		Dao dao = new Dao();
		
		try 
		{
		    dao.deleteTask(id);
		    
		    HttpSession session = req.getSession();
			User u =(User)session.getAttribute("user");
			
			req.setAttribute("tasks", dao.getalltaskByUserId(u.getUserId()));
			
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.include(req, resp);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}