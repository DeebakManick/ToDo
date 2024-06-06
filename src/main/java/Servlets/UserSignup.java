package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Dao;
import Dto.User;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class UserSignup extends HttpServlet  {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =  Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name");
		String email = req.getParameter("mail");
		long contact = Long.parseLong(req.getParameter("contact"));
		String password = req.getParameter("pass");
		
		Part image = req.getPart("userimage");
		byte[] imagebytes = image.getInputStream().readAllBytes();
		
		User u = new User();
		u.setUserId(id);
		u.setUsername(name);
		u.setUseremail(email);
        u.setUsercontact(contact);
        u.setUserpassword(password);
        u.setUserimage(imagebytes);
		
		Dao dao = new Dao();
		
	try {
		dao.SaveUser(u);
		resp.sendRedirect("login.jsp");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	}

}
