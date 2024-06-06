package DAO;

import java.awt.List;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.sql.*;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.jdbc.Blob;

import Dto.Task;
import Dto.User;

public class Dao {

	public Connection getconnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/office?user=root&password=root");

		return con;

	}

	public int SaveUser(User user) throws ClassNotFoundException, SQLException {

		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?,?,?)");

		pst.setInt(1, user.getUserId());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(5, user.getUserpassword());
		
		java.sql.Blob image = new SerialBlob(user.getUserimage());
		pst.setBlob(6, image);

		return pst.executeUpdate();

	}

	public User findbyEmail(String email) throws ClassNotFoundException, SQLException {

		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("select * from user where useremail=?");
		pst.setString(1, email);

		ResultSet rs = pst.executeQuery();

		User u = new User();

		if (rs.next()) {
			u.setUserId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(5));
			java.sql.Blob b = rs.getBlob(6);
			byte[] image = b.getBytes(1, (int)b.length());
			u.setUserimage(image);
			return u;

		}

		return null;
	}

	
	public Task findbyId(int taskId) throws ClassNotFoundException, SQLException {

		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("select * from task where taskid=?");
		pst.setInt(1, taskId);

		ResultSet rs = pst.executeQuery();
		
           Task t = new Task();

		if (rs.next()) {
			t.setTaskId(taskId);
			t.setTaskTitle(rs.getString(2));
			t.setTaskDescription(rs.getString(3));
			t.setTaskPriority(rs.getString(4));
			t.setTaskDueDate(rs.getString(5));
		    t.setUserId(rs.getInt(6));
			
			return t;

		}

		return null;
	}
	
	
	public int SaveTask(Task t) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("insert into task values(?,?,?,?,?,?)");

		pst.setInt(1, t.getTaskId());
		pst.setString(2,t.getTaskTitle());
		pst.setString(3, t.getTaskDescription());
		pst.setString(4, t.getTaskPriority());
		pst.setString(5, t.getTaskDueDate());
		pst.setInt(6, t.getUserId());	
		return pst.executeUpdate();

	}

	public int deleteTask(int taskId) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("delete from task where taskid= ?");

		pst.setInt(1, taskId);

		int value = pst.executeUpdate();

		return value;
	}

	public java.util.List<Task> getalltaskByUserId(int userId) throws SQLException, ClassNotFoundException {
		Connection con = getconnection();

		PreparedStatement pst = con.prepareStatement("select * from task where UserId= ?");

		pst.setInt(1, userId);

		ResultSet rs = pst.executeQuery();

		java.util.List <Task> li = new ArrayList<Task>();

		while (rs.next()) {
			Task t = new Task();
//			rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)
			t.setTaskId(rs.getInt(1));
			t.setTaskTitle(rs.getString(2));
			t.setTaskDescription(rs.getString(3));
			t.setTaskPriority(rs.getString(4));
			t.setTaskDueDate(rs.getString(5));
			t.setUserId(rs.getInt(6));
			
			li.add(t);

		}

		return li;

	}
	
	
public int updatetask (Task task) throws ClassNotFoundException, SQLException {
	
	Connection con = getconnection();
	
	PreparedStatement pst = con.prepareStatement("update task set taskTitle=?,taskDescription=?,taskPrority=?,taskDueDate=?,UserId=? where taskid=?");
	
	pst.setString(1,task.getTaskTitle());
	pst.setString(2, task.getTaskDescription());
	pst.setString(3, task.getTaskPriority());
	pst.setString(4, task.getTaskDueDate());
	 pst.setInt(5, task.getUserId());
	pst.setInt(6,task.getTaskId());
	
	return pst.executeUpdate();
	
}
	
	

}
