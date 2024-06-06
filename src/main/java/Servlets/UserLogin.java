package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao;
import Dto.Task;
import Dto.User;
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Dao dao = new Dao();
		
		try {
			User u = dao.findbyEmail(email);
			if (u != null) {
				if (u.getUserpassword().equals(password)) {
					
//					List<Task> tasks =dao.getalltaskByUserId(u.getUserId());
//					req.setAttribute("tasks", tasks);
//					System.out.println(tasks+"----------------------");
					
		         	HttpSession session = req.getSession();	
				
					session.setAttribute("user", u);
		
//					req.getSession().setAttribute("user", u);
					
//					req.setAttribute("name-u", u);
					req.getRequestDispatcher("Home.jsp").forward(req, resp);
						
				} else {

					req.setAttribute("message", "incorrect password");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("message", "incorrect email");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
