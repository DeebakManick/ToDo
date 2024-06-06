package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import Dto.Task;

@WebServlet("/edit")
public class EditTask extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskid = Integer.parseInt(req.getParameter("id"));
		Dao dao = new Dao();
		
		try { 
			Task task =dao.findbyId(taskid);	
			req.setAttribute("task",task);
			req.getRequestDispatcher("Edittask.jsp").forward(req, resp);
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
}
