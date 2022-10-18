package com.rakuten.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;
import com.rakuten.dto.Client;
import com.rakuten.util.DataBaseUtil;

public class ClientModel {
	public boolean addClient(Client client){
	boolean flag = false;
	Integer id = client.getId();
	String name = client.getName();
	String emailId = client.getEmailId();
	String role = "CLIENT";
	String password = client.getPassword();
	Date createdDate = new Date();
	String createdBy = client.getCreatedBy();
	Date modifieDate = client.getModifieDate();
	String modifieBy = client.getModifieBy();
	
	
	try{
		Connection con = DataBaseUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user(name, emailId, role, password, created_Date, created_by)values(?, ?, ?, ?, ?, ?)");
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
public boolean loginClient(Client client){
	boolean flag = false;
	
	String emailId = client.getEmailId();
	String password = client.getPassword();
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBookStoreShop", "root", "root");
		PreparedStatement ps = con.prepareStatement("select emailId, password from user where emailId = ? and password = ?");
		ps.setString(1, emailId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			flag = true;
		}
		con.close();
		
	}
	catch(ClassNotFoundException cnfe){
		cnfe.printStackTrace();
	}
	catch(SQLException se){
		se.printStackTrace();
		
		
	}
	return flag;
	
}
public Client findClient(String clientName){
	Client client = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBookStoreShop", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from user where name = ?");
		ps.setString(1, clientName);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Integer id = rs.getInt("id");
			String emailId = rs.getString("emailId");
			String role = rs.getString("role");
			Date createdDate = rs.getDate("createdDate");
			String createdBy = rs.getString("createdBy"); 
			Date modifieDate = rs.getDate("modifieDate");
			String modifieBy = rs.getString("modifieBy");
			client = new Client();
			client.setId(id);
			client.setEmailId(emailId);
			client.setRole(role);
			client.setCreatedDate(createdDate);
			client.setCreatedBy(createdBy);
			client.setModifieDate(modifieDate);
			client.setModifieBy(modifieBy);
			client.setName(clientName);
			
		}
		con.close();
	}
	catch(ClassNotFoundException cnfe){
		cnfe.printStackTrace();
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	
	return client;
	
}
}
