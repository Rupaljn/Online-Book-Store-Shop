package com.rakuten.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.omg.CORBA.Request;

import com.rakuten.dto.Admin;
import com.rakuten.util.DataBaseUtil;

public class AdminModel {
public boolean addAdmin(Admin admin){
	boolean flag = false;
	
	Integer id = admin.getId();
	String name = admin.getName();
	String emailId = admin.getEmailId();
	String role = "ADMIN";
	String password = admin.getPassword();
	Date createdDate = new Date();
	String createdBy = admin.getCreatedBy();
	try{
		Connection con = DataBaseUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user(id, name, emailId, role, password, created_Date, created_By) values(?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, name);
		ps.setString(2, emailId);
		ps.setString(3, role);
		ps.setString(4, password);
		ps.setDate(5, new java.sql.Date(createdDate.getTime()));
		ps.setString(6, createdBy);
		int row = ps.executeUpdate();
		if(row>0){
			flag = true;
		}
		con.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
	
	
		return flag;
}

public boolean loginAdmin(Admin admin){
	boolean flag = false;
	
	String emailId = admin.getEmailId();
	String password = admin.getPassword();
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBookStoreShop", "root", "root");
		PreparedStatement ps = con.prepareStatement("select emailId, password from user where emailId = ? and password = ?");
		ps.setString(1, emailId);
		ps.setString(2, password);
	    ResultSet  rs = ps.executeQuery(); 
		if(rs.next()){
			flag = true;
		}
		con.close();
	}
	catch(ClassNotFoundException cn){
		cn.printStackTrace();
	 }
	catch(SQLException se){
		se.printStackTrace();
	}
	return flag;
}

}
